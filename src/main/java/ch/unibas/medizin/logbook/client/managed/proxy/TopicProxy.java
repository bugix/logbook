// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.Topic", locator = "ch.unibas.medizin.logbook.server.locator.TopicLocator")
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
