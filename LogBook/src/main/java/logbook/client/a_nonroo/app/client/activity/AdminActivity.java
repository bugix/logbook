package logbook.client.a_nonroo.app.client.activity;


import logbook.client.a_nonroo.app.client.place.LoginPlace;
import logbook.client.a_nonroo.app.client.ui.AdminView;
import logbook.client.a_nonroo.app.client.ui.AdminView;
import logbook.client.a_nonroo.app.client.ui.AdminViewImpl;
import logbook.client.a_nonroo.app.request.LogBookRequestFactory;
import logbook.shared.i18n.LogBookConstants;
import logbook.shared.scaffold.LogBookConstant;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

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

	}


	@Override
	public void goTo(Place place) {
		
	}
}	
