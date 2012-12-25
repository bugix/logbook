package logbook.shared.scaffold;

import java.util.List;

import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.server.domain.Topic;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Topic.class)
public interface TopicRequestNonRoo extends RequestContext {
	abstract Request<List<TopicProxy>> findTopicByClassficationId(Long value);

}
