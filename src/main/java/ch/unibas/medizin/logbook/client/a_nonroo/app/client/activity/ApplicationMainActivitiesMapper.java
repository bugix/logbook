package ch.unibas.medizin.logbook.client.a_nonroo.app.client.activity;


import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.AdminPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.SkillPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public class ApplicationMainActivitiesMapper implements ActivityMapper {

	public static HandlerManager handler;
	private LogBookRequestFactory requests;
	private PlaceController placeController;
	

	@Inject
	public ApplicationMainActivitiesMapper(LogBookRequestFactory requests,
			PlaceController placeController) {
		this.requests = requests;
		this.placeController = placeController;
	}

	@Override
	public Activity getActivity(Place place) {
		Log.debug("ApplicationMainActivitiesMapper.getActivity"
				+ placeController.getWhere());

		if (place instanceof LoginPlace) {
			Log.debug("is LoginPlace");
			return new LoginActivity(requests, placeController);
		}
		if (place instanceof SkillPlace) {
			Log.debug("is SkillPlace");
			return new SkillActivity(requests, placeController);
		}
		if (place instanceof AdminPlace) {
			Log.debug("is AdminPlace");
			return new AdminActivity(requests, placeController);
		}
		return null;
	}

}
