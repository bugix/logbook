// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.SkillComment", locator = "logbook.server.locator.SkillCommentLocator")
@RooGwtProxy(value = "logbook.server.domain.SkillComment", readOnly = { "version", "id" })
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
