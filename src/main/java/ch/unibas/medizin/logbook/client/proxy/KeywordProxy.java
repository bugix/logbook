// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.proxy;

import java.util.Set;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.Keyword", locator = "ch.unibas.medizin.logbook.server.locator.KeywordLocator")
public interface KeywordProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract Set<SkillProxy> getSkill();

    abstract void setSkill(Set<SkillProxy> skill);

    abstract Integer getVersion();
}
