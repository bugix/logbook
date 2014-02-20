package ch.unibas.medizin.logbook.client.scaffold;

import ch.unibas.medizin.logbook.client.managed.request.ApplicationEntityTypesProcessor;
import ch.unibas.medizin.logbook.client.scaffold.place.ProxyListPlace;
import ch.unibas.medizin.logbook.client.scaffold.gae.*;
import com.google.web.bindery.requestfactory.shared.EntityProxy;

import java.util.HashSet;
import java.util.Set;

public class ScaffoldApp {

	static boolean isMobile = false;

	public static boolean isMobile() {
		return isMobile;
	}

	public void run() {
	}

	protected HashSet<ProxyListPlace> getTopPlaces() {
		Set<Class<? extends EntityProxy>> types = ApplicationEntityTypesProcessor.getAll();
		HashSet<ProxyListPlace> rtn = new HashSet<ProxyListPlace>(types.size());

		for (Class<? extends EntityProxy> type : types) {
			rtn.add(new ProxyListPlace(type));
		}

		return rtn;
	}
}
