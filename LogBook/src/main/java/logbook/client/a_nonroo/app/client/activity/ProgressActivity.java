package logbook.client.a_nonroo.app.client.activity;


import logbook.client.a_nonroo.app.client.place.ProgressPlace;
import logbook.client.a_nonroo.app.client.place.SkillPlace;
import logbook.client.a_nonroo.app.client.ui.ProgressView;
import logbook.client.a_nonroo.app.client.ui.ProgressViewImpl;
import logbook.client.a_nonroo.app.client.ui.SkillViewImpl;
import logbook.client.a_nonroo.app.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
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
	

	private ActivityManager activityManager;
	//private StudentProxy studentProxy;


	public HandlerManager handlerManager;// = new HandlerManager(this);
//	private HandlerRegistration rangeChangeHandler;
	
	public int currenttab= 0;	
	
	
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
		

	}
	

	private void init(){
		ProgressView systemStartView = new ProgressViewImpl();
		systemStartView.setPresenter(this);
		this.view = systemStartView;
		
		widget.setWidget(systemStartView.asWidget());
		view.setDelegate(this);
		
	}

	
	@Override
	public void goTo(Place place) {
		
	}


	
	
}	
