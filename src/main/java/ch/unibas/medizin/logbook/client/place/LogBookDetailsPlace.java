package ch.unibas.medizin.logbook.client.place;

import ch.unibas.medizin.logbook.shared.enums.Operation;

import com.google.web.bindery.requestfactory.shared.EntityProxyId;

public abstract class LogBookDetailsPlace extends LogBookPlace {
	public abstract Operation getOperation();

	public abstract EntityProxyId<?> getProxyId();
}
