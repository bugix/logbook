package ch.unibas.medizin.logbook.server.domain;

import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.ADMIN;
import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.CURRENT_USER;
import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.STUDENT;
import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.UNIQUE_ID;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import ch.unibas.medizin.logbook.shared.enums.Gender;
import ch.unibas.medizin.logbook.shared.enums.StudentStatus;
import ch.unibas.medizin.logbook.shared.enums.StudyYears;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

@Entity
@Configurable
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@Size(max = 255)
	private String studentId;

	@Size(max = 255)
	private String shib_id;

	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")
	@Size(max = 255)
	private String email;

	@Enumerated
	private Gender gender;

	@NotNull
	@Size(max = 255)
	private String name;

	@NotNull
	@Size(max = 255)
	private String preName;

	@Enumerated
	private StudentStatus studentStatus;

	@Enumerated
	private StudyYears studyYear;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private Set<SkillAcquired> skillAcquired = new HashSet<SkillAcquired>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private Set<SkillComment> skillComments = new HashSet<SkillComment>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getShib_id() {
		return this.shib_id;
	}

	public void setShib_id(String shib_id) {
		this.shib_id = shib_id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreName() {
		return this.preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public StudentStatus getStudentStatus() {
		return this.studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}

	public StudyYears getStudyYear() {
		return this.studyYear;
	}

	public void setStudyYear(StudyYears studyYear) {
		this.studyYear = studyYear;
	}

	public Set<SkillAcquired> getSkillAcquired() {
		return this.skillAcquired;
	}

	public void setSkillAcquired(Set<SkillAcquired> skillAcquired) {
		this.skillAcquired = skillAcquired;
	}

	public Set<SkillComment> getSkillComments() {
		return this.skillComments;
	}

	public void setSkillComments(Set<SkillComment> skillComments) {
		this.skillComments = skillComments;
	}

	public static Student findStudentFromSession() {
		HttpSession session = RequestFactoryServlet.getThreadLocalRequest().getSession();
		String shibId = (String) session.getAttribute(UNIQUE_ID);
		Log.debug("shib id: " + shibId);
		Student student = Student.findStudentUsingShibId(shibId);
		return student;
	}

	public static Student findStudentUsingShibId(String shibId) {

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> from = criteriaQuery.from(Student.class);

		Predicate shibIdPredicate = criteriaBuilder.equal(from.get("shib_id"), shibId);
		criteriaQuery.where(shibIdPredicate);

		TypedQuery<Student> q = entityManager().createQuery(criteriaQuery);

		List<Student> students = q.getResultList();
		if (students.size() > 0) {
			return students.get(0);
		} else {
			return null;
		}
	}

	public static Boolean isCurrentUserStudent() {
		HttpSession session = RequestFactoryServlet.getThreadLocalRequest().getSession();
		if (STUDENT.equals(session.getAttribute(CURRENT_USER))) {
			return true;
		} else if (ADMIN.equals(session.getAttribute(CURRENT_USER))) {
			return false;
		} else {
			return null;
		}
	}

	@PersistenceContext
	transient EntityManager entityManager;

	public static final EntityManager entityManager() {
		EntityManager em = new Student().entityManager;
		if (em == null)
			throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		return em;
	}

	public static long countStudents() {
		return entityManager().createQuery("SELECT COUNT(o) FROM Student o", Long.class).getSingleResult();
	}

	public static List<Student> findAllStudents() {
		return entityManager().createQuery("SELECT o FROM Student o", Student.class).getResultList();
	}

	public static Student findStudent(Long id) {
		if (id == null)
			return null;
		return entityManager().find(Student.class, id);
	}

	public static List<Student> findStudentEntries(int firstResult, int maxResults) {
		return entityManager().createQuery("SELECT o FROM Student o", Student.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Transactional
	public void persist() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		this.entityManager.persist(this);
	}

	@Transactional
	public void remove() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		if (this.entityManager.contains(this)) {
			this.entityManager.remove(this);
		} else {
			Student attached = Student.findStudent(this.id);
			this.entityManager.remove(attached);
		}
	}

	@Transactional
	public void flush() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		this.entityManager.flush();
	}

	@Transactional
	public void clear() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		this.entityManager.clear();
	}

	@Transactional
	public Student merge() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		Student merged = this.entityManager.merge(this);
		this.entityManager.flush();
		return merged;
	}

	public static TypedQuery<Student> findStudentsByEmailEquals(String email) {
		if (email == null || email.length() == 0)
			throw new IllegalArgumentException("The email argument is required");
		EntityManager em = Student.entityManager();
		TypedQuery<Student> q = em.createQuery("SELECT o FROM Student AS o WHERE o.email = :email", Student.class);
		q.setParameter("email", email);
		return q;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
