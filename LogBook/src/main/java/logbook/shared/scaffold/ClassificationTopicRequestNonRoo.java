package logbook.shared.scaffold;

import java.util.List;

import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.server.domain.ClassificationTopic;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(ClassificationTopic.class)
public interface ClassificationTopicRequestNonRoo extends RequestContext {
	abstract Request<List<ClassificationTopicProxy>> findClassiTopicByMainClassfication(Long value);

}
