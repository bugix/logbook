package ch.unibas.medizin.logbook.client.proxy;

import java.util.Set;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.SkillLevel", locator = "ch.unibas.medizin.logbook.server.locator.SkillLevelLocator")
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
