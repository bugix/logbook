package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.ClassificationTopic;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class ClassificationTopicLocator extends Locator<ClassificationTopic, Long> {

    public ClassificationTopic create(Class<? extends ClassificationTopic> clazz) {
        return new ClassificationTopic();
    }

    public ClassificationTopic find(Class<? extends ClassificationTopic> clazz, Long id) {
        return ClassificationTopic.findClassificationTopic(id);
    }

    public Class<ClassificationTopic> getDomainType() {
        return ClassificationTopic.class;
    }

    public Long getId(ClassificationTopic classificationTopic) {
        return classificationTopic.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(ClassificationTopic classificationTopic) {
        return classificationTopic.getVersion();
    }
}
