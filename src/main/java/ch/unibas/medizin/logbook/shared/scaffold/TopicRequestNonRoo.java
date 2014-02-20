package ch.unibas.medizin.logbook.shared.scaffold;

import java.util.List;

import ch.unibas.medizin.logbook.client.a_nonroo.app.client.TopicFilteredResultProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.TopicProxy;
import ch.unibas.medizin.logbook.server.domain.Topic;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Topic.class)
public interface TopicRequestNonRoo extends RequestContext {
	abstract Request<List<TopicProxy>> findTopicByClassficationId(Long value);
	abstract Request<TopicFilteredResultProxy> findTopicOrderByClassification(int start,int max,StudentProxy studentProxy);

}
