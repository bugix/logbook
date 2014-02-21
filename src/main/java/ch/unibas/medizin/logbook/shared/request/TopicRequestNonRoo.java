package ch.unibas.medizin.logbook.shared.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicFilteredResultProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;
import ch.unibas.medizin.logbook.server.domain.Topic;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Topic.class)
public interface TopicRequestNonRoo extends RequestContext {
	abstract Request<List<TopicProxy>> findTopicByClassficationId(Long value);

	abstract Request<TopicFilteredResultProxy> findTopicOrderByClassification(int start, int max, StudentProxy studentProxy);

}
