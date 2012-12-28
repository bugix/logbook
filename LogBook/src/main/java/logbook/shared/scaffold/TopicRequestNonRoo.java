package logbook.shared.scaffold;

import java.util.List;

import logbook.client.a_nonroo.app.client.TopicFilteredResultProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.server.domain.Topic;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Topic.class)
public interface TopicRequestNonRoo extends RequestContext {
	abstract Request<List<TopicProxy>> findTopicByClassficationId(Long value);
	abstract Request<TopicFilteredResultProxy> findTopicOrderByClassification(int start,int max,StudentProxy studentProxy);

}
