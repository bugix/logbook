package ch.unibas.medizin.logbook.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface AdminView extends IsWidget {

	interface Delegate {
		void exportStudentClicked(boolean checkboxSelected);
	}

	interface presenter {
		void goTo(Place place);
	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);

	public Label getLblNameVal();

	public Label getLblPrenameVal();

	public Label getLblEmailVal();

}
