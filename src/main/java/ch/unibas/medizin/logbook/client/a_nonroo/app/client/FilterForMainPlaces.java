/**
 * 
 */
package logbook.client.a_nonroo.app.client;



import logbook.client.a_nonroo.app.client.place.AdminPlace;
import logbook.client.a_nonroo.app.client.place.LoginPlace;
import logbook.client.a_nonroo.app.client.place.ProgressPlace;
import logbook.client.a_nonroo.app.client.place.SkillPlace;

import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * @author Manish
 * 
 */
public class FilterForMainPlaces implements FilteredActivityMapper.Filter {

	@Override
	public Place filter(Place place) {
		/**
		 * Login
		 */
		if (place instanceof LoginPlace)
			return (LoginPlace) place;
		
			if (place instanceof AdminPlace)
			return (AdminPlace) place;
			
		/*if (place instanceof LoginDetailsPlace) {
			LoginDetailsPlace loginDetailsPlace = (LoginDetailsPlace) place;
			return new LoginPlace(
					loginDetailsPlace.getToken());
		}*/
		
		if (place instanceof SkillPlace)
			return (SkillPlace) place;

		if (place instanceof ProgressPlace)
			return (ProgressPlace) place;
		
		return null;
	}

}
