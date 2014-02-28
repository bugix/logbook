package ch.unibas.medizin.logbook.client.navigation;

import ch.unibas.medizin.logbook.client.activity.LogBookActivityMapper;
import ch.unibas.medizin.logbook.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.place.ProgressPlace;
import ch.unibas.medizin.logbook.client.place.SkillPlace;
import ch.unibas.medizin.logbook.client.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * The applications main navigation element, shown on the left hand side of the
 * user interface.
 */
public class LogBookNav extends Composite {

	LogBookConstants constants = GWT.create(LogBookConstants.class);

	private static LogBookNavUiBinder uiBinder = GWT.create(LogBookNavUiBinder.class);

	interface LogBookNavUiBinder extends UiBinder<Widget, LogBookNav> {
	}

	public LogBookNav() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ActivityManager masterActivityManager = null;

	private PlaceController placeController;
	public static LogBookNav logBookNav;

	@UiField
	TabLayoutPanel mainLogBookTabpanel;

	public TabLayoutPanel getMainLogBookTabpanel() {
		return mainLogBookTabpanel;
	}

	@UiField
	Label login;

	@UiField
	Label skill;

	@UiField
	Label progress;

	@Inject
	public LogBookNav(LogBookRequestFactory requests, PlaceController placeController, final PlaceHistoryHandler placeHistoryHandler, LogBookActivityMapper mcAppActivitiesMapper, EventBus eventBus) {

		initWidget(uiBinder.createAndBindUi(this));
		this.placeController = placeController;

		login.setText(constants.home());
		skill.setText(constants.skill());
		progress.setText(constants.progress());

		logBookNav = this;

		SkillPlace.nav = logBookNav;

		CachingActivityMapper cached = new CachingActivityMapper(mcAppActivitiesMapper);
		FilterForMainPlaces filterForMainPlaces = new FilterForMainPlaces();
		ActivityMapper masterActivityMap = new FilteredActivityMapper(filterForMainPlaces, cached);
		masterActivityManager = new ActivityManager(masterActivityMap, eventBus);
		masterActivityManager.setDisplay((SimplePanel) mainLogBookTabpanel.getWidget(mainLogBookTabpanel.getSelectedIndex()));

		// Fix in default style( without it tab content will not show properly)
		mainLogBookTabpanel.getElement().getChild(2).getChild(0).getParentElement().getStyle().setPosition(Position.RELATIVE);
		Element element = mainLogBookTabpanel.getElement().getChild(2).getChild(0).getParentElement();
		element.getChild(0).getChild(2).getChild(0).getParentElement().getStyle().setPosition(Position.RELATIVE);
		Log.debug("HTML :" + element.getChild(0).getChild(2).getChild(0).getParentElement());
	}

	protected void changeMenue(Place place) {
	}

	@UiHandler("login")
	public void loginClicked(ClickEvent event) {
	}

	@UiHandler("skill")
	public void skillClicked(ClickEvent event) {
	}

	@UiHandler("progress")
	public void progressClicked(ClickEvent event) {
	}

	@UiHandler("mainLogBookTabpanel")
	public void tabSelectionChanged(SelectionEvent<Integer> event) {
		masterActivityManager.setDisplay((SimplePanel) mainLogBookTabpanel.getWidget(event.getSelectedItem()));
		if (event.getSelectedItem() == 0) {
			logBookNav.placeController.goTo(new LoginPlace("LoginPlace"));
		} else if (event.getSelectedItem() == 1) {
			logBookNav.placeController.goTo(new SkillPlace());
		} else if (event.getSelectedItem() == 2) {
			logBookNav.placeController.goTo(new ProgressPlace());
		}

	}
}
