// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "logbook.server.domain.MainClassification", locator = "logbook.server.locator.MainClassificationLocator")
public interface MainClassificationProxy extends EntityProxy {

    abstract Long getId();

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract String getShortcut();

    abstract void setShortcut(String shortcut);

    abstract List<ClassificationTopicProxy> getClassificationTopics();

    abstract void setClassificationTopics(List<ClassificationTopicProxy> classificationTopics);

    abstract Integer getVersion();
}
