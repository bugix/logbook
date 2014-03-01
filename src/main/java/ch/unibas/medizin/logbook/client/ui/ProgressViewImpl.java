package ch.unibas.medizin.logbook.client.ui;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;
import ch.unibas.medizin.logbook.client.widget.CustomPager;
import ch.unibas.medizin.logbook.client.widget.CustomPager.RangeChangeListener;
import ch.unibas.medizin.logbook.client.widget.CustomProgressbar;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProgressViewImpl extends Composite implements ProgressView {

	private static ProgressViewImplUiBinder uiBinder = GWT.create(ProgressViewImplUiBinder.class);

	interface ProgressViewImplUiBinder extends UiBinder<Widget, ProgressViewImpl> {
	}

	private Delegate delegate;

	LogBookConstants constants = GWT.create(LogBookConstants.class);

	private StudentProxy student;

	@UiField(provided = true)
	FlexTable progressFlexTable;

	@UiField
	CustomPager pager;

	public ProgressViewImpl() {

		progressFlexTable = new FlexTable();
		progressFlexTable.setCellPadding(1);
		progressFlexTable.setCellSpacing(1);
		createHeader(progressFlexTable);

		initWidget(uiBinder.createAndBindUi(this));

		pager.setLength(30);

		pager.addRangeChangeListener(new RangeChangeListener() {

			@Override
			public void onRangeChange() {
				Log.debug("pager start :" + pager.getStart());
				Log.debug("pager Length :" + pager.getLength());
				delegate.refreshProgresstable(progressFlexTable, pager.getStart(), pager.getLength());
			}
		});

	}

	@Override
	public void createHeader(FlexTable flexTable) {
		flexTable.setText(0, 0, constants.name());
		flexTable.getCellFormatter().addStyleName(0, 0, "flexTable-header");
		flexTable.getFlexCellFormatter().setWidth(0, 0, "70%");

		flexTable.setText(0, 1, constants.progress());
		flexTable.getCellFormatter().addStyleName(0, 1, "flexTable-header");
		flexTable.getFlexCellFormatter().setWidth(0, 1, "30%");

		flexTable.setText(0, 1, constants.progress());
	}

	@Override
	public void setSource(final List<TopicProxy> topicData, List<Long> totalProgressList, List<Long> currentProgressList, StudentProxy studentProxy) {
		int row = 0;

		for (int i = 0; i < topicData.size(); i++) {
			TopicProxy topicProxy = topicData.get(i);

			final Integer totalProgress = totalProgressList.get(i).intValue();
			final Integer currentProgress = currentProgressList.get(i).intValue();

			if (topicProxy.getClassificationTopic() != null && topicProxy.getClassificationTopic().getMainClassification() != null) {
				ClassificationTopicProxy classificationTopicProxy = topicProxy.getClassificationTopic();
				MainClassificationProxy mainClassificationProxy = topicProxy.getClassificationTopic().getMainClassification();

				if (i == 0) {
					progressFlexTable.setWidget(++row, 0, createMainClassificationWidget(mainClassificationProxy));
					delegate.findProgressOfMainClassification(mainClassificationProxy, row, 1, studentProxy);
					progressFlexTable.getFlexCellFormatter().setColSpan(row, 1, 2);
					progressFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");

					if (!classificationTopicProxy.getDescription().equals("Blank")) {
						progressFlexTable.setWidget(++row, 0, createClassificationTopicWidget(classificationTopicProxy));
						delegate.findProgressOfClassificationTopic(classificationTopicProxy, row, 1, studentProxy);
						progressFlexTable.getFlexCellFormatter().setColSpan(row, 1, 2);
						progressFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
					}
				} else {
					if ((classificationTopicProxy.getId() != topicData.get(i - 1).getClassificationTopic().getId())) {

						if ((mainClassificationProxy.getId() != topicData.get(i - 1).getClassificationTopic().getMainClassification().getId())) {
							progressFlexTable.setWidget(++row, 0, createMainClassificationWidget(mainClassificationProxy));
							delegate.findProgressOfMainClassification(mainClassificationProxy, row, 1, studentProxy);
							progressFlexTable.getFlexCellFormatter().setColSpan(row, 1, 2);
							progressFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");
						}
						if (!classificationTopicProxy.getDescription().equals("Blank")) {
							progressFlexTable.setWidget(++row, 0, createClassificationTopicWidget(classificationTopicProxy));
							delegate.findProgressOfClassificationTopic(classificationTopicProxy, row, 1, studentProxy);
							progressFlexTable.getFlexCellFormatter().setColSpan(row, 1, 2);
							progressFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
						}

					}
				}

				progressFlexTable.setWidget(++row, 0, createTopicWidget(topicProxy, totalProgress, currentProgress));
				progressFlexTable.setWidget(row, 1, createProgressBar(totalProgress, currentProgress));
				progressFlexTable.getFlexCellFormatter().setColSpan(row, 1, 2);
				progressFlexTable.getFlexCellFormatter().addStyleName(row, 1, "topicBG");
				Log.debug("Topic: " + topicProxy.getId());

			} else {
				Log.debug("topicProxy.getClassificationTopic().getMainClassification() found Null");
			}
		}
	}

	public Widget createTopicWidget(TopicProxy tProxy, Integer totalProgress, Integer currentProgress) {
		Label mainTopicProxyLbl = new Label();
		mainTopicProxyLbl.setText(tProxy.getTopicDescription());
		mainTopicProxyLbl.setWidth("90%");
		mainTopicProxyLbl.addStyleName("topicDescription");
		Label topicProgress = new Label(currentProgress + "/" + totalProgress);
		topicProgress.getElement().getStyle().setFloat(com.google.gwt.dom.client.Style.Float.RIGHT);
		topicProgress.addStyleName("skillCountPadding");
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(mainTopicProxyLbl);
		hp.add(topicProgress);
		hp.setWidth("100%");
		hp.addStyleName("topicRow");
		return hp;
	}

	public Widget createClassificationTopicWidget(ClassificationTopicProxy classificationTopicProxy) {
		Label mainClassificationTopicLbl = new Label();
		mainClassificationTopicLbl.setText(classificationTopicProxy.getDescription());
		mainClassificationTopicLbl.setWidth("90%");
		mainClassificationTopicLbl.addStyleName("classificationDescription");
		Label classificationTopicProgress = new Label("5/20");
		classificationTopicProgress.getElement().getStyle().setFloat(com.google.gwt.dom.client.Style.Float.RIGHT);
		classificationTopicProgress.addStyleName("skillCountPadding");
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(mainClassificationTopicLbl);
		hp.add(classificationTopicProgress);
		hp.setWidth("100%");
		hp.addStyleName("classificationTopicRow");
		return hp;
	}

	public Widget createMainClassificationWidget(MainClassificationProxy mProxy) {
		Label mainClassificationDescLbl = new Label();
		String mainClassificationDescription = "";
		if (mProxy.getDescription() != null) {
			mainClassificationDescription = mProxy.getDescription();
		}
		if (mProxy.getShortcut() != null) {
			mainClassificationDescription += " ( " + mProxy.getShortcut() + " ) ";
		}

		mainClassificationDescLbl.setText(mainClassificationDescription);

		mainClassificationDescLbl.setWidth("90%");
		mainClassificationDescLbl.addStyleName("mainClassificationDescription");
		Label mainClassificationProgress = new Label("5/20");
		mainClassificationProgress.getElement().getStyle().setFloat(com.google.gwt.dom.client.Style.Float.RIGHT);
		mainClassificationProgress.addStyleName("skillCountPadding");
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(mainClassificationDescLbl);
		hp.add(mainClassificationProgress);
		hp.setWidth("100%");
		hp.addStyleName("mainClassificationRow");
		return hp;
	}

	@Override
	public Widget createProgressBar(int maxProgress, int progress) {
		int tempMaxProgress;

		if (maxProgress == 0) {
			tempMaxProgress = 100;
		} else {
			tempMaxProgress = maxProgress;
		}

		CustomProgressbar mainClassificationProgressBar = new CustomProgressbar(0, tempMaxProgress, progress);

		mainClassificationProgressBar.setHeight("20px");
		mainClassificationProgressBar.addStyleName("mainClassificationSkillProgress");
		return mainClassificationProgressBar;
	}

	@Override
	public void setPresenter(presenter presenter) {
	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	@Override
	public FlexTable getProgressFlexTable() {
		return progressFlexTable;
	}

	@Override
	public void setProgressFlexTable(FlexTable progressFlexTable) {
		this.progressFlexTable = progressFlexTable;
	}

	@Override
	public CustomPager getPager() {
		return pager;
	}

	@Override
	public StudentProxy getStudent() {
		return student;
	}

	@Override
	public void setStudent(StudentProxy student) {
		this.student = student;
	}

}
