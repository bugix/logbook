package ch.unibas.medizin.logbook.client.a_nonroo.app.activities;



import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Converts a {@link #ProxyPlace} to a {@link ProxyListPlace}.
 */
public class FilterForMainPlaces implements FilteredActivityMapper.Filter {

	/**
	 * Required by {@link FilteredActivityMapper.Filter}, calls
	 * {@link #proxyListPlaceFor()}.
	 */
	public Place filter(Place place) {
		
		Log.debug("im FilterForMainPlaces");
		
	           
		 
		 return null;
	}

	/**
	 * @param place a place to process
	 * @return an appropriate ProxyListPlace, or null if the given place has
	 *         nothing to do with proxies
	 */
	/*public ProxyListPlace proxyListPlaceFor(Place place) {
		
		
		
		
		
		
	}*/
}
