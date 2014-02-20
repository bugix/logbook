// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import java.util.List;

import org.springframework.roo.addon.gwt.RooGwtProxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

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

    abstract List<TopicProxy> getTopics();

    abstract void setTopics(List<TopicProxy> topics);

    abstract Integer getVersion();
}
