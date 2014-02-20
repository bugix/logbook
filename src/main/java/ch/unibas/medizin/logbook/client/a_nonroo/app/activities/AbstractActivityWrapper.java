package ch.unibas.medizin.logbook.client.a_nonroo.app.activities;

import ch.unibas.medizin.logbook.client.a_nonroo.app.request.LogBookRequestFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
/**
 * This wrapper is used to provide access control in all activities.
 * @author Manish
 *
 */

abstract public class AbstractActivityWrapper extends AbstractActivity {

	private LogBookRequestFactory requests;
	private PlaceController placeController;
	private Place place;

	
	public AbstractActivityWrapper(Place place,
			LogBookRequestFactory requests, PlaceController placeController) {
		this.place = place;
        this.requests = requests;
        this.placeController = placeController;
	}

	
	private int count = 0;
	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {

	}
	/**
	 * Checks if user is logged, if not login dialog is shown.
	 * @param panel
	 * @param eventBus
	 */
	public void newStart(AcceptsOneWidget panel, EventBus eventBus){
		count ++;
		
		if(count<2){
			return;
		}

		start2(panel, eventBus);
	}
	
	public abstract void start2(AcceptsOneWidget panel, EventBus eventBus);

}
