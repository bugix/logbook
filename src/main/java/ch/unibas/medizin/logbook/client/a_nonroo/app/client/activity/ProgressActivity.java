package ch.unibas.medizin.logbook.client.a_nonroo.app.client.activity;


import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import ch.unibas.medizin.logbook.client.ApplicationLoadingScreenEvent;
import ch.unibas.medizin.logbook.client.ApplicationLoadingScreenHandler;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.TopicFilteredResultProxy;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.ProgressPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui.ProgressView;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui.ProgressViewImpl;
import ch.unibas.medizin.logbook.client.a_nonroo.app.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.client.managed.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.TopicProxy;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
/**
 * @author Manish
 *
 */
public class ProgressActivity extends AbstractActivity implements ProgressView.presenter, ProgressView.Delegate{
	
	private LogBookRequestFactory requests;
	private PlaceController placeController;
	private AcceptsOneWidget widget;
	private ProgressView view;
	private ProgressActivity progressActivity;
	private ProgressPlace place;
	private int tabIndex=0; 
	private StudentProxy studentProxy;
	private List<MainClassificationProxy> mainClassificationProxyList;
	private List<ClassificationTopicProxy> classificationTopicProxyList;
	private List<TopicProxy> topicProxyList;
	//private final StudentProgressServiceAsync studentProgressServiceAsync = GWT.create(StudentProgressService.class);

	private ActivityManager activityManager;
	//private StudentProxy studentProxy;
	

	public HandlerManager handlerManager;// = new HandlerManager(this);
//	private HandlerRegistration rangeChangeHandler;
	
	public int currenttab= 0;	
	
	public FlexTable progressFlexTable;
	
	
	public ProgressActivity(LogBookRequestFactory requests, PlaceController placeController,ProgressPlace progressPlace) 
	{
		Log.info("Call Activity Login");
    	this.requests = requests;
    	this.placeController = placeController;
    	this.place = progressPlace;
    	this.handlerManager = progressPlace.handler;

    	progressActivity = this;

	}	
	
	
	/*public void addSelectChangeHandler(SelectChangeHandler handler) {
		handlerManager.addHandler(SelectChangeEvent.getType(), handler);
		
	}*/
	
	public ProgressActivity(LogBookRequestFactory requests , PlaceController placeController) {
		
		this.requests = requests;
    	this.placeController = placeController;
	}

	
	public void onStop(){
		widget.setWidget(null);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.info("SystemStartActivity.start()");
		
		this.widget = panel;
		init();
		initProgressFlexTable();
		initLoading();
	
		requests.studentRequestNonRoo().findStudentFromSession().fire(new Receiver<StudentProxy>() {

			@Override
			public void onSuccess(StudentProxy response) {
				
				initProgressFlexTableData(response);				
			}
		});
	}
		

	private void initLoading() 
	{
			ApplicationLoadingScreenEvent.initialCounter();
			ApplicationLoadingScreenEvent.register(requests.getEventBus(),
					new ApplicationLoadingScreenHandler() {
						@Override
						public void onEventReceived(
								ApplicationLoadingScreenEvent event) {
							event.display();
						}
					});
	}


	private void initProgressFlexTable() 
	{
		progressFlexTable=view.getProgressFlexTable();
	}

	@Override
	public void refreshProgresstable(FlexTable table,int start,int length)
	{
		//initProgressFlexTableData(view.getStudent());
		onRangeChanged(view.getStudent());
	}
	
	private void onRangeChanged(StudentProxy student) 
	{
		progressFlexTable.removeAllRows();
		requests.topicRequestNonRoo().findTopicOrderByClassification(view.getPager().getStart(),view.getPager().getLength(),studentProxy).with("topicList.classificationTopic","topicList.classificationTopic.mainClassification").fire(new Receiver<TopicFilteredResultProxy>() {

			@Override
			public void onSuccess(TopicFilteredResultProxy response) 
			{
				
				//Log.info("Topic List Size: " + response.getTopicList().size());
				//Log.info("Total Topic Size: " + response.getTotalTopicList().size());
				//Log.info("Acquired Topic Size: " + response.getTopicAcquiredList().size());
				
				view.createHeader(view.getProgressFlexTable());
				view.setSource(response.getTopicList(),response.getTotalTopicList(),response.getTopicAcquiredList(),studentProxy);
			}
		});
	}


	private void initProgressFlexTableData(final StudentProxy studentProxy) 
	{
		showApplicationLoading(true);
		progressFlexTable.removeAllRows();
		requests.topicRequestNonRoo().findTopicOrderByClassification(view.getPager().getStart(),view.getPager().getLength(),studentProxy).with("topicList.classificationTopic","topicList.classificationTopic.mainClassification").fire(new Receiver<TopicFilteredResultProxy>() {

			@Override
			public void onSuccess(TopicFilteredResultProxy response) 
			{
				
				//Log.info("Topic List Size: " + response.getTopicList().size());
				//Log.info("Total Topic Size: " + response.getTotalTopicList().size());
				//Log.info("Acquired Topic Size: " + response.getTopicAcquiredList().size());
				showApplicationLoading(false);
				view.getPager().setRowCount(response.getTotalTopics());
				view.createHeader(view.getProgressFlexTable());
				//System.out.println("First Topic: " + response.getTopicList().get(0).getId());
				view.setSource(response.getTopicList(),response.getTotalTopicList(),response.getTopicAcquiredList(),studentProxy);
			}
			@Override
			public void onFailure(ServerFailure error) 
			{
				showApplicationLoading(false);
				super.onFailure(error);
				
			}
			@Override
			public void onConstraintViolation(Set<ConstraintViolation<?>> violations) 
			{
				showApplicationLoading(false);
				super.onConstraintViolation(violations);
			}
		});
	}
	public void showApplicationLoading(Boolean show) {
		requests.getEventBus().fireEvent(new ApplicationLoadingScreenEvent(show));

	}

	private void init(){
		ProgressView systemStartView = new ProgressViewImpl();
		systemStartView.setPresenter(this);
		this.view = systemStartView;
		
		widget.setWidget(systemStartView.asWidget());
		Log.info("HTML :" +systemStartView.asWidget().getElement().getParentElement().getParentElement());
		
		//Fix in default style( without it tab content will not show properly)
		systemStartView.asWidget().getElement().getParentElement().getParentElement().getStyle().setPosition(Position.RELATIVE);
		view.setDelegate(this);
		requests.studentRequestNonRoo().findStudentFromSession().fire(new Receiver<StudentProxy>() {
		
			@Override
			public void onSuccess(StudentProxy response) {
				Log.info("Success");
				studentProxy=response;
				view.setStudent(response);
			}
		});
	}

	
	@Override
	public void goTo(Place place) {
		
	}


	@Override
	public void findProgressOfMainClassification(MainClassificationProxy mainClassificationProxy,final int row,final int i,StudentProxy studentProxy) 
	{
		requests.skillRequestNonRoo().findProgressOfMainClassification(mainClassificationProxy, studentProxy.getId()).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				String mP[]=response.split("/");
				
				view.getProgressFlexTable().setWidget(row, i, view.createProgressBar(new Integer(mP[1]),new Integer(mP[0])));
				((Label)((HorizontalPanel)view.getProgressFlexTable().getWidget(row, 0)).getWidget(1)).setText(response);
				
			}
		});
	}


	@Override
	public void findProgressOfClassificationTopic(ClassificationTopicProxy classificationTopicProxy,final int row,final int i,StudentProxy studentProxy) {
		requests.skillRequestNonRoo().findProgressOfClassificationTopic(classificationTopicProxy, studentProxy.getId()).fire(new Receiver<String>() {

			@Override
			public void onSuccess(String response) {
				String mP[]=response.split("/");
				
				view.getProgressFlexTable().setWidget(row, i, view.createProgressBar(new Integer(mP[1]),new Integer(mP[0])));
				((Label)((HorizontalPanel)view.getProgressFlexTable().getWidget(row, 0)).getWidget(1)).setText(response);
				
			}
		});
		
	}


	
	
}	
