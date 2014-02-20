package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Topic;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class TopicLocator extends Locator<Topic, Long> {

    public Topic create(Class<? extends Topic> clazz) {
        return new Topic();
    }

    public Topic find(Class<? extends Topic> clazz, Long id) {
        return Topic.findTopic(id);
    }

    public Class<Topic> getDomainType() {
        return Topic.class;
    }

    public Long getId(Topic topic) {
        return topic.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Topic topic) {
        return topic.getVersion();
    }
}
