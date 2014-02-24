package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Student;
import ch.unibas.medizin.logbook.server.domain.Topic;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class TopicLocator extends Locator<Topic, Long> {

	@Override
	public Topic create(Class<? extends Topic> clazz) {
		return new Topic();
	}

	@Override
	public Topic find(Class<? extends Topic> clazz, Long id) {
		return Topic.findTopic(id);
	}

	@Override
	public Class<Topic> getDomainType() {
		return Topic.class;
	}

	@Override
	public Long getId(Topic topic) {
		return topic.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Topic topic) {
		return topic.getVersion();
	}
	
	@Override
	public boolean isLive(Topic topic) {
		return true;
	}
}
