package ch.unibas.medizin.logbook.shared;

import de.novanic.eventservice.client.event.Event;

@SuppressWarnings("serial")
public class CsvFileGeneratorEvent implements Event {

	public Boolean result;

	public CsvFileGeneratorEvent() {
	}

	public CsvFileGeneratorEvent(Boolean result) {
		this.setResult(result);
	}

	public Boolean getResult() {
		return this.result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}
}
