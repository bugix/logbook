package logbook.client.a_nonroo.app.client.place;



import logbook.shared.scaffold.Operation;

import com.google.web.bindery.requestfactory.shared.EntityProxyId;





public abstract class LogBookDetailsPlace extends LogBookPlace {
	public abstract Operation getOperation();
	public abstract EntityProxyId<?> getProxyId();
}
