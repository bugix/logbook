// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.SkillComment", locator = "ch.unibas.medizin.logbook.server.locator.SkillCommentLocator")
public interface SkillCommentProxy extends EntityProxy {

    abstract Long getId();

    abstract String getComment();

    abstract void setComment(String comment);

    abstract StudentProxy getStudent();

    abstract void setStudent(StudentProxy student);

    abstract SkillProxy getSkill();

    abstract void setSkill(SkillProxy skill);

    abstract Integer getVersion();
}
