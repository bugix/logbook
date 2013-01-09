package logbook.client.a_nonroo.app.client.activity;


import logbook.client.ApplicationLoadingScreenEvent;
import logbook.client.CsvFileGeneratorService;
import logbook.client.CsvFileGeneratorServiceAsync;
import logbook.client.a_nonroo.app.client.place.LoginPlace;
import logbook.client.a_nonroo.app.client.ui.AdminView;
import logbook.client.a_nonroo.app.client.ui.AdminViewImpl;
import logbook.client.a_nonroo.app.request.LogBookRequestFactory;
import logbook.client.managed.proxy.AdministratorProxy;
import logbook.shared.CsvFileGeneratorEvent;
import logbook.shared.CsvFileGeneratorListener;
import logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;

/**
 * @author Darshan
 *
 */
public class AdminActivity extends AbstractActivity implements AdminView.presenter, AdminView.Delegate{
	
	
	private LogBookRequestFactory requests;
	private PlaceController placeController;
	private AcceptsOneWidget widget;
	private AdminView view;
	private AdminActivity adminActivity;
	private LoginPlace place;
	private int tabIndex=0; 
	
	private ActivityManager activityManager;
	
	public HandlerManager handlerManager;// = new HandlerManager(this);
	
	private static final Domain DOMAIN = DomainFactory.getDomain("localhost");
	private CsvFileGeneratorServiceAsync csvFileGeneratorServiceService = GWT.create(CsvFileGeneratorService.class);
	
	LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	
	
	public AdminActivity(LogBookRequestFactory requests, PlaceController placeController,LoginPlace loginPlace) 
	{
		Log.info("Call Activity Login");
		
    	this.requests = requests;
    	this.placeController = placeController;
    	this.place = loginPlace;
    	this.handlerManager = loginPlace.handler;

    	adminActivity = this;

	}	
	
	
	/*public void addSelectChangeHandler(SelectChangeHandler handler) {
		handlerManager.addHandler(SelectChangeEvent.getType(), handler);
		
	}*/
	
	public AdminActivity(LogBookRequestFactory requests , PlaceController placeController) {
		Log.info("Call Admin Activity");
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
		

	}
	

	private void init(){
		AdminView systemStartView = new AdminViewImpl();
		systemStartView.setPresenter(this);
		this.view = systemStartView;
		
		widget.setWidget(systemStartView.asWidget());
		
		//Fix in default style( without it tab content will not show properly)
		Log.info("HTML :" +systemStartView.asWidget().getElement().getParentElement().getParentElement());		
		systemStartView.asWidget().getElement().getParentElement().getParentElement().getStyle().setPosition(Position.RELATIVE);
		
		view.setDelegate(this);	
		
		initAdminDetails();

	}


	private void initAdminDetails() {
		
		requests.administratorRequest().findAdministrator(1l).fire(new Receiver<AdministratorProxy>() {

			@Override
			public void onSuccess(AdministratorProxy response) {
				if(response !=null){
					view.getLblNameVal().setText(response.getName()!=null ?response.getName():"");
					view.getLblPrenameVal().setText(response.getPreName()!=null ?response.getPreName() :"");
					view.getLblEmailVal().setText(response.getEmail()!=null ? response.getEmail():"");
				}
				
			}
		});
		
	}


	@Override
	public void goTo(Place place) {
		
	}


	@Override
	public void exportStudentClicked(boolean checkboxSelected) {
		
		//showApplicationLoading(true);
		//Window.alert("clicked :"  + checkboxSelected);
		RemoteEventServiceFactory theEventServiceFactory = RemoteEventServiceFactory.getInstance();
		final RemoteEventService theEventService = theEventServiceFactory.getRemoteEventService();
		
		theEventService.addListener(DOMAIN, new CsvFileGeneratorListener(){
			public void csvFileGeneratorEvent(CsvFileGeneratorEvent event){
				if(event.getResult()==true){
					
					showApplicationLoading(false);
					theEventService.removeListeners();
					String url = GWT.getHostPageBaseURL() + "exportCSV";
					Log.info("URL :" + url);
					Window.open(url, "", "");
					
				}
				else{
					showApplicationLoading(false);
					System.out.println("Error during file generation");
				}
			
			}
		});
		
		csvFileGeneratorServiceService.csvFileGeneratorClicked(checkboxSelected, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Log.info("Returened Response still file generation process is in execution");	
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				showApplicationLoading(false);
				theEventService.removeListeners();
				Log.info("CsvFile generator  Request Failed Due to" + caught.getMessage());
				caught.printStackTrace();
				
			}
		});
		
		
	}
	public void showApplicationLoading(Boolean show) {
		requests.getEventBus().fireEvent(new ApplicationLoadingScreenEvent(show));
	
	}
}	
