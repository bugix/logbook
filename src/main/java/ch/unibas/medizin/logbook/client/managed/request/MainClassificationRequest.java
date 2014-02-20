// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.MainClassification")
@ServiceName("logbook.server.domain.MainClassification")
public interface MainClassificationRequest extends RequestContext {

    abstract Request<java.lang.Long> countMainClassifications();

    abstract Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> findAllMainClassifications();

    abstract Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> findMainClassificationEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.MainClassificationProxy> findMainClassification(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.MainClassificationProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.MainClassificationProxy, java.lang.Void> remove();
}
