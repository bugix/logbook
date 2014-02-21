package ch.unibas.medizin.logbook.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
public class SkillComment 
{
	@PersistenceContext
    transient EntityManager entityManager;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;
    
    private String comment;
    
    @ManyToOne
    private Student student;
    
    @OneToOne
    private Skill skill;

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

	public String getComment() {
        return this.comment;
    }

	public void setComment(String comment) {
        this.comment = comment;
    }

	public Student getStudent() {
        return this.student;
    }

	public void setStudent(Student student) {
        this.student = student;
    }

	public Skill getSkill() {
        return this.skill;
    }

	public void setSkill(Skill skill) {
        this.skill = skill;
    }

	public static final EntityManager entityManager() {
        EntityManager em = new SkillComment().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSkillComments() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SkillComment o", Long.class).getSingleResult();
    }

	public static List<SkillComment> findAllSkillComments() {
        return entityManager().createQuery("SELECT o FROM SkillComment o", SkillComment.class).getResultList();
    }

	public static SkillComment findSkillComment(Long id) {
        if (id == null) return null;
        return entityManager().find(SkillComment.class, id);
    }

	public static List<SkillComment> findSkillCommentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SkillComment o", SkillComment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SkillComment attached = SkillComment.findSkillComment(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public SkillComment merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SkillComment merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
	
	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
