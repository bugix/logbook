// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "logbook.server.domain.Administrator", locator = "logbook.server.locator.AdministratorLocator")
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