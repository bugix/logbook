// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.proxy;

import java.util.Set;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.Skill", locator = "ch.unibas.medizin.logbook.server.locator.SkillLocator")
public interface SkillProxy extends EntityProxy {

    abstract Long getId();

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Integer getShortcut();

    abstract void setShortcut(Integer shortcut);

    abstract TopicProxy getTopic();

    abstract void setTopic(TopicProxy topic);

    abstract SkillLevelProxy getSkillLevel();

    abstract void setSkillLevel(SkillLevelProxy skillLevel);

    abstract String getGerman_text();

    abstract void setGerman_text(String german_text);

    abstract Set<SkillAcquiredProxy> getSkillsAcquired();

    abstract void setSkillsAcquired(Set<SkillAcquiredProxy> skillsAcquired);

    abstract Set<KeywordProxy> getKeywords();

    abstract void setKeywords(Set<KeywordProxy> keywords);

    abstract Integer getVersion();
}
