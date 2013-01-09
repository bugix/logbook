package logbook.shared;


import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;
/**
 * 
 * @author Manish
 *
 */

public class CsvFileGeneratorListener implements RemoteEventListener {

	@Override
	public void apply(Event anEvent) {
		
		if(anEvent instanceof CsvFileGeneratorEvent){
			csvFileGeneratorEvent((CsvFileGeneratorEvent)anEvent);
		}
	}
public void csvFileGeneratorEvent(CsvFileGeneratorEvent event){
		
	}

}
