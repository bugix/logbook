// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import ch.unibas.medizin.logbook.client.managed.proxy.MainClassificationProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.MainClassification")
public interface MainClassificationRequest extends RequestContext {

    abstract Request<java.lang.Long> countMainClassifications();

    abstract Request<java.util.List<MainClassificationProxy>> findAllMainClassifications();

    abstract Request<java.util.List<MainClassificationProxy>> findMainClassificationEntries(int firstResult, int maxResults);

    abstract Request<MainClassificationProxy> findMainClassification(Long id);

    abstract InstanceRequest<MainClassificationProxy, Void> persist();

    abstract InstanceRequest<MainClassificationProxy, Void> remove();
}
