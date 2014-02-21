package ch.unibas.medizin.logbook.client;

import ch.unibas.medizin.logbook.shared.enums.Locale;

import com.google.gwt.user.client.ui.IsWidget;

public interface LogBookHeader extends IsWidget {
	public interface Delegate {
		public void changeLocale(Locale locale);

		public void changeRecordValue(String val);
	}

	public void setDelegate(Delegate delegate);
}
