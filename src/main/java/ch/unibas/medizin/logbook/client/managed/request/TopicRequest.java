// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import ch.unibas.medizin.logbook.client.managed.proxy.TopicProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Topic")
public interface TopicRequest extends RequestContext {

    abstract Request<java.lang.Long> countTopics();

    abstract Request<java.util.List<TopicProxy>> findAllTopics();

    abstract Request<java.util.List<TopicProxy>> findTopicEntries(int firstResult, int maxResults);

    abstract Request<TopicProxy> findTopic(Long id);

    abstract InstanceRequest<TopicProxy, Void> persist();

    abstract InstanceRequest<TopicProxy, Void> remove();
}
