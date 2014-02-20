// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.Topic")
@ServiceName("logbook.server.domain.Topic")
public interface TopicRequest extends RequestContext {

    abstract Request<java.lang.Long> countTopics();

    abstract Request<java.util.List<logbook.client.managed.proxy.TopicProxy>> findAllTopics();

    abstract Request<java.util.List<logbook.client.managed.proxy.TopicProxy>> findTopicEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.TopicProxy> findTopic(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.TopicProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.TopicProxy, java.lang.Void> remove();
}
