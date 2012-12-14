package logbook.client.a_nonroo.app.activities;



import logbook.client.a_nonroo.app.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
/**
 * ActivityMapper for all main places. 
 * @author masterthesis
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
		Log.debug("im McAppActivityMapper.getActivity");

		 
		 
		 

		 Log.debug("im McAppActivityMapper.getActivity, return null");
		return null;
	}



}
