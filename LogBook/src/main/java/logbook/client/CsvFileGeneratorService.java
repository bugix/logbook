package logbook.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * 
 * @author Manish
 *
 */
@RemoteServiceRelativePath("CsvFileGenerator")
public interface CsvFileGeneratorService extends RemoteService {

	void csvFileGeneratorClicked(boolean isChangeFinalizeToExportdSelected);
}
