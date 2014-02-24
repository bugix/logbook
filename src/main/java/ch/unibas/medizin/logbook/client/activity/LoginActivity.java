package ch.unibas.medizin.logbook.client.activity;

import static ch.unibas.medizin.logbook.shared.util.UtilityLogBook.DECIMAL_FORMAT;
import static ch.unibas.medizin.logbook.shared.util.UtilityLogBook.getEmptyStringIfNull;
import static ch.unibas.medizin.logbook.shared.util.UtilityLogBook.join;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import ch.unibas.medizin.logbook.client.navigation.LogBookNav;
import ch.unibas.medizin.logbook.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.proxy.SkillAcquiredProxy;
import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.request.StudentRequest;
import ch.unibas.medizin.logbook.client.ui.StudentEditPopupViewImpl;
import ch.unibas.medizin.logbook.client.ui.StudentInformationView;
import ch.unibas.medizin.logbook.client.ui.StudentInformationViewImpl;
import ch.unibas.medizin.logbook.client.widget.CustomProgressbar;
import ch.unibas.medizin.logbook.shared.constant.LogBookConstant;
import ch.unibas.medizin.logbook.shared.enums.StudentStatus;
import ch.unibas.medizin.logbook.shared.enums.StudyYears;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;
import ch.unibas.medizin.logbook.shared.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class LoginActivity extends AbstractActivity implements StudentInformationView.presenter, StudentInformationView.Delegate {
	private LogBookRequestFactory requests;
	private AcceptsOneWidget widget;
	private StudentInformationView view;
	public static StudentEditPopupViewImpl popupViewImpl;
	private Timer errorMessageTimer;

	String message = "";

	public HandlerManager handlerManager;

	public int currenttab = 0;

	LogBookConstants constants = GWT.create(LogBookConstants.class);

	// Home Tab Skill Acquired Table Members
	CellTable<SkillAcquiredProxy> table;
	public String sortorder = "DESC";

	public LoginActivity(LogBookRequestFactory requests, PlaceController placeController, LoginPlace loginPlace) {
		Log.debug("Call Activity Login");

		this.requests = requests;
		this.handlerManager = loginPlace.handler;

		LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(0, false);
	}

	public LoginActivity(LogBookRequestFactory requests, PlaceController placeController) {
		Log.debug("Call Activity Login..");
		this.requests = requests;

		LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(0, false);
	}

	public void onStop() {
		widget.setWidget(null);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.debug("SystemStartActivity.start()");
		this.widget = panel;
		init();
		errorMessageTimer = new Timer() {

			@Override
			public void run() {
				view.getHpErrorMessage().setVisible(false);
			}
		};
		
		errorMessageTimer.scheduleRepeating((int) (LogBookConstant.ERROR_MESSAGE_TIME));
	}

	private void init() {
		StudentInformationView systemStartView = new StudentInformationViewImpl();
		systemStartView.setPresenter(this);
		this.view = systemStartView;

		widget.setWidget(systemStartView.asWidget());

		// Fix in default style( without it tab content will not show properly)
		systemStartView.asWidget().getElement().getParentElement().getParentElement().getStyle().setPosition(Position.RELATIVE);

		view.setDelegate(this);

		initStudentInfo(); // Initialize StudentInformation
		intiSkillTableRange();
	}

	private void intiSkillTableRange() {
		table = view.getTable();
		table.addRangeChangeHandler(new RangeChangeEvent.Handler() {
			public void onRangeChange(RangeChangeEvent event) {
				onRangeChanged();
			}
		});

		table.addColumnSortHandler(new ColumnSortEvent.Handler() {
			@Override
			public void onColumnSort(ColumnSortEvent event) {

				if (event.isSortAscending()) {
					sortorder = "ASC";
				} else {
					sortorder = "DESC";
				}
				Log.debug("Call Init Search from addColumnSortHandler");
				intiSkillTable("skill.shortcut");
			}
		});

		table.setColumnWidth(table.getColumn(0), "70%");
		table.setColumnWidth(table.getColumn(1), "20%");
		table.setColumnWidth(table.getColumn(2), "10%");

		table.addColumnStyleName(1, "skillTableShortcutColumnStyle");
	}

	private void intiSkillTable(String sortBy) {
		Log.debug("Init Table ");

		Log.debug("Student Proxy: " + view.getStudentProxy().getId());

		final Range range = table.getVisibleRange();
		Log.debug("Start Range: " + range.getStart());
		Log.debug("Range Length: " + range.getLength());

		requests.skillAcquiredRequestNonRoo().findCountLatestAcquiredSkillByStudent(view.getStudentProxy().getId(), LogBookConstant.TOTAL_SKILL_ACQUIRED_DISPLAY, sortorder, sortBy)
				.with("skill", "skillLevel", "skill.topic", "skill.topic.classificationTopic", "skill.topic.classificationTopic.mainClassification").fire(new Receiver<Integer>() {

					@Override
					public void onSuccess(Integer response) {
						table.setRowCount(response, true);
					}

				});

		requests.skillAcquiredRequestNonRoo().findLatestAcquiredSkillByStudent(view.getStudentProxy().getId(), sortorder, sortBy, range.getStart(), range.getLength())
				.with("skill", "skillLevel", "skill.topic", "skill.topic.classificationTopic", "skill.topic.classificationTopic.mainClassification").fire(new Receiver<List<SkillAcquiredProxy>>() {

					@Override
					public void onSuccess(List<SkillAcquiredProxy> response) {
						Log.debug("Total Skill Acquired By Student: " + response.size());

						table.setRowData(range.getStart(), response);
					}

					@Override
					public void onConstraintViolation(java.util.Set<javax.validation.ConstraintViolation<?>> violations) {
						super.onConstraintViolation(violations);
						Log.debug("Violation");
					};

					@Override
					public void onFailure(ServerFailure error) {
						super.onFailure(error);
						Log.debug("Failure");
					}

				});
	}

	protected void onRangeChanged() {
		Log.debug("range change for role topic ");
		intiSkillTable("created");
	}

	private void initStudentInfo() {
		view.getHpErrorMessage().setVisible(false);
		requests.studentRequestNonRoo().findStudentFromSession().fire(new Receiver<StudentProxy>() {
			@Override
			public void onSuccess(StudentProxy studentProxy) {
				Log.debug("Success");
				view.setStudentProxy(studentProxy);

				if (studentProxy.getStudentStatus() == StudentStatus.UnFinalized)
					view.getBtnFinalizeLogBook().setDown(false);
				else if (studentProxy.getStudentStatus() == StudentStatus.Fianllized)
					view.getBtnFinalizeLogBook().setDown(true);
				else if (studentProxy.getStudentStatus() == StudentStatus.Exported)
					view.getBtnFinalizeLogBook().setEnabled(false);

				intiPersonnelInformation(studentProxy); // Set Value to
														// Personnel Information
														// Panel i.e. Student
														// Name, Study Year
														// etc..
				intiCurrentProgressInformation(studentProxy); // Set aValue to
																// Current
																// Progress
																// Information
																// Panel i.e.
																// Total Level 1
																// and Level 2
																// Skill
																// Acquired
				intiSkillTable("created");

			}

			@Override
			public void onConstraintViolation(java.util.Set<javax.validation.ConstraintViolation<?>> violations) {
				super.onConstraintViolation(violations);
				Log.debug("Violation");
			};

			@Override
			public void onFailure(ServerFailure error) {
				super.onFailure(error);
				Log.debug("Failure");
			}
		});
	}

	protected void intiCurrentProgressInformation(StudentProxy studentProxy) {
		Log.debug("intiCurrentProgressInformation Student Id: " + studentProxy.getId());

		if (studentProxy.getStudentStatus() != null && studentProxy.getStudentStatus().equals(StudentStatus.Exported)) {
			view.getBtnFinalizeLogBook().setEnabled(false);

		}
		final long studentId = studentProxy.getId();
		// Find Total Skill for Level 1 and Level 2
		requests.skillRequestNonRoo().findCountOfSkillBySkillLevel().fire(new Receiver<List<Long>>() {

			@Override
			public void onSuccess(final List<Long> totalSkillListByLevel) {
				Log.debug("Success");
				Log.debug("Total Skills By Level : " + join(totalSkillListByLevel, ","));

				if (totalSkillListByLevel.size() == 2) {
					requests.skillAcquiredRequestNonRoo().findTotalSkillAcquiredByStudentLevelVise(studentId).fire(new Receiver<List<Long>>() {

						@Override
						public void onSuccess(List<Long> totalSkillAcquiredBySkillLevel) {
							Log.debug("Success");
							Log.debug("Total Acquired Skills By Level : " + join(totalSkillAcquiredBySkillLevel, ","));

							if (totalSkillAcquiredBySkillLevel.size() == 2) {
								// total percentage Of Skill Acquired for level
								// 1
								float totalPercentageLevel1 = totalSkillListByLevel.get(0) == 0 ? totalPercentageLevel1 = 0.0f : ((totalSkillAcquiredBySkillLevel.get(0) / (float) totalSkillListByLevel.get(0)));
								String level1SkillAcquiredPercentage = constants.level1() + ": " + totalSkillAcquiredBySkillLevel.get(0) + " " + constants.of() + " " + totalSkillListByLevel.get(0) + " " + constants.skill() + " (" + DECIMAL_FORMAT.format(totalPercentageLevel1)
										+ ")";

								float totalPercentageLevel2 = totalSkillListByLevel.get(1) == 0.0f ? totalPercentageLevel2 = 0.0f : ((totalSkillAcquiredBySkillLevel.get(1) / (float) totalSkillListByLevel.get(1)));
								String level2SkillAcquiredPercentage = constants.level2() + ": " + totalSkillAcquiredBySkillLevel.get(1) + " " + constants.of() + " " + totalSkillListByLevel.get(1) + " " + constants.skill() + " (" + DECIMAL_FORMAT.format(totalPercentageLevel2)
										+ ")";

								long totalSkillAcquiredByStudent = totalSkillAcquiredBySkillLevel.get(0) + totalSkillAcquiredBySkillLevel.get(1);
								long totalSkillBySkillLevel = totalSkillListByLevel.get(0) + totalSkillListByLevel.get(1);
								float totalPercentage = totalSkillBySkillLevel == 0 ? totalPercentage = 0.0f : ((totalSkillAcquiredByStudent / (float) totalSkillBySkillLevel));

								String totalSkillAcquiredPercentage = constants.total() + ": " + totalSkillAcquiredByStudent + " " + constants.of() + " " + totalSkillBySkillLevel + " " + constants.skill() + " (" + DECIMAL_FORMAT.format(totalPercentage) + ")";

								Log.debug(level1SkillAcquiredPercentage);
								Log.debug(level2SkillAcquiredPercentage);
								Log.debug(totalSkillAcquiredPercentage);

								view.getLblLevel1Progress().setText(level1SkillAcquiredPercentage);
								view.getLblLevel1Progress().setTitle(level1SkillAcquiredPercentage);

								setProgress(view.getPrgBarLevel1(), 0L, totalSkillListByLevel.get(0), totalSkillAcquiredBySkillLevel.get(0));

								view.getLblLevel2Progress().setText(level2SkillAcquiredPercentage);
								view.getLblLevel2Progress().setTitle(level2SkillAcquiredPercentage);
								setProgress(view.getPrgBarLevel2(), 0L, totalSkillListByLevel.get(1), totalSkillAcquiredBySkillLevel.get(1));

								view.getLblTotalProgress().setText(totalSkillAcquiredPercentage);
								view.getLblTotalProgress().setTitle(totalSkillAcquiredPercentage);
								setProgress(view.getPrgBarTotal(), 0L, totalSkillBySkillLevel, totalSkillAcquiredByStudent);

							} else {
								Log.error("Skill Acquired Size should be Two, Current Size is : " + totalSkillAcquiredBySkillLevel.size());
							}

						}

						@Override
						public void onFailure(ServerFailure error) {
							super.onFailure(error);
							Log.debug("Failure");
						}

						@Override
						public void onConstraintViolation(java.util.Set<javax.validation.ConstraintViolation<?>> violations) {
							super.onConstraintViolation(violations);
							Log.debug("Violation");
						};
					});

				} else {
					Log.error("Skill Level Size should be Two, Current Size is : " + totalSkillListByLevel.size());
				}

			}

			@Override
			public void onFailure(ServerFailure error) {
				super.onFailure(error);
				Log.debug("Failure");
			}

			@Override
			public void onConstraintViolation(java.util.Set<javax.validation.ConstraintViolation<?>> violations) {
				super.onConstraintViolation(violations);
				Log.debug("Violation");
			};
		});
	}

	/*
	 * Set Value to Progress bar
	 */
	private void setProgress(CustomProgressbar prgBar, Long minValue, Long maxValue, float currentProgress) {
		prgBar.setMinProgress(minValue);
		prgBar.setMaxProgress(maxValue);
		prgBar.setProgress(currentProgress);
	}

	/*
	 * Set Value to Personnel Information Panel i.e. Student Name, Study Year
	 * etc..
	 */
	public void intiPersonnelInformation(StudentProxy studentProxy) {
		Log.debug("Student Id: " + studentProxy.getId());
		String studyYear = "";
		String studentName = getEmptyStringIfNull(studentProxy.getName()) + " " + getEmptyStringIfNull(studentProxy.getPreName());
		String studentId = getEmptyStringIfNull(studentProxy.getStudentId());
		if (studentProxy.getStudyYear() != null)
			studyYear = getEmptyStringIfNull(studentProxy.getStudyYear().name());
		String email = getEmptyStringIfNull(studentProxy.getEmail());

		view.getLblNameVal().setText(studentName);
		view.getLblNameVal().setTitle(studentName);
		view.getLblStudentIdVal().setText(studentId);
		view.getLblStudentIdVal().setTitle(studentId);
		view.getLblStudeyYearvalue().setText(studyYear);
		view.getLblStudeyYearvalue().setTitle(studyYear);
		view.getLblEmailVal().setText(email);
		view.getLblEmailVal().setTitle(email);

	}

	@Override
	public void goTo(Place place) {

	}

	@Override
	public void changeStudentInformationClicked(ClickEvent event) {
		Log.debug("Change student Infomation Clicked");
		view.getHpErrorMessage().setVisible(false);
		initStudentEditPopup(view.getStudentProxy(), event);
	}

	private void initStudentEditPopup(final StudentProxy studentProxy, ClickEvent event) {
		Log.debug("Student Proxy: " + studentProxy.getId());
		final StudentEditPopupViewImpl popupView = new StudentEditPopupViewImpl();
		popupViewImpl = popupView;
		popupView.setPopupPosition(event.getClientX() - 60, event.getClientY() - 135);

		view.getStudentFocusPanel().addMouseWheelHandler(new MouseWheelHandler() {

			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				popupView.hide();
			}
		});

		popupView.addCloseHandler(new CloseHandler<PopupPanel>() {
			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				view.getHpErrorMessage().setVisible(false);
			}
		});

		requests.studentRequest().findStudent(studentProxy.getId()).fire(new Receiver<StudentProxy>() {

			@Override
			public void onSuccess(StudentProxy response) {
				popupView.setTxtEmailValue(studentProxy.getEmail() != null ? studentProxy.getEmail() : "");
				popupView.setLstBoxStudyYear(studentProxy.getStudyYear() != null ? studentProxy.getStudyYear() : null);
				popupView.show();

				ClickHandler handler = new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						final String email = popupView.getTxtEmailValue().getText();

						final StudyYears studyYear = popupView.getLstBoxStudyYear().getValue();

						StudentRequest studentRequest = requests.studentRequest();
						StudentProxy proxy = studentProxy;
						proxy = studentRequest.edit(proxy);
						proxy.setEmail(email);
						if (popupView.getLstBoxStudyYear().getValue() == null) {
							Log.debug("Study Year is Null");
							proxy.setStudyYear(null);
						} else
							proxy.setStudyYear(studyYear);

						final StudentProxy tempStudentProxy = proxy;

						studentRequest.persist().using(proxy).fire(new Receiver<Void>() {

							@Override
							public void onSuccess(Void response) {

								view.getHpErrorMessage().setVisible(false);
								Log.debug("Successfully updated.");
								view.getLblEmailVal().setText(email);
								view.getLblEmailVal().setTitle(email);
								if (studyYear == null) {
									view.getLblStudeyYearvalue().setText("");
									view.getLblStudeyYearvalue().setTitle("");
								} else {
									view.getLblStudeyYearvalue().setText(studyYear.name());
									view.getLblStudeyYearvalue().setTitle(studyYear.name());
								}
								view.setStudentProxy(tempStudentProxy);
								popupView.hide();

							}

							@Override
							public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
								view.getHpErrorMessage().setVisible(true);
								view.getLblErrorMessage().setInnerText(constants.enterValidEmail());
							}

							@Override
							public void onFailure(ServerFailure error) {
								super.onFailure(error);
								Log.debug("Failure");
							}
						});

						// }
					}
				};

				popupView.getBtnSave().addClickHandler(handler);

				popupView.getTxtEmailValue().addKeyPressHandler(new KeyPressHandler() {

					@Override
					public void onKeyPress(KeyPressEvent event) {
						boolean value = KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode();
						if (value) {
							popupView.getBtnSave().click();
						}

					}
				});

				popupView.getBtnClose().addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						view.getHpErrorMessage().setVisible(false);
						popupView.hide();
					}
				});
			}
		});

	}

	// Finalize Student
	@Override
	public void finalizeLogBookClick(StudentProxy studentProxy) {
		errorMessageTimer.cancel();
		Log.debug("Student is going to Finalize.");
		Log.debug("Student Id: " + studentProxy.getId());

		requests.studentRequest().findStudent(studentProxy.getId()).fire(new Receiver<StudentProxy>() {

			@Override
			public void onSuccess(StudentProxy response) {

				StudentRequest studentRequest = requests.studentRequest();
				StudentProxy proxy = response;

				proxy = studentRequest.edit(proxy);

				if (response.getStudentStatus() != StudentStatus.Exported) {

					if (view.getBtnFinalizeLogBook().isDown()) {
						proxy.setStudentStatus(StudentStatus.Fianllized);
						message = constants.studentFinalized();
					} else {
						proxy.setStudentStatus(StudentStatus.UnFinalized);
						message = constants.studentUnFinalized();
					}

					studentRequest.persist().using(proxy).fire(new Receiver<Void>() {
						@Override
						public void onSuccess(Void response) {
							Log.debug("Successfully Saved.");
							view.getBtnFinalizeLogBook().setEnabled(true);
							view.getHpErrorMessage().setVisible(true);
							view.getLblErrorMessage().setInnerHTML(message);
							errorMessageTimer.schedule((int) LogBookConstant.ERROR_MESSAGE_TIME);

						}

						@Override
						public void onFailure(ServerFailure error) {
							super.onFailure(error);
							Log.debug("Failure to Save.");
							view.getHpErrorMessage().setVisible(true);
							view.getLblErrorMessage().setInnerHTML(constants.studentStatusChangeError());
							errorMessageTimer.schedule((int) LogBookConstant.ERROR_MESSAGE_TIME);
						}

						@Override
						public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
							super.onConstraintViolation(violations);
							Log.debug("Constraint Violate when Save.");
							errorMessageTimer.schedule((int) LogBookConstant.ERROR_MESSAGE_TIME);
						}
					});
				} else {

					view.getHpErrorMessage().setVisible(true);
					view.getLblErrorMessage().setInnerHTML(constants.studentFinalized());
					view.getBtnFinalizeLogBook().setEnabled(false);
				}
			}
		});
	}
}
