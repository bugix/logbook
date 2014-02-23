package ch.unibas.medizin.logbook.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface SkillLevelTextAreaView extends IsWidget {
	/*
	 *  * Implemented by the owner of the view.
	 */
	interface Delegate {
	}

	interface presenter {

		void goTo(Place place);

	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);
}