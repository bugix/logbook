package ch.unibas.medizin.logbook.client.proxy;

import java.util.Date;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.SkillAcquired", locator = "ch.unibas.medizin.logbook.server.locator.SkillAcquiredLocator")
public interface SkillAcquiredProxy extends EntityProxy {

	abstract Long getId();

	abstract Date getCreated();

	abstract void setCreated(Date created);

	abstract SkillProxy getSkill();

	abstract void setSkill(SkillProxy skill);

	abstract StudentProxy getStudent();

	abstract void setStudent(StudentProxy student);

	abstract SkillLevelProxy getSkillLevel();

	abstract void setSkillLevel(SkillLevelProxy skillLevel);

	abstract Integer getVersion();
}
