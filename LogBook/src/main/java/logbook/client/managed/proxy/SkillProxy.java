// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.Skill", locator = "logbook.server.locator.SkillLocator")
@RooGwtProxy(value = "logbook.server.domain.Skill", readOnly = { "version", "id" }, scaffold = true)
public interface SkillProxy extends EntityProxy {

    abstract Long getId();

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract String getShortcut();

    abstract void setShortcut(String shortcut);

    abstract TopicProxy getTopic();

    abstract void setTopic(TopicProxy topic);

    abstract SkillLevelProxy getSkillLevel();

    abstract void setSkillLevel(SkillLevelProxy skillLevel);

    abstract Set<logbook.client.managed.proxy.SkillAcquiredProxy> getSkillsAcquired();

    abstract void setSkillsAcquired(Set<logbook.client.managed.proxy.SkillAcquiredProxy> skillsAcquired);

    abstract Set<logbook.client.managed.proxy.KeywordProxy> getKeywords();

    abstract void setKeywords(Set<logbook.client.managed.proxy.KeywordProxy> keywords);

    abstract Integer getVersion();
}
