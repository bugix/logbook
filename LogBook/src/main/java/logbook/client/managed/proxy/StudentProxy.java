// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import logbook.shared.Gender;
import logbook.shared.StudentStatus;
import logbook.shared.StudyYears;
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

    abstract Set<logbook.client.managed.proxy.SkillAcquiredProxy> getSkillAcquired();

    abstract void setSkillAcquired(Set<logbook.client.managed.proxy.SkillAcquiredProxy> skillAcquired);

    abstract Set<logbook.client.managed.proxy.SkillCommentProxy> getSkillComments();

    abstract void setSkillComments(Set<logbook.client.managed.proxy.SkillCommentProxy> skillComments);

    abstract Integer getVersion();
}
