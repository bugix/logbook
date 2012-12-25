package logbook.client.a_nonroo.app.client.activity;

import java.util.Iterator;
import java.util.List;

import logbook.client.a_nonroo.app.client.place.SkillPlace;
import logbook.client.a_nonroo.app.client.ui.SkillView;
import logbook.client.a_nonroo.app.client.ui.SkillViewImpl;
import logbook.client.a_nonroo.app.request.LogBookRequestFactory;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl.simple.DefaultSuggestOracle;
import logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.web.bindery.requestfactory.shared.Receiver;


/**
 * @author Manish
 * 
 */
public class SkillActivity extends AbstractActivity implements
		SkillView.presenter, SkillView.Delegate {

	private LogBookRequestFactory requests;
	private PlaceController placeController;
	private AcceptsOneWidget widget;
	private SkillView view;
	 private Long mainClassificationId =null;
	 private Long classificaitonTopicId = null;
	 private Long topicId =null;
	 private SkillView systemStartView;
	private SkillActivity skillActivity;
	private SkillPlace place;
	private int tabIndex = 0;

	private ActivityManager activityManager;
	private FlexTable skillFlexTable;
	LogBookConstants constants = GWT.create(LogBookConstants.class);

	public HandlerManager handlerManager;// = new HandlerManager(this);
	// private HandlerRegistration rangeChangeHandler;

	public int currenttab = 0;

	public SkillActivity(LogBookRequestFactory requests,
			PlaceController placeController, SkillPlace skillPlace) {
		Log.info("Call Activity Login");
		this.requests = requests;
		this.placeController = placeController;
		this.place = skillPlace;
		this.handlerManager = skillPlace.handler;

		skillActivity = this;

	}

	/*
	 * public void addSelectChangeHandler(SelectChangeHandler handler) {
	 * handlerManager.addHandler(SelectChangeEvent.getType(), handler);
	 * 
	 * }
	 */

	public SkillActivity(LogBookRequestFactory requests,
			PlaceController placeController) {

		this.requests = requests;
		this.placeController = placeController;
	}

	public void onStop() {
		widget.setWidget(null);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.info("SystemStartActivity.start()");

		this.widget = panel;
		init();
		
	}

	private void init() {
		systemStartView = new SkillViewImpl();
		systemStartView.setPresenter(this);
		this.view = systemStartView;

		widget.setWidget(systemStartView.asWidget());
		view.setDelegate(this);
		
		initAllSkillSuggestions();
		
		initSkillFlexTable();
		
		initSkillTableData();
		
		
		

	}

	private void initSkillTableData() {
		
		skillFlexTable.removeAllRows();
	
		/*String textHeader[] = { "   ", constants.name(), constants.shortcut(), constants.level1(), constants.level2() };
		
		for (int i = 0; i < textHeader.length; i++) {

			skillFlexTable.setText(0, i, textHeader[i]);
		}*/
		/*skillFlexTable.getCellFormatter().addStyleName(0, 0, "flexTableColumnHeader ");
		skillFlexTable.getRowFormatter().addStyleName(0, "flexTableHeader");
		
		
		skillFlexTable.getCellFormatter().addStyleName(0, 0, "flexTableFirstColumnHeader");
		skillFlexTable.getCellFormatter().addStyleName(0, 1, "flexTableColumnHeader");
		skillFlexTable.getCellFormatter().addStyleName(0, 2, "flexTableColumnHeader");		
		
		skillFlexTable.getCellFormatter().addStyleName(0, 3, "flexTableColumnHeader");		
		skillFlexTable.getCellFormatter().addStyleName(0, 4, "flexTableLastColumnHeader");*/
		requests.skillRequestNonRoo().findSkillBySearchCriteria(0, 20, mainClassificationId, classificaitonTopicId, topicId).with("topic","topic.classificationTopic","topic.classificationTopic.mainClassification").fire(new Receiver<List<SkillProxy>>() {

		@Override
		public void onSuccess(List<SkillProxy> response) {
			/*for(SkillProxy skill : response){
				System.out.println("id : " + skill.getId());
			}*/
			
			view.createHeader(view.getSkillFlexTable());
			view.setSource(response);
	/*		if(response != null && response.size() > 0 ){
			System.out.println("Response :" + response.size());
			
			SkillProxy priviosSkill= response.get(0);
			
			Log.info(" Skill Proxy is" + priviosSkill.getId());
			Log.info("Classification : " + priviosSkill.getTopic());
			Log.info("Classification : " + priviosSkill.getTopic().getClassificationTopic());
			Log.info("Classification : " + priviosSkill.getTopic().getClassificationTopic().getMainClassification());
			Log.info("Classification : " + priviosSkill.getTopic().getClassificationTopic().getMainClassification().getDescription());
			
			String description=priviosSkill.getTopic().getClassificationTopic().getMainClassification().getDescription();
			String topic=priviosSkill.getTopic().getTopicDescription();
			
			String mainLabel=priviosSkill.getTopic().getClassificationTopic().getMainClassification().getDescription()!=null ? description+" - "+topic:"This is Main Header";
			
			int totalrow=skillFlexTable.getRowCount();
			skillFlexTable.setText(totalrow,0,mainLabel);
			
			skillFlexTable.getFlexCellFormatter().setColSpan(totalrow, 0, 6);
			
			for (Iterator iterator = response.iterator(); iterator.hasNext();) {
				SkillProxy skillProxy = (SkillProxy) iterator.next();
				//Log.info("new Skill proxy is :" + skillProxy.getId());
				if(priviosSkill.getTopic().getId().longValue()==skillProxy.getTopic().getId().longValue()){
					
					skillFlexTable.setText(skillFlexTable.getRowCount(),1,skillProxy.getDescription()!=null ? skillProxy.getDescription():"Skill ABC");
					
				}
				else{
					priviosSkill=skillProxy;
					topic=priviosSkill.getTopic().getTopicDescription();
					mainLabel=priviosSkill.getTopic().getClassificationTopic().getMainClassification().getDescription();
					totalrow=skillFlexTable.getRowCount();
					skillFlexTable.setText(totalrow,0,mainLabel + " - " + topic);
					skillFlexTable.getFlexCellFormatter().setColSpan(totalrow, 0, 6);
					skillFlexTable.setText(skillFlexTable.getRowCount(),1,skillProxy.getDescription()!=null ? skillProxy.getDescription():"Skill ABC");
				}
				
			}
		}*/
		}
	});
		
	}

	private void initAllSkillSuggestions() {
		
		initMainClassificationSuggestion();
		initClassificationTopicSuggestion(mainClassificationId);
		initTopicSuggestion(classificaitonTopicId);
		
	}
private void initMainClassificationSuggestion() {
		
		requests.mainClassificationRequest().findAllMainClassifications().with("classificationTopics","classificationTopics.topics","topics.skills","skills.skillsAcquired").fire(new Receiver<List<MainClassificationProxy>>() {

			@Override
			public void onSuccess(List<MainClassificationProxy> response) {
				
				DefaultSuggestOracle<MainClassificationProxy> suggestOracle1 = (DefaultSuggestOracle<MainClassificationProxy>) view.getMainClassificationSuggestBox().getSuggestOracle();
				suggestOracle1.setPossiblilities(response);
				view.getMainClassificationSuggestBox().setSuggestOracle(suggestOracle1);
				
				view.getMainClassificationSuggestBox().setRenderer(new AbstractRenderer<MainClassificationProxy>() {

					@Override
					public String render(MainClassificationProxy object) {
						
						if (object != null)
							return (object.getDescription());
						else
							return "";
					}
				});
			}
		});
		
	}
	
	private void initClassificationTopicSuggestion(Long mainClassificationId) {
		
		requests.classificationTopicRequestNonRoo().findClassiTopicByMainClassfication(mainClassificationId).fire(new Receiver<List<ClassificationTopicProxy>>() {

			@Override
			public void onSuccess(List<ClassificationTopicProxy> response) {
				
				DefaultSuggestOracle<ClassificationTopicProxy> suggestOracle = (DefaultSuggestOracle<ClassificationTopicProxy>) view.getClassificationTopicSuggestBox().getSuggestOracle();
				suggestOracle.setPossiblilities(response);
				view.getClassificationTopicSuggestBox().setSuggestOracle(suggestOracle);
				
				view.getClassificationTopicSuggestBox().setRenderer(new AbstractRenderer<ClassificationTopicProxy>() {

					@Override
					public String render(ClassificationTopicProxy object) {
						if (object != null)
							return (object.getDescription());
						else
							return "";
					}
				});
				
			}
		});
	}
private void initTopicSuggestion(Long classificaitonTopicId) {
		
	requests.topicRequestNonRoo().findTopicByClassficationId(classificaitonTopicId).fire(new Receiver<List<TopicProxy>>() {

		@Override
		public void onSuccess(List<TopicProxy> response) {
			
			DefaultSuggestOracle<TopicProxy> suggestOracle = (DefaultSuggestOracle<TopicProxy>) view.getTopicSuggestBox().getSuggestOracle();
			suggestOracle.setPossiblilities(response);
			view.getTopicSuggestBox().setSuggestOracle(suggestOracle);
			
			view.getTopicSuggestBox().setRenderer(new AbstractRenderer<TopicProxy>() {

				@Override
				public String render(TopicProxy object) {
					if (object != null)
						return object.getTopicDescription();
					else
						return "";
				}
			});
			
		}
	});
		
	}
	

	private void initSkillFlexTable() {
		
		skillFlexTable=view.getSkillFlexTable();
		
		/*skillFlexTable.setText(1, 0,"This is sub title of table");
		skillFlexTable.getFlexCellFormatter().setColSpan(1, 0, 6);*/
		
	/*	skillFlexTable.setHTML(2, 0," ");
		skillFlexTable.setHTML(2, 1, "Hello1");
		skillFlexTable.setHTML(2, 2, "S2");
		skillFlexTable.setWidget(2, 3, new CheckBox());
		skillFlexTable.setWidget(2, 4, new CheckBox());*/
		
		
	}

	@Override
	public void goTo(Place place) {

	}

	@Override
	public void mainClassificationSuggestboxChanged(Long mainClassificationId) {
		this.mainClassificationId = mainClassificationId;
		
		view.getClassificationTopicSuggestBox().setSelected(null);
		classificaitonTopicId = null;
		
		initClassificationTopicSuggestion(mainClassificationId);
		
		view.getTopicSuggestBox().setSelected(null);
		topicId = null;
		
		initTopicSuggestion(classificaitonTopicId);
		
		//initSkillTableData();
		
	}

	@Override
	public void classificationTopicSuggestboxChanged(Long classificationId) {
		this.classificaitonTopicId = classificationId;
		
		view.getTopicSuggestBox().setSelected(null);
		topicId = null;
		
		initTopicSuggestion(classificaitonTopicId);
		//initSkillTableData();
		
	}

	@Override
	public void topicSuggestboxChanged(Long topicId) {
		this.topicId=topicId;
		//initSkillTableData();
		
	}

	@Override
	public void resetButtonClicked() {
		
		this.mainClassificationId=null;
		this.classificaitonTopicId=null;
		this.topicId=null;
		
		view.getMainClassificationSuggestBox().setSelected(null);
		view.getClassificationTopicSuggestBox().setSelected(null);
		view.getTopicSuggestBox().setSelected(null);
		
		initAllSkillSuggestions();
		
		initSkillFlexTable();
		
		initSkillTableData();
	}

	@Override
	public void showButtonClicked() {
		this.mainClassificationId=view.getMainClassificationSuggestBox().getSelected() !=null ? view.getMainClassificationSuggestBox().getSelected().getId() : null;
		this.classificaitonTopicId=view.getClassificationTopicSuggestBox().getSelected()!=null ? view.getClassificationTopicSuggestBox().getSelected().getId() : null;
		this.topicId=view.getTopicSuggestBox().getSelected() !=null ? view.getTopicSuggestBox().getSelected().getId():null;
		
		initSkillTableData();
		
	}

	@Override
	public void generatePdfClicked() {
		String url = GWT.getHostPageBaseURL() + "downloadFile";
		System.out.println("URL :" + url);
		Window.open(url, "", "");
		
	}

	@Override
	public void printPdfClicked() {
		requests.skillRequestNonRoo().retrieveHtmlFile().fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				
				Print.it(response);
			}
			
		});
	
	}
	
}
