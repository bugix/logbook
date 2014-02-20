// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.SkillLevel", locator = "logbook.server.locator.SkillLevelLocator")
@RooGwtProxy(value = "logbook.server.domain.SkillLevel", readOnly = { "version", "id" })
public interface SkillLevelProxy extends EntityProxy {

    abstract Long getId();

    abstract Integer getLevelNumber();

    abstract void setLevelNumber(Integer levelNumber);

    abstract Set<SkillProxy> getSkills();

    abstract void setSkills(Set<SkillProxy> skills);

    abstract Set<SkillAcquiredProxy> getSkillAcquired();

    abstract void setSkillAcquired(Set<SkillAcquiredProxy> skillAcquired);

    abstract Integer getVersion();
}
