package ch.unibas.medizin.logbook.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.Administrator", locator = "ch.unibas.medizin.logbook.server.locator.AdministratorLocator")
public interface AdministratorProxy extends EntityProxy {

	abstract Long getId();

	abstract String getEmail();

	abstract void setEmail(String email);

	abstract String getName();

	abstract void setName(String name);

	abstract String getPreName();

	abstract void setPreName(String preName);

	abstract Integer getVersion();
}
