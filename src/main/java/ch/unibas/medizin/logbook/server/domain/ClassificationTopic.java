package ch.unibas.medizin.logbook.server.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
public class ClassificationTopic {

    @Size(max = 255)
    private String description;

    @Size(max = 8)
    private String shortcut;

    @ManyToOne
    private MainClassification mainClassification;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classificationTopic")
    private List<Topic> topics = new ArrayList<Topic>();
    
    public static List<ClassificationTopic> findClassiTopicByMainClassfication(Long value)
	{
		/*EntityManager em = entityManager();
		
		String sql = "";
		
		if (value != null)
			sql = "SELECT c FROM ClassificationTopic c WHERE c.mainClassification.id = " + value;
		else
			sql = "SELECT c FROM ClassificationTopic c";
			
		TypedQuery<ClassificationTopic> q = em.createQuery(sql, ClassificationTopic.class);
		return q.getResultList();*/
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<ClassificationTopic> criteriaQuery = criteriaBuilder.createQuery(ClassificationTopic.class);
		Root<ClassificationTopic> from = criteriaQuery.from(ClassificationTopic.class);
		CriteriaQuery<ClassificationTopic> select = criteriaQuery.select(from);
		
		if (value != null)
			criteriaQuery.where(criteriaBuilder.equal(from.get("mainClassification"), value));
		
		TypedQuery<ClassificationTopic> q = entityManager().createQuery(criteriaQuery);
		return q.getResultList();
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public static TypedQuery<ClassificationTopic> findClassificationTopicsByMainClassification(MainClassification mainClassification) {
        if (mainClassification == null) throw new IllegalArgumentException("The mainClassification argument is required");
        EntityManager em = ClassificationTopic.entityManager();
        TypedQuery<ClassificationTopic> q = em.createQuery("SELECT o FROM ClassificationTopic AS o WHERE o.mainClassification = :mainClassification", ClassificationTopic.class);
        q.setParameter("mainClassification", mainClassification);
        return q;
    }

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

	public MainClassification getMainClassification() {
        return this.mainClassification;
    }

	public void setMainClassification(MainClassification mainClassification) {
        this.mainClassification = mainClassification;
    }

	public List<Topic> getTopics() {
        return this.topics;
    }

	public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ClassificationTopic().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countClassificationTopics() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ClassificationTopic o", Long.class).getSingleResult();
    }

	public static List<ClassificationTopic> findAllClassificationTopics() {
        return entityManager().createQuery("SELECT o FROM ClassificationTopic o", ClassificationTopic.class).getResultList();
    }

	public static ClassificationTopic findClassificationTopic(Long id) {
        if (id == null) return null;
        return entityManager().find(ClassificationTopic.class, id);
    }

	public static List<ClassificationTopic> findClassificationTopicEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ClassificationTopic o", ClassificationTopic.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ClassificationTopic attached = ClassificationTopic.findClassificationTopic(this.id);
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
    public ClassificationTopic merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ClassificationTopic merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
