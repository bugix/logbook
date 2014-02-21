package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.ClassificationTopic")
public interface ClassificationTopicRequest extends RequestContext {

	abstract Request<Long> countClassificationTopics();

	abstract Request<List<ClassificationTopicProxy>> findAllClassificationTopics();

	abstract Request<List<ClassificationTopicProxy>> findClassificationTopicEntries(int firstResult, int maxResults);

	abstract Request<ClassificationTopicProxy> findClassificationTopic(Long id);

	abstract InstanceRequest<ClassificationTopicProxy, Void> persist();

	abstract InstanceRequest<ClassificationTopicProxy, Void> remove();
}
