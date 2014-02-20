// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import ch.unibas.medizin.logbook.shared.Gender;
import ch.unibas.medizin.logbook.shared.StudentStatus;
import ch.unibas.medizin.logbook.shared.StudyYears;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.Student", locator = "logbook.server.locator.StudentLocator")
@RooGwtProxy(value = "logbook.server.domain.Student", readOnly = { "version", "id" })
public interface StudentProxy extends EntityProxy {

    abstract Long getId();

    abstract String getStudentId();

    abstract void setStudentId(String studentId);

    abstract String getShib_id();

    abstract void setShib_id(String shib_id);

    abstract String getEmail();

    abstract void setEmail(String email);

    abstract Gender getGender();

    abstract void setGender(Gender gender);

    abstract String getName();

    abstract void setName(String name);

    abstract String getPreName();

    abstract void setPreName(String preName);

    abstract StudentStatus getStudentStatus();

    abstract void setStudentStatus(StudentStatus studentStatus);

    abstract StudyYears getStudyYear();

    abstract void setStudyYear(StudyYears studyYear);

    abstract Set<SkillAcquiredProxy> getSkillAcquired();

    abstract void setSkillAcquired(Set<SkillAcquiredProxy> skillAcquired);

    abstract Set<SkillCommentProxy> getSkillComments();

    abstract void setSkillComments(Set<SkillCommentProxy> skillComments);

    abstract Integer getVersion();
}
