// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import org.springframework.roo.addon.gwt.RooGwtRequest;

import ch.unibas.medizin.logbook.client.managed.proxy.ClassificationTopicProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@RooGwtRequest("logbook.server.domain.ClassificationTopic")
@ServiceName("logbook.server.domain.ClassificationTopic")
public interface ClassificationTopicRequest extends RequestContext {

    abstract Request<java.lang.Long> countClassificationTopics();

    abstract Request<java.util.List<ClassificationTopicProxy>> findAllClassificationTopics();

    abstract Request<java.util.List<ClassificationTopicProxy>> findClassificationTopicEntries(int firstResult, int maxResults);

    abstract Request<ClassificationTopicProxy> findClassificationTopic(Long id);

    abstract InstanceRequest<ClassificationTopicProxy, java.lang.Void> persist();

    abstract InstanceRequest<ClassificationTopicProxy, java.lang.Void> remove();
}
