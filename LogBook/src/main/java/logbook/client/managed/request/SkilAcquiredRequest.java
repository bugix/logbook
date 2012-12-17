// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.SkilAcquired")
@ServiceName("logbook.server.domain.SkilAcquired")
public interface SkilAcquiredRequest extends RequestContext {

    abstract Request<java.lang.Long> countSkilAcquireds();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkilAcquiredProxy>> findAllSkilAcquireds();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkilAcquiredProxy>> findSkilAcquiredEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.SkilAcquiredProxy> findSkilAcquired(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.SkilAcquiredProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.SkilAcquiredProxy, java.lang.Void> remove();
}
