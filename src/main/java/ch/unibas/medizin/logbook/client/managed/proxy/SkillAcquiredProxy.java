// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Date;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.SkillAcquired", locator = "logbook.server.locator.SkillAcquiredLocator")
@RooGwtProxy(value = "logbook.server.domain.SkillAcquired", readOnly = { "version", "id" })
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
