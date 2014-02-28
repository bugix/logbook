package ch.unibas.medizin.logbook.client.navigation;

import ch.unibas.medizin.logbook.client.place.AdminPlace;
import ch.unibas.medizin.logbook.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.place.ProgressPlace;
import ch.unibas.medizin.logbook.client.place.SkillPlace;

import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;

public class FilterForMainPlaces implements FilteredActivityMapper.Filter {

	@Override
	public Place filter(Place place) {

		if (place instanceof LoginPlace) {
			return place;
		}

		if (place instanceof AdminPlace) {
			return place;
		}

		if (place instanceof SkillPlace) {
			return place;
		}

		if (place instanceof ProgressPlace) {
			return place;
		}

		return null;
	}

}
