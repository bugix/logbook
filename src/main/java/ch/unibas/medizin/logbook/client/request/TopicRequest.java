package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicFilteredResultProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Topic")
public interface TopicRequest extends RequestContext {

	//abstract Request<Long> countTopics();

	//abstract Request<List<TopicProxy>> findAllTopics();

	//abstract Request<List<TopicProxy>> findTopicEntries(int firstResult, int maxResults);

	//abstract Request<TopicProxy> findTopic(Long id);

	//abstract InstanceRequest<TopicProxy, Void> persist();

	//abstract InstanceRequest<TopicProxy, Void> remove();
	
	abstract Request<List<TopicProxy>> findTopicByClassficationId(Long value);

	abstract Request<TopicFilteredResultProxy> findTopicOrderByClassification(int start, int max, StudentProxy studentProxy);
}
