// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import java.util.List;

import org.springframework.roo.addon.gwt.RooGwtProxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "logbook.server.domain.Topic", locator = "logbook.server.locator.TopicLocator")
public interface TopicProxy extends EntityProxy {

    abstract Long getId();

    abstract String getTopicDescription();

    abstract void setTopicDescription(String topicDescription);

    abstract List<SkillProxy> getSkills();

    abstract void setSkills(List<SkillProxy> skills);

    abstract ClassificationTopicProxy getClassificationTopic();

    abstract void setClassificationTopic(ClassificationTopicProxy classificationTopic);

    abstract Integer getVersion();
}
