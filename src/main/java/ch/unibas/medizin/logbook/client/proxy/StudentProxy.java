package ch.unibas.medizin.logbook.client.proxy;

import java.util.Set;

import ch.unibas.medizin.logbook.shared.enums.Gender;
import ch.unibas.medizin.logbook.shared.enums.StudentStatus;
import ch.unibas.medizin.logbook.shared.enums.StudyYears;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;

@ProxyForName(value = "ch.unibas.medizin.logbook.server.domain.Student", locator = "ch.unibas.medizin.logbook.server.locator.StudentLocator")
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
