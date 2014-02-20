package logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import logbook.server.domain.Topic;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.Topic")
@Component
public class TopicLocator extends Locator<Topic, Long> {

    public Topic create(Class<? extends logbook.server.domain.Topic> clazz) {
        return new Topic();
    }

    public Topic find(Class<? extends logbook.server.domain.Topic> clazz, Long id) {
        return Topic.findTopic(id);
    }

    public Class<logbook.server.domain.Topic> getDomainType() {
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
