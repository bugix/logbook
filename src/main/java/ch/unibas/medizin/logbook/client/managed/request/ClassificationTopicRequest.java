// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.ClassificationTopic")
@ServiceName("logbook.server.domain.ClassificationTopic")
public interface ClassificationTopicRequest extends RequestContext {

    abstract Request<java.lang.Long> countClassificationTopics();

    abstract Request<java.util.List<logbook.client.managed.proxy.ClassificationTopicProxy>> findAllClassificationTopics();

    abstract Request<java.util.List<logbook.client.managed.proxy.ClassificationTopicProxy>> findClassificationTopicEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.ClassificationTopicProxy> findClassificationTopic(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.ClassificationTopicProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.ClassificationTopicProxy, java.lang.Void> remove();
}
