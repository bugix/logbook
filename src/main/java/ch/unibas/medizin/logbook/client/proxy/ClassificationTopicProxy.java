package ch.unibas.medizin.logbook.client.proxy;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.ClassificationTopic", locator = "ch.unibas.medizin.logbook.server.locator.ClassificationTopicLocator")
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
