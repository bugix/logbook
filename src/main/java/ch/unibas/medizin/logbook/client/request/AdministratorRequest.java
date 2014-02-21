// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.AdministratorProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Administrator")
public interface AdministratorRequest extends RequestContext {

    abstract Request<Long> countAdministrators();

    abstract Request<List<AdministratorProxy>> findAllAdministrators();

    abstract Request<List<AdministratorProxy>> findAdministratorEntries(int firstResult, int maxResults);

    abstract Request<AdministratorProxy> findAdministrator(Long id);

    abstract InstanceRequest<AdministratorProxy, Void> persist();

    abstract InstanceRequest<AdministratorProxy, Void> remove();
}
