package ch.unibas.medizin.logbook.server.domain;

import java.util.ArrayList;
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
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class MainClassification {

    private String description;

    @Size(max = 2)
    private String shortcut;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "mainClassification")
    private Set<ClassificationTopic> classificationTopics = new HashSet<ClassificationTopic>();*/
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainClassification")
    private List<ClassificationTopic> classificationTopics = new ArrayList<ClassificationTopic>();


	public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

	public String getShortcut() {
        return this.shortcut;
    }

	public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

	public List<ClassificationTopic> getClassificationTopics() {
        return this.classificationTopics;
    }

	public void setClassificationTopics(List<ClassificationTopic> classificationTopics) {
        this.classificationTopics = classificationTopics;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

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

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new MainClassification().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countMainClassifications() {
        return entityManager().createQuery("SELECT COUNT(o) FROM MainClassification o", Long.class).getSingleResult();
    }

	public static List<MainClassification> findAllMainClassifications() {
        return entityManager().createQuery("SELECT o FROM MainClassification o", MainClassification.class).getResultList();
    }

	public static MainClassification findMainClassification(Long id) {
        if (id == null) return null;
        return entityManager().find(MainClassification.class, id);
    }

	public static List<MainClassification> findMainClassificationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM MainClassification o", MainClassification.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            MainClassification attached = MainClassification.findMainClassification(this.id);
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
    public MainClassification merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        MainClassification merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
