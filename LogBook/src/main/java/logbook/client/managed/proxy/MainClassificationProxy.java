// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.MainClassification", locator = "logbook.server.locator.MainClassificationLocator")
@RooGwtProxy(value = "logbook.server.domain.MainClassification", readOnly = { "version", "id" }, scaffold = true)
public interface MainClassificationProxy extends EntityProxy {

    abstract Long getId();

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract String getShortcut();

    abstract void setShortcut(String shortcut);

    abstract Set<logbook.client.managed.proxy.ClassificationTopicProxy> getClassificationTopics();

    abstract void setClassificationTopics(Set<logbook.client.managed.proxy.ClassificationTopicProxy> classificationTopics);

    abstract Integer getVersion();
}
