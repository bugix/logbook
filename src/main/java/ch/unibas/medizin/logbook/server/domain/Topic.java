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
import ch.unibas.medizin.logbook.shared.TopicFilteredResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;
import com.allen_sauer.gwt.log.client.Log;

@Configurable
@Entity
public class Topic {

    @Size(max = 1024)
    private String topicDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    private List<Skill> skills = new ArrayList<Skill>();

    @ManyToOne
    private ClassificationTopic classificationTopic;
    
    public static List<Topic> findTopicByClassficationId(Long value)
	{
		/*EntityManager em = entityManager();
		String sql = "";
		
		if (value != null)
			sql = "SELECT t FROM Topic t WHERE t.classificationTopic.id = " + value;
		else
			sql = "SELECT t FROM Topic t";
		
		TypedQuery<Topic> q = em.createQuery(sql, Topic.class);
		return q.getResultList();*/
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Topic> criteriaQuery = criteriaBuilder.createQuery(Topic.class);
		Root<Topic> from = criteriaQuery.from(Topic.class);
		CriteriaQuery<Topic> select = criteriaQuery.select(from);
		
		if (value != null)
			criteriaQuery.where(criteriaBuilder.equal(from.get("classificationTopic"), value));
		
		TypedQuery<Topic> q = entityManager().createQuery(criteriaQuery);
		return q.getResultList();
		
	}
 public static TopicFilteredResult findTopicOrderByClassification(int start,int max,Student student)
    {    	
    	Log.info("findTopicOrderByClassification call");
    	 if(start!=0)
    		  start--;
    	TopicFilteredResult finalresult = new TopicFilteredResult();   	    	
    	List<Topic> resultList =new ArrayList<Topic>();
    	//resultList.clear();
    	
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Topic> criteriaQuery = criteriaBuilder.createQuery(Topic.class);
		Root<Topic> from = criteriaQuery.from(Topic.class);
		CriteriaQuery<Topic> select = criteriaQuery.select(from);				
		
		//select.orderBy(criteriaBuilder.asc(from.get("classificationTopic").get("mainClassification").get("id")), criteriaBuilder.asc(from.get("classificationTopic").get("id")));
		select.orderBy(criteriaBuilder.asc(from.get("id")), criteriaBuilder.asc(from.get("classificationTopic").get("mainClassification").get("id")), criteriaBuilder.asc(from.get("classificationTopic").get("id")));
		//from.join("classificationTopic");
		TypedQuery<Topic> result = entityManager().createQuery(criteriaQuery);
		//System.out.println("DB Second: " + result.getResultList().get(0).getId());
		int totalSize=result.getResultList().size();
		result.setFirstResult(start);
		result.setMaxResults(max);
						
		Log.info("Query String: " + result.unwrap(org.hibernate.Query.class).getQueryString());
		//Log.info("Result Size : Start: " +start + " Max: " + max );
		//Log.info("Total Size : " + totalSize);
		
		resultList  = result.getResultList();		
		List<Long> totalTopicBySkill=new ArrayList<Long>();
		List<Long> totalAcquiredTopicBySkill=new ArrayList<Long>();
		
		for (Topic topic : resultList) 
		{
			Long totalTopicCount=Skill.findTotalSkillByTopic(topic.getId());
			totalTopicBySkill.add(totalTopicCount);
			//Log.info("TotalTopicCount : " + totalTopicCount);
			Long totalAcquiredTopicCount=SkillAcquired.findTotalSkillAcquiredByTopicAndStudent(topic.getId(),student.getId());
			totalAcquiredTopicBySkill.add(totalAcquiredTopicCount);

		}
		
		//Log.info("Topic Result Size: " + resultList.size());
		//Log.info("Total Topic Size: " + totalTopicBySkill.size());
		//Log.info("Total Acquired Topic Size: " + totalAcquiredTopicBySkill.size());
		
		
		//Log.info("Topic Result: " + StringUtils.join(resultList,","));
		//Log.info("Total Topic: " + StringUtils.join(totalTopicBySkill,","));
		//Log.info("Total Acquired: " + StringUtils.join(totalAcquiredTopicBySkill,","));
		
		finalresult.setTotalTopic(totalSize);
		finalresult.setTopicList(resultList);
		//System.out.println("DB First: " + resultList.get(0).getId());
		finalresult.setTotalTopicList(totalTopicBySkill);
		finalresult.setTopicAcquiredList(totalAcquiredTopicBySkill);
		
		return finalresult;
    }

	public String getTopicDescription() {
        return this.topicDescription;
    }

	public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

	public List<Skill> getSkills() {
        return this.skills;
    }

	public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

	public ClassificationTopic getClassificationTopic() {
        return this.classificationTopic;
    }

	public void setClassificationTopic(ClassificationTopic classificationTopic) {
        this.classificationTopic = classificationTopic;
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
        EntityManager em = new Topic().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countTopics() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Topic o", Long.class).getSingleResult();
    }

	public static List<Topic> findAllTopics() {
        return entityManager().createQuery("SELECT o FROM Topic o", Topic.class).getResultList();
    }

	public static Topic findTopic(Long id) {
        if (id == null) return null;
        return entityManager().find(Topic.class, id);
    }

	public static List<Topic> findTopicEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Topic o", Topic.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Topic attached = Topic.findTopic(this.id);
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
    public Topic merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Topic merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
