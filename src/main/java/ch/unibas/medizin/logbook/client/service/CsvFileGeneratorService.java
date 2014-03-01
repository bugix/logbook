package ch.unibas.medizin.logbook.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CsvFileGenerator")
public interface CsvFileGeneratorService extends RemoteService {
	void csvFileGeneratorClicked(boolean isChangeFinalizeToExportedSelected);
}
