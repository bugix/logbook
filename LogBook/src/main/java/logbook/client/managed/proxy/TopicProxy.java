// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.List;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.Topic", locator = "logbook.server.locator.TopicLocator")
@RooGwtProxy(value = "logbook.server.domain.Topic", readOnly = { "version", "id" }, scaffold = true)
public interface TopicProxy extends EntityProxy {

    abstract Long getId();

    abstract String getTopicDescription();

    abstract void setTopicDescription(String topicDescription);

    abstract List<logbook.client.managed.proxy.SkillProxy> getSkills();

    abstract void setSkills(List<logbook.client.managed.proxy.SkillProxy> skills);

    abstract ClassificationTopicProxy getClassificationTopic();

    abstract void setClassificationTopic(ClassificationTopicProxy classificationTopic);

    abstract Integer getVersion();
}
