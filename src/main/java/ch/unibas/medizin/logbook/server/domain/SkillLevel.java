package ch.unibas.medizin.logbook.server.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
public class SkillLevel {

	@PersistenceContext
	transient EntityManager entityManager;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	private Integer levelNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "skillLevel")
	private Set<Skill> skills = new HashSet<Skill>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "skillLevel")
	private Set<SkillAcquired> skillAcquired = new HashSet<SkillAcquired>();

	public Integer getLevelNumber() {
		return this.levelNumber;
	}

	public void setLevelNumber(Integer levelNumber) {
		this.levelNumber = levelNumber;
	}

	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<SkillAcquired> getSkillAcquired() {
		return this.skillAcquired;
	}

	public void setSkillAcquired(Set<SkillAcquired> skillAcquired) {
		this.skillAcquired = skillAcquired;
	}

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

	public static SkillLevel findSkillByLevelNumber(Integer levelNumber) {
		EntityManager em = entityManager();
		String query = "SELECT sl from SkillLevel as sl where sl.levelNumber=" + levelNumber;
		TypedQuery<SkillLevel> result = em.createQuery(query, SkillLevel.class);

		return result.getSingleResult();
	}

	public static final EntityManager entityManager() {
		EntityManager em = new SkillLevel().entityManager;
		if (em == null)
			throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		return em;
	}

	public static long countSkillLevels() {
		return entityManager().createQuery("SELECT COUNT(o) FROM SkillLevel o", Long.class).getSingleResult();
	}

	public static List<SkillLevel> findAllSkillLevels() {
		return entityManager().createQuery("SELECT o FROM SkillLevel o", SkillLevel.class).getResultList();
	}

	public static SkillLevel findSkillLevel(Long id) {
		if (id == null)
			return null;
		return entityManager().find(SkillLevel.class, id);
	}

	public static List<SkillLevel> findSkillLevelEntries(int firstResult, int maxResults) {
		return entityManager().createQuery("SELECT o FROM SkillLevel o", SkillLevel.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
			SkillLevel attached = SkillLevel.findSkillLevel(this.id);
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
	public SkillLevel merge() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		SkillLevel merged = this.entityManager.merge(this);
		this.entityManager.flush();
		return merged;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
