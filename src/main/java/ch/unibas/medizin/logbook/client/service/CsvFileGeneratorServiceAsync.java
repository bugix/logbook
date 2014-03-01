package ch.unibas.medizin.logbook.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CsvFileGeneratorServiceAsync {
	void csvFileGeneratorClicked(boolean isChangeFinalizeToExportedSelected, AsyncCallback<Void> callback);
}
