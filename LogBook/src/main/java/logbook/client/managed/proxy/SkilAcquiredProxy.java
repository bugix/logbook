// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.SkilAcquired", locator = "logbook.server.locator.SkilAcquiredLocator")
@RooGwtProxy(value = "logbook.server.domain.SkilAcquired", readOnly = { "version", "id" }, scaffold = true)
public interface SkilAcquiredProxy extends EntityProxy {

    abstract Long getId();

    abstract Integer getVersion();
}
