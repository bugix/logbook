// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import ch.unibas.medizin.logbook.client.managed.proxy.AdministratorProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("logbook.server.domain.Administrator")
public interface AdministratorRequest extends RequestContext {

    abstract Request<java.lang.Long> countAdministrators();

    abstract Request<java.util.List<AdministratorProxy>> findAllAdministrators();

    abstract Request<java.util.List<AdministratorProxy>> findAdministratorEntries(int firstResult, int maxResults);

    abstract Request<AdministratorProxy> findAdministrator(Long id);

    abstract InstanceRequest<AdministratorProxy, java.lang.Void> persist();

    abstract InstanceRequest<AdministratorProxy, java.lang.Void> remove();
}
