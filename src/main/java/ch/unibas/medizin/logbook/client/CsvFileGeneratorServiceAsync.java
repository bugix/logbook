package logbook.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
/**
 * 
 * @author Manish
 *
 */
public interface CsvFileGeneratorServiceAsync {

	void csvFileGeneratorClicked(boolean isChangeFinalizeToExportdSelected,AsyncCallback<Void> callback);

}
