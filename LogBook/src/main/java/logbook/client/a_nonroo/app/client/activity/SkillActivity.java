package logbook.client.a_nonroo.app.client.activity;

import logbook.client.a_nonroo.app.client.LogBookNav;
import logbook.client.a_nonroo.app.client.place.SkillPlace;
import logbook.client.a_nonroo.app.client.ui.SkillView;
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
public class SkillActivity extends AbstractActivity implements
		SkillView.presenter, SkillView.Delegate {

	private LogBookRequestFactory requests;
	private PlaceController placeController;
	private AcceptsOneWidget widget;
	private SkillView view;
	// private StudentSubDetailsView view_s = new StudentSubDetailsViewImpl();
	private SkillActivity skillActivity;
	private SkillPlace place;
	private int tabIndex = 0;

	private ActivityManager activityManager;
	// private StudentProxy studentProxy;

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
		SkillView systemStartView = new SkillViewImpl();
		systemStartView.setPresenter(this);
		this.view = systemStartView;

		widget.setWidget(systemStartView.asWidget());
		view.setDelegate(this);

	}

	@Override
	public void goTo(Place place) {

	}

}
