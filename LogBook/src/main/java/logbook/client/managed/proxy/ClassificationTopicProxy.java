// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.List;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.ClassificationTopic", locator = "logbook.server.locator.ClassificationTopicLocator")
@RooGwtProxy(value = "logbook.server.domain.ClassificationTopic", readOnly = { "version", "id" })
public interface ClassificationTopicProxy extends EntityProxy {

    abstract Long getId();

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract String getShortcut();

    abstract void setShortcut(String shortcut);

    abstract MainClassificationProxy getMainClassification();

    abstract void setMainClassification(MainClassificationProxy mainClassification);

    abstract List<logbook.client.managed.proxy.TopicProxy> getTopics();

    abstract void setTopics(List<logbook.client.managed.proxy.TopicProxy> topics);

    abstract Integer getVersion();
}
