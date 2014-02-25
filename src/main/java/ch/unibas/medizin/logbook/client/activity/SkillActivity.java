package ch.unibas.medizin.logbook.client.activity;

import java.util.List;

import ch.unibas.medizin.logbook.client.event.ApplicationLoadingScreenEvent;
import ch.unibas.medizin.logbook.client.event.ApplicationLoadingScreenHandler;
import ch.unibas.medizin.logbook.client.place.SkillPlace;
import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillFilteredResultProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillProxy;
import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;
import ch.unibas.medizin.logbook.client.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.client.suggest.simple.DefaultSuggestOracle;
import ch.unibas.medizin.logbook.client.ui.SkillLevelCheckboxView;
import ch.unibas.medizin.logbook.client.ui.SkillLevelCheckboxViewImpl;
import ch.unibas.medizin.logbook.client.ui.SkillLevelIconButtonView;
import ch.unibas.medizin.logbook.client.ui.SkillLevelIconButtonViewImpl;
import ch.unibas.medizin.logbook.client.ui.SkillLevelTextAreaViewImpl;
import ch.unibas.medizin.logbook.client.ui.SkillView;
import ch.unibas.medizin.logbook.client.ui.SkillViewImpl;
import ch.unibas.medizin.logbook.client.widget.CustomProgressbar;
import ch.unibas.medizin.logbook.shared.constant.LogBookConstant;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;
import ch.unibas.medizin.logbook.shared.util.UtilityLogBook;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class SkillActivity extends AbstractActivity implements SkillView.presenter, SkillView.Delegate, SkillLevelCheckboxView.presenter, SkillLevelCheckboxView.Delegate, SkillLevelIconButtonView.presenter, SkillLevelIconButtonView.Delegate {

	private LogBookRequestFactory requests;
	private AcceptsOneWidget widget;
	private SkillView view;
	private SkillLevelCheckboxView checkBoxview;
	private Long mainClassificationId = null;
	private Long classificaitonTopicId = null;
	private Long topicId = null;
	private SkillView systemStartView;
	private Timer errorMessageTimer;

	private FlexTable skillFlexTable;
	LogBookConstants constants = GWT.create(LogBookConstants.class);

	public HandlerManager handlerManager;
	public int currenttab = 0;

	public SkillActivity(LogBookRequestFactory requests, PlaceController placeController, SkillPlace skillPlace) {
		Log.debug("Call Activity Login");
		this.requests = requests;
		handlerManager = skillPlace.handler;
	}

	static class ShowCriteria {
		static MainClassificationProxy mProxy = null;
		static ClassificationTopicProxy ctProxy = null;
		static TopicProxy tProxy = null;
		static String fullTextSearch = "";
		static String chkAsc = new Integer(0).toString();
	}

	public SkillActivity(LogBookRequestFactory requests, PlaceController placeController) {

		this.requests = requests;
		initLoading();
	}

	@Override
	public void onStop() {
		mainClassificationId = null;
		classificaitonTopicId = null;
		topicId = null;
		view.getMainClassificationSuggestBox().setSelected(null);
		view.getClassificationTopicSuggestBox().setSelected(null);
		view.getTopicSuggestBox().setSelected(null);
		ShowCriteria.mProxy = null;
		ShowCriteria.ctProxy = null;
		ShowCriteria.tProxy = null;
		ShowCriteria.fullTextSearch = "";
		ShowCriteria.chkAsc = new Integer(0).toString();
		widget.setWidget(null);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.debug("SystemStartActivity.start()");

		widget = panel;
		systemStartView = new SkillViewImpl();
		systemStartView.setSkillActivity(this);
		view = systemStartView;
		view.setDelegate(this);

		widget.setWidget(systemStartView.asWidget());

		systemStartView.asWidget().getElement().getParentElement().getParentElement().getStyle().setPosition(Position.RELATIVE);

		checkBoxview = new SkillLevelCheckboxViewImpl();
		checkBoxview.setDelegate(this);
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
		systemStartView.setPresenter(this);
		checkBoxview.setPresenter(this);

		requests.studentRequest().findStudentFromSession().fire(new Receiver<StudentProxy>() {

			@Override
			public void onSuccess(StudentProxy response) {
				if (response != null) {
					view.setStudent(response);
				}

				initAllSkillSuggestions();

				initSkillFlexTable();

				view.setIsAsc(0);

				initSkillTableData(response, view.getIsAsc());
			}
		});
	}

	private void initLoading() {
		ApplicationLoadingScreenEvent.initialCounter();
		ApplicationLoadingScreenEvent.register(requests.getEventBus(), new ApplicationLoadingScreenHandler() {
			@Override
			public void onEventReceived(ApplicationLoadingScreenEvent event) {
				event.display();
			}
		});
	}

	// chkAsc: 0=Sort Ascending ShortCut
	// chkAsc: 1=Sort Descending ShortCut
	private void initSkillTableData(StudentProxy student, int chkAsc) {

		showApplicationLoading(true);
		skillFlexTable.removeAllRows();

		Log.debug("student is :" + student.getId());

		String fullTextSearchString = view.getFullTextSearchBox().getValue();

		Log.debug("full text : " + fullTextSearchString);

		requests.skillRequest().findSkillBySearchCriteria(view.getPager().getStart(), view.getPager().getLength(), student.getId(), mainClassificationId, classificaitonTopicId, topicId, fullTextSearchString, chkAsc)
				.with("skillList.topic", "skillList.skillComment", "skillList.topic.classificationTopic", "skillList.topic.classificationTopic.mainClassification", "skillList.skillLevel").fire(new Receiver<SkillFilteredResultProxy>() {

					@Override
					public void onSuccess(SkillFilteredResultProxy response) {
						showApplicationLoading(false);
						view.getPager().setRowCount(response.getTotalSkill());
						view.createHeader(view.getSkillFlexTable());
						if (response.getTotalSkill() == 0) {

							view.getHpErrorMessage().setVisible(true);
							view.getLblErrorMessage().setInnerHTML(constants.nodataFound());
						} else {
							view.setSource(response);
						}
					}

				});
	}

	private void onRangeChanged(StudentProxy student, int chkAsc) {

		skillFlexTable.removeAllRows();

		Log.debug("student is :" + student.getId());

		String fullTextSearchString = view.getFullTextSearchBox().getValue();

		Log.debug("full text : " + fullTextSearchString);

		requests.skillRequest().findSkillBySearchCriteria(view.getPager().getStart(), view.getPager().getLength(), student.getId(), mainClassificationId, classificaitonTopicId, topicId, fullTextSearchString, chkAsc)
				.with("skillList.topic", "skillList.topic.classificationTopic", "skillList.topic.classificationTopic.mainClassification", "skillList.skillLevel").fire(new Receiver<SkillFilteredResultProxy>() {

					@Override
					public void onSuccess(SkillFilteredResultProxy response) {
						view.createHeader(view.getSkillFlexTable());
						view.setSource(response);

					}
				});

	}

	private void initAllSkillSuggestions() {

		initMainClassificationSuggestion();
		initClassificationTopicSuggestion(mainClassificationId);
		initTopicSuggestion(classificaitonTopicId);

	}

	private void initMainClassificationSuggestion() {

		requests.mainClassificationRequest().findAllMainClassifications().with("classificationTopics", "classificationTopics.topics", "topics.skills", "skills.skillsAcquired").fire(new Receiver<List<MainClassificationProxy>>() {

			@Override
			public void onSuccess(List<MainClassificationProxy> response) {

				DefaultSuggestOracle<MainClassificationProxy> suggestOracle1 = (DefaultSuggestOracle<MainClassificationProxy>) view.getMainClassificationSuggestBox().getSuggestOracle();
				suggestOracle1.setPossiblilities(response);
				view.getMainClassificationSuggestBox().setSuggestOracle(suggestOracle1);

				view.getMainClassificationSuggestBox().setRenderer(new AbstractRenderer<MainClassificationProxy>() {

					@Override
					public String render(MainClassificationProxy object) {

						if (object != null) {
							return (object.getDescription());
						} else {
							return "";
						}
					}
				});
			}
		});

	}

	private void initClassificationTopicSuggestion(Long mainClassificationId) {

		requests.classificationTopicRequest().findClassificationTopicByMainClassfication(mainClassificationId).fire(new Receiver<List<ClassificationTopicProxy>>() {

			@Override
			public void onSuccess(List<ClassificationTopicProxy> response) {

				DefaultSuggestOracle<ClassificationTopicProxy> suggestOracle = (DefaultSuggestOracle<ClassificationTopicProxy>) view.getClassificationTopicSuggestBox().getSuggestOracle();
				suggestOracle.setPossiblilities(response);
				view.getClassificationTopicSuggestBox().setSuggestOracle(suggestOracle);

				view.getClassificationTopicSuggestBox().setRenderer(new AbstractRenderer<ClassificationTopicProxy>() {

					@Override
					public String render(ClassificationTopicProxy object) {
						if (object != null) {
							return (object.getDescription());
						} else {
							return "";
						}
					}
				});

			}
		});
	}

	private void initTopicSuggestion(Long classificaitonTopicId) {

		requests.topicRequest().findTopicByClassficationId(classificaitonTopicId).fire(new Receiver<List<TopicProxy>>() {

			@Override
			public void onSuccess(List<TopicProxy> response) {

				DefaultSuggestOracle<TopicProxy> suggestOracle = (DefaultSuggestOracle<TopicProxy>) view.getTopicSuggestBox().getSuggestOracle();
				suggestOracle.setPossiblilities(response);
				view.getTopicSuggestBox().setSuggestOracle(suggestOracle);

				view.getTopicSuggestBox().setRenderer(new AbstractRenderer<TopicProxy>() {

					@Override
					public String render(TopicProxy object) {
						if (object != null) {
							return object.getTopicDescription();
						} else {
							return "";
						}
					}
				});

			}
		});

	}

	private void initSkillFlexTable() {
		skillFlexTable = view.getSkillFlexTable();
	}

	@Override
	public void goTo(Place place) {

	}

	@Override
	public void mainClassificationSuggestboxChanged(Long mainClassificationId) {

		if (mainClassificationId == null || view.getMainClassificationSuggestBox().getTextField().advancedTextBox.getText() == "") {
			view.getClassificationTopicSuggestBox().setEnabled(false);
			view.getTopicSuggestBox().setEnabled(false);
		} else {
			view.getClassificationTopicSuggestBox().setEnabled(true);
			view.getTopicSuggestBox().setEnabled(false);
		}

		view.getClassificationTopicSuggestBox().setSelected(null);
		classificaitonTopicId = null;

		view.getTopicSuggestBox().setSelected(null);
		topicId = null;

		view.setDefaultMessageOfSuggestionbox();

		initClassificationTopicSuggestion(mainClassificationId);

		initTopicSuggestion(classificaitonTopicId);
	}

	@Override
	public void classificationTopicSuggestboxChanged(Long classificationId) {

		if (classificationId == null || view.getClassificationTopicSuggestBox().getTextField().advancedTextBox.getText() == "") {
			view.getTopicSuggestBox().setEnabled(false);
		} else {
			view.getTopicSuggestBox().setEnabled(true);
		}
		view.getTopicSuggestBox().setSelected(null);
		topicId = null;

		view.setDefaultMessageOfSuggestionbox();

		initTopicSuggestion(classificationId);
	}

	@Override
	public void topicSuggestboxChanged(Long topicId) {
		view.setDefaultMessageOfSuggestionbox();
	}

	@Override
	public void resetButtonClicked() {

		view.getHpErrorMessage().setVisible(false);
		mainClassificationId = null;
		classificaitonTopicId = null;
		topicId = null;

		view.getFullTextSearchBox().setText("");
		view.getMainClassificationSuggestBox().setSelected(null);
		view.getClassificationTopicSuggestBox().setSelected(null);
		view.getTopicSuggestBox().setSelected(null);

		view.setDefaultMessageOfSuggestionbox();

		initAllSkillSuggestions();

		initSkillFlexTable();

		view.setIsAsc(0);
		initSkillTableData(view.getStudent(), view.getIsAsc());

		view.getMainClassificationSuggestBox().setEnabled(true);
		view.getClassificationTopicSuggestBox().setEnabled(false);
		view.getTopicSuggestBox().setEnabled(false);

		ShowCriteria.mProxy = view.getMainClassificationSuggestBox().getSelected();
		ShowCriteria.tProxy = view.getTopicSuggestBox().getSelected();
		ShowCriteria.ctProxy = view.getClassificationTopicSuggestBox().getSelected();
		ShowCriteria.chkAsc = new Integer(view.getIsAsc()).toString();
		ShowCriteria.fullTextSearch = view.getFullTextSearchBox().getValue();
	}

	@Override
	public void showButtonClicked() {

		view.getHpErrorMessage().setVisible(false);

		mainClassificationId = view.getMainClassificationSuggestBox().getSelected() != null ? view.getMainClassificationSuggestBox().getSelected().getId() : null;
		classificaitonTopicId = view.getClassificationTopicSuggestBox().getSelected() != null ? view.getClassificationTopicSuggestBox().getSelected().getId() : null;
		topicId = view.getTopicSuggestBox().getSelected() != null ? view.getTopicSuggestBox().getSelected().getId() : null;

		if (mainClassificationId == null && classificaitonTopicId == null && topicId == null && view.getFullTextSearchBox().getValue() == "") {
			view.getHpErrorMessage().setVisible(true);
			view.getLblErrorMessage().setInnerHTML(constants.ErrorMessage());
		} else {

			view.setIsAsc(0);

			view.getPager().setStart(1);

			initSkillTableData(view.getStudent(), view.getIsAsc());
		}

		ShowCriteria.mProxy = view.getMainClassificationSuggestBox().getSelected();
		ShowCriteria.tProxy = view.getTopicSuggestBox().getSelected();
		ShowCriteria.ctProxy = view.getClassificationTopicSuggestBox().getSelected();
		ShowCriteria.chkAsc = new Integer(view.getIsAsc()).toString();
		ShowCriteria.fullTextSearch = view.getFullTextSearchBox().getValue();

	}

	@Override
	public void generatePdfClicked() {
		String url = GWT.getHostPageBaseURL() + "downloadFile";
		Log.debug("URL :" + url);
		Window.open(url, "", "");

	}

	@Override
	public void printPdfClicked() {

		showApplicationLoading(true);
		MainClassificationProxy mProxy = ShowCriteria.mProxy;
		ClassificationTopicProxy ctProxy = ShowCriteria.ctProxy;
		TopicProxy tProxy = ShowCriteria.tProxy;
		String fullTextSearch = ShowCriteria.fullTextSearch;

		Long mainClassifcationId = null;
		Long classifcationTopicId = null;
		Long topicId = null;

		if (mProxy != null) {
			mainClassifcationId = mProxy.getId();
		}
		if (ctProxy != null) {
			classifcationTopicId = ctProxy.getId();
		}
		if (tProxy != null) {
			topicId = tProxy.getId();
		}

		Log.debug("MainClassification :" + mainClassifcationId);
		Log.debug("Classification Topic Id :" + classifcationTopicId);
		Log.debug("Topic Id :" + topicId);
		requests.skillRequest().retrieveHtmlFile(view.getStudent().getId(), mainClassifcationId, classifcationTopicId, topicId, fullTextSearch, new Integer(ShowCriteria.chkAsc).intValue()).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {

				Print.it(response);
				showApplicationLoading(false);
			}
		});
	}

	@Override
	public void refreshFlextable(FlexTable table, int start, int length) {
		onRangeChanged(view.getStudent(), view.getIsAsc());
	}

	@Override
	public void chekBoxSelected(final SkillProxy skillProxy, final boolean isLevel1, final SkillLevelCheckboxViewImpl skillLevelCheckboxViewImpl) {

		view.getHpErrorMessage().setVisible(false);
		final int row = skillLevelCheckboxViewImpl.getRow();
		Boolean isDeleteOperation = true;
		final SkillLevelCheckboxViewImpl s = (SkillLevelCheckboxViewImpl) view.getSkillFlexTable().getWidget(row, 2);
		final SkillLevelCheckboxViewImpl s1 = (SkillLevelCheckboxViewImpl) view.getSkillFlexTable().getWidget(row, 3);

		Boolean isFirstSelected = s.getCheckbox().getValue();
		Boolean isSecondSelected = s1.getCheckbox().getValue();
		if (isFirstSelected || isSecondSelected) {
			isDeleteOperation = false;
		}
		final Integer skillLevel;
		if (skillProxy.getSkillLevel() == null) {
			skillLevel = 0;
		} else {
			skillLevel = skillProxy.getSkillLevel().getLevelNumber();
		}

		requests.skillAcquiredRequest().acquireORDeleteSkill(view.getStudent().getId(), skillLevelCheckboxViewImpl.getSkillProxy().getId(), isLevel1, isDeleteOperation).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				Log.debug("Operation is :" + response);
				if (response.equalsIgnoreCase("INSERT")) {
					skillLevelCheckboxViewImpl.getCheckbox().setValue(true);

					if (isLevel1 && skillLevel == 2) {

						// decrement topic acquired skill
						if (!view.getSkillFlexTable().getRowFormatter().getStyleName(row).equalsIgnoreCase("redBG")) {
							if (skillLevelCheckboxViewImpl.getTopicRow() != 0) {
								findProgressOfTopic(skillProxy.getTopic(), skillLevelCheckboxViewImpl.getTopicRow(), 1, view.getStudent());
							}

							// decrement classification topic acquired skill
							if (skillLevelCheckboxViewImpl.getClassificationTopicRow() != 0) {
								findProgressOfClassificationTopic(skillProxy.getTopic().getClassificationTopic(), skillLevelCheckboxViewImpl.getClassificationTopicRow(), 1, view.getStudent());
							}

							// decrement main classification acquired skill
							if (skillLevelCheckboxViewImpl.getMainClassificationRow() != 0) {
								findProgressOfMainClassification(skillProxy.getTopic().getClassificationTopic().getMainClassification(), skillLevelCheckboxViewImpl.getMainClassificationRow(), 1, view.getStudent());
							}
						}

						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "redBG");
						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "greenBG");
						view.getSkillFlexTable().getRowFormatter().addStyleName(row, "yellowBG");

					} else {
						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "redBG");
						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "yellowBG");
						view.getSkillFlexTable().getRowFormatter().addStyleName(row, "greenBG");

						// increment topic acquired skill

						if (skillLevelCheckboxViewImpl.getTopicRow() != 0) {
							findProgressOfTopic(skillProxy.getTopic(), skillLevelCheckboxViewImpl.getTopicRow(), 1, view.getStudent());
							// increment classification topic acquired skill
						}

						if (skillLevelCheckboxViewImpl.getClassificationTopicRow() != 0) {
							findProgressOfClassificationTopic(skillProxy.getTopic().getClassificationTopic(), skillLevelCheckboxViewImpl.getClassificationTopicRow(), 1, view.getStudent());
						}

						// increment main classification acquired skill
						if (skillLevelCheckboxViewImpl.getMainClassificationRow() != 0) {
							findProgressOfMainClassification(skillProxy.getTopic().getClassificationTopic().getMainClassification(), skillLevelCheckboxViewImpl.getMainClassificationRow(), 1, view.getStudent());
						}
					}
				} else if (response.equalsIgnoreCase("UPDATE")) {
					if (isLevel1) {
						s.getCheckbox().setValue(true);
						s1.getCheckbox().setValue(false);

					} else {
						s.getCheckbox().setValue(false);
						s1.getCheckbox().setValue(true);
					}

					if (isLevel1 && skillLevel == 2) {
						// decrement topic acquired skill
						if (!view.getSkillFlexTable().getRowFormatter().getStyleName(row).equalsIgnoreCase("redBG")) {
							if (skillLevelCheckboxViewImpl.getTopicRow() != 0) {
								findProgressOfTopic(skillProxy.getTopic(), skillLevelCheckboxViewImpl.getTopicRow(), 1, view.getStudent());
							}

							// decrement classification topic acquired skill
							if (skillLevelCheckboxViewImpl.getClassificationTopicRow() != 0) {
								findProgressOfClassificationTopic(skillProxy.getTopic().getClassificationTopic(), skillLevelCheckboxViewImpl.getClassificationTopicRow(), 1, view.getStudent());
							}

							// decrement main classification acquired skill
							if (skillLevelCheckboxViewImpl.getMainClassificationRow() != 0) {
								findProgressOfMainClassification(skillProxy.getTopic().getClassificationTopic().getMainClassification(), skillLevelCheckboxViewImpl.getMainClassificationRow(), 1, view.getStudent());
							}
						}

						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "redBG");
						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "greenBG");
						view.getSkillFlexTable().getRowFormatter().addStyleName(row, "yellowBG");

					} else {
						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "redBG");
						view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "yellowBG");
						view.getSkillFlexTable().getRowFormatter().addStyleName(row, "greenBG");

						// increment topic acquired skill
						if (skillLevelCheckboxViewImpl.getTopicRow() != 0) {
							findProgressOfTopic(skillProxy.getTopic(), skillLevelCheckboxViewImpl.getTopicRow(), 1, view.getStudent());
						}

						// increment classification topic acquired skill
						if (skillLevelCheckboxViewImpl.getClassificationTopicRow() != 0) {
							findProgressOfClassificationTopic(skillProxy.getTopic().getClassificationTopic(), skillLevelCheckboxViewImpl.getClassificationTopicRow(), 1, view.getStudent());
						}

						// increment main classification acquired skill
						if (skillLevelCheckboxViewImpl.getMainClassificationRow() != 0) {
							findProgressOfMainClassification(skillProxy.getTopic().getClassificationTopic().getMainClassification(), skillLevelCheckboxViewImpl.getMainClassificationRow(), 1, view.getStudent());
						}
					}
				} else if (response.equalsIgnoreCase("DELETE")) {
					s.getCheckbox().setValue(false);
					s1.getCheckbox().setValue(false);

					Log.debug("Style name :" + view.getSkillFlexTable().getRowFormatter().getStyleName(row));

					// decrement topic acquired skill
					if (!view.getSkillFlexTable().getRowFormatter().getStyleName(row).equalsIgnoreCase("yellowBG")) {

						if (skillLevelCheckboxViewImpl.getTopicRow() != 0) {
							findProgressOfTopic(skillProxy.getTopic(), skillLevelCheckboxViewImpl.getTopicRow(), 1, view.getStudent());
						}

						// decrement classification topic acquired skill
						if (skillLevelCheckboxViewImpl.getClassificationTopicRow() != 0) {
							findProgressOfClassificationTopic(skillProxy.getTopic().getClassificationTopic(), skillLevelCheckboxViewImpl.getClassificationTopicRow(), 1, view.getStudent());
						}

						// decrement main classification acquired skill
						if (skillLevelCheckboxViewImpl.getMainClassificationRow() != 0) {
							findProgressOfMainClassification(skillProxy.getTopic().getClassificationTopic().getMainClassification(), skillLevelCheckboxViewImpl.getMainClassificationRow(), 1, view.getStudent());
						}
					}

					view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "greenBG");
					view.getSkillFlexTable().getRowFormatter().removeStyleName(row, "yellowBG");
					view.getSkillFlexTable().getRowFormatter().addStyleName(row, "redBG");

				} else if (response.equals("ERROR")) {
					view.getHpErrorMessage().setVisible(true);
					view.getLblErrorMessage().setInnerHTML(constants.skillAcquireError());
				}
			}
		});

	}

	public void changeProgress(int row, boolean incr) {
		String topicProgress = ((Label) ((HorizontalPanel) view.getSkillFlexTable().getWidget(row, 0)).getWidget(1)).getText();
		String tP[] = topicProgress.split("/");
		Long topicProgressValue = new Long(tP[0]);
		
		if (!incr) {
			--topicProgressValue;
		} else {
			++topicProgressValue;
		}
		
		String totalTopicSkill = tP[1];
		((Label) ((HorizontalPanel) view.getSkillFlexTable().getWidget(row, 0)).getWidget(1)).setText(topicProgressValue.toString() + "/" + totalTopicSkill);
		((CustomProgressbar) view.getSkillFlexTable().getWidget(row, 1)).setProgress(topicProgressValue);
	}

	@Override
	public void findProgressOfMainClassification(MainClassificationProxy mProxy, final int row, final int i, StudentProxy student) {

		requests.skillRequest().findProgressOfMainClassification(mProxy, student.getId()).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				String mP[] = response.split("/");

				view.getSkillFlexTable().setWidget(row, i, view.createProgressBar(new Integer(mP[1]), new Integer(mP[0])));
				((Label) ((HorizontalPanel) view.getSkillFlexTable().getWidget(row, 0)).getWidget(1)).setText(response);

			}
		});
	}

	@Override
	public void findProgressOfClassificationTopic(ClassificationTopicProxy ctProxy, final int row, final int i, StudentProxy student) {
		requests.skillRequest().findProgressOfClassificationTopic(ctProxy, student.getId()).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				String mP[] = response.split("/");

				view.getSkillFlexTable().setWidget(row, i, view.createProgressBar(new Integer(mP[1]), new Integer(mP[0])));
				((Label) ((HorizontalPanel) view.getSkillFlexTable().getWidget(row, 0)).getWidget(1)).setText(response);

			}
		});
	}

	@Override
	public void findProgressOfTopic(TopicProxy tproxy, final int row, final int i, StudentProxy student) {
		requests.skillRequest().findProgressOfTopic(tproxy, student.getId()).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				String mP[] = response.split("/");

				view.getSkillFlexTable().setWidget(row, i, view.createProgressBar(new Integer(mP[1]), new Integer(mP[0])));
				((Label) ((HorizontalPanel) view.getSkillFlexTable().getWidget(row, 0)).getWidget(1)).setText(response);

			}
		});
	}

	@Override
	public void shortCutClicked() {
		view.getPager().setStart(1);
		initSkillTableData(view.getStudent(), view.getIsAsc());
	}

	@Override
	public void exportPDF() {
		Log.debug("exportPDF");

		String fullTextSearch = ShowCriteria.fullTextSearch;

		String mainClassifcationId = "0";
		String classifcationTopicId = "0";
		String topicId = "0";

		fullTextSearch = "";

		String chkAsc = ShowCriteria.chkAsc;
		String url = GWT.getHostPageBaseURL() + "SkillPdfExport?studentId=" + view.getStudent().getId() + "&mainClassifcationId=" + mainClassifcationId + "&classifcationId=" + classifcationTopicId + "&topicId=" + topicId + "&chkAsc=" + chkAsc + "&fullTextSearch="
				+ fullTextSearch;
		Log.debug("url :" + url);
		Window.open(url, "skill" + view.getStudent().getName() + ".pdf", "enabled");
	}

	public void showApplicationLoading(Boolean show) {
		requests.getEventBus().fireEvent(new ApplicationLoadingScreenEvent(show));
	}

	@Override
	public void iconButtonClicked(final SkillProxy skillProxy, final SkillLevelIconButtonViewImpl skillLevelIconButtonViewImpl) {
		Log.debug("Skill Proxy is :" + skillProxy.getId());

		view.getHpErrorMessage().setVisible(false);

		if (skillLevelIconButtonViewImpl.isSave() == false)
		{
			final String comment = ((SkillLevelTextAreaViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().getText();

			requests.skillRequest().addCommnets(skillProxy.getId(), view.getStudent().getId(), comment).fire(new Receiver<String>() {

				@Override
				public void onSuccess(String response) {

					Log.debug("Operation Was :" + response);

					if (response.compareToIgnoreCase("FAILURE") == 0)
					{
						view.getHpErrorMessage().setVisible(true);
						view.getLblErrorMessage().setInnerHTML(constants.commentError());
						((SkillLevelTextAreaViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setEnabled(false);
						((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().removeStyleName("skillTextAreaEnabled");
						((SkillLevelIconButtonViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 5)).getIconButton().setClassName("ui-icon ui-icon-pencil");
						((SkillLevelIconButtonViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 5)).setSave(false);

						requests.skillRequest().getCommentOfStudentForSkill(skillProxy.getId(), view.getStudent().getId()).fire(new Receiver<String>() {
							@Override
							public void onSuccess(String response) {
								((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setText(UtilityLogBook.getFormatedString(response, 40));
								((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setTitle(response);
							}
						});

					}
					else
					{
						((SkillLevelTextAreaViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setEnabled(false);
						((SkillLevelIconButtonViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 5)).getIconButton().setClassName("ui-icon ui-icon-pencil");
						((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().removeStyleName("skillTextAreaEnabled");
						((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setStyleName("skillTextArea");
						((SkillLevelIconButtonViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 5)).setSave(false);

						((SkillLevelIconButtonViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 5)).setSkillcomment(comment);
						((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setText(UtilityLogBook.getFormatedString(comment, 40));
						((SkillLevelTextAreaViewImpl) skillFlexTable.getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setTitle(comment);

					}
				}
			});
		}
		else
		{
			((SkillLevelTextAreaViewImpl) view.getSkillFlexTable().getWidget(skillLevelIconButtonViewImpl.getRow(), 4)).getTextArea().setEnabled(true);
		}
	}
}
