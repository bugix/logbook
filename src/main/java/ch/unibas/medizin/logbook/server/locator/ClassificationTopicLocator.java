package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Administrator;
import ch.unibas.medizin.logbook.server.domain.ClassificationTopic;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class ClassificationTopicLocator extends Locator<ClassificationTopic, Long> {

	@Override
	public ClassificationTopic create(Class<? extends ClassificationTopic> clazz) {
		return new ClassificationTopic();
	}

	@Override
	public ClassificationTopic find(Class<? extends ClassificationTopic> clazz, Long id) {
		return ClassificationTopic.findClassificationTopic(id);
	}

	@Override
	public Class<ClassificationTopic> getDomainType() {
		return ClassificationTopic.class;
	}

	@Override
	public Long getId(ClassificationTopic classificationTopic) {
		return classificationTopic.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(ClassificationTopic classificationTopic) {
		return classificationTopic.getVersion();
	}
	
	@Override
	public boolean isLive(ClassificationTopic classificationTopic) {
		return true;
	}
}
