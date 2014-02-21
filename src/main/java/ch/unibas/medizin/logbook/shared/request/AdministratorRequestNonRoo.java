package ch.unibas.medizin.logbook.shared.request;

import ch.unibas.medizin.logbook.client.proxy.AdministratorProxy;
import ch.unibas.medizin.logbook.server.domain.Administrator;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Administrator.class)
public interface AdministratorRequestNonRoo extends RequestContext {
	abstract Request<AdministratorProxy> findAdministratorFromSession();
}
