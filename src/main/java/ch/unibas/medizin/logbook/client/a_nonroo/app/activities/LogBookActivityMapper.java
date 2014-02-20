package ch.unibas.medizin.logbook.client.a_nonroo.app.activities;



import ch.unibas.medizin.logbook.client.a_nonroo.app.client.activity.AdminActivity;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.activity.LoginActivity;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.activity.ProgressActivity;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.activity.SkillActivity;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.AdminPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.ProgressPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.SkillPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
/**
 * ActivityMapper for all main places. 
 * @author Manish
 *
 */
public class LogBookActivityMapper implements ActivityMapper {



	private LogBookRequestFactory requests;
	private PlaceController placeController;


	@Inject
	public LogBookActivityMapper(LogBookRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

	
	@Override
	public Activity getActivity(Place place) {
		Log.debug("im LogBookActivityMapper.getActivity");

		if (place instanceof LoginPlace) {
			Log.debug("is LoginPlace");
			return new LoginActivity(requests, placeController);
		}
		if (place instanceof SkillPlace) {
			Log.debug("is SkillPlace");
			return new SkillActivity(requests, placeController);
		}
		if (place instanceof ProgressPlace) {
			Log.debug("is ProgressPlace");
			return new ProgressActivity(requests, placeController);
		}
		if (place instanceof AdminPlace) {
			Log.debug("is AdminPlace");
			return new AdminActivity(requests, placeController);
		}
		
		
		return null;
		 
		 

		/* Log.debug("im McAppActivityMapper.getActivity, return null");
		return null;*/
	}



}
