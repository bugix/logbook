package logbook.client.a_nonroo.app.client.ui;



import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface SkillView extends IsWidget{
	 /* * Implemented by the owner of the view.
	 */
	interface Delegate {

	
		
	}
	
	interface presenter {
		
		void goTo(Place place);
		
	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);
	

}
