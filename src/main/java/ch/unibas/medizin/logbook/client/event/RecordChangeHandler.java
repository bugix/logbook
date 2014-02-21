package ch.unibas.medizin.logbook.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface RecordChangeHandler extends EventHandler {
	void onRecordChange(RecordChangeEvent event);
}
