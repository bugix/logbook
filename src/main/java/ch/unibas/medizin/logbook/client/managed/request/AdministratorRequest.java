// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.Administrator")
@ServiceName("logbook.server.domain.Administrator")
public interface AdministratorRequest extends RequestContext {

    abstract Request<java.lang.Long> countAdministrators();

    abstract Request<java.util.List<logbook.client.managed.proxy.AdministratorProxy>> findAllAdministrators();

    abstract Request<java.util.List<logbook.client.managed.proxy.AdministratorProxy>> findAdministratorEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.AdministratorProxy> findAdministrator(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.AdministratorProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.AdministratorProxy, java.lang.Void> remove();
}
