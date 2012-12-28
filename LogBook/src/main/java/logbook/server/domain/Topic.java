package logbook.server.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Size;

import logbook.shared.TopicFilteredResult;

import org.apache.commons.lang3.StringUtils;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.allen_sauer.gwt.log.client.Log;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Topic {

    @Size(max = 1024)
    private String topicDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    private List<Skill> skills = new ArrayList<Skill>();

    @ManyToOne
    private ClassificationTopic classificationTopic;
    
    public static List<Topic> findTopicByClassficationId(Long value)
	{
		EntityManager em = entityManager();
		String sql = "";
		
		if (value != null)
			sql = "SELECT t FROM Topic t WHERE t.classificationTopic.id = " + value;
		else
			sql = "SELECT t FROM Topic t";
		
		TypedQuery<Topic> q = em.createQuery(sql, Topic.class);
		return q.getResultList();
	}
 public static TopicFilteredResult findTopicOrderByClassification(int start,int max,Student student)
    {    	
    	Log.info("findTopicOrderByClassification call");
    	
    	TopicFilteredResult finalresult = new TopicFilteredResult();
    	
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Topic> criteriaQuery = criteriaBuilder.createQuery(Topic.class);
		Root<Topic> from = criteriaQuery.from(Topic.class);
		CriteriaQuery<Topic> select = criteriaQuery.select(from);				
		
		select.orderBy(criteriaBuilder.asc(from.get("classificationTopic").get("mainClassification")), criteriaBuilder.asc(from.get("classificationTopic")));
		from.join("classificationTopic");
		TypedQuery<Topic> result = entityManager().createQuery(criteriaQuery);
		
		int totalSize=result.getResultList().size();
		result.setFirstResult(start);
		result.setMaxResults(max);
						
		Log.info("Query String: " + result.unwrap(org.hibernate.Query.class).getQueryString());
		Log.info("Result Size : Start: " +start + " Max: " + max );
		
		
		List<Topic> resultList  = result.getResultList();		
		List<Long> totalTopicBySkill=new ArrayList<Long>();
		List<Long> totalAcquiredTopicBySkill=new ArrayList<Long>();
		
		for (Topic topic : resultList) {
			Long totalTopicCount=Skill.findTotalSkillByTopic(topic.getId());
			totalTopicBySkill.add(totalTopicCount);	
			Long totalAcquiredTopicCount=SkillAcquired.findTotalSkillAcquiredByTopicAndStudent(topic.getId(),student.getId());
			totalAcquiredTopicBySkill.add(totalAcquiredTopicCount);

		}
		
		Log.info("Topic Result Size: " + resultList.size());
		Log.info("Total Topic Size: " + totalTopicBySkill.size());
		Log.info("Total Acquired Topic Size: " + totalAcquiredTopicBySkill.size());
		
		
		//Log.info("Topic Result: " + StringUtils.join(resultList,","));
		Log.info("Total Topic: " + StringUtils.join(totalTopicBySkill,","));
		Log.info("Total Acquired: " + StringUtils.join(totalAcquiredTopicBySkill,","));
		
		finalresult.setTotalTopic(totalSize);
		finalresult.setTopicList(resultList);
		finalresult.setTotalTopicList(totalTopicBySkill);
		finalresult.setTopicAcquiredList(totalAcquiredTopicBySkill);
		
		return finalresult;
    }
}
