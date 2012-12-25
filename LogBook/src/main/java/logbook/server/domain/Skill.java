package logbook.server.domain;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Size;

import org.mortbay.log.Log;
import org.apache.commons.io.FileUtils;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Skill {

    @Size(max = 1024)
    private String description;

    @Size(max = 255)
    private String shortcut;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private SkillLevel skillLevel;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private Set<SkillAcquired> skillsAcquired = new HashSet<SkillAcquired>();
    
    @ManyToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "skill")
    private Set<Keyword> keywords = new HashSet<Keyword>();
    
    public static List<Long> findCountOfSkillBySkillLevel() 
    {
    	List<Long> listOfSkillBySkillLevel=new ArrayList<Long>();
    	listOfSkillBySkillLevel.add(findTotalSkillByLevel(1l));
    	listOfSkillBySkillLevel.add(findTotalSkillByLevel(2l));
    	return listOfSkillBySkillLevel;
         
    }
    public static Long findTotalSkillByLevel(long skillLevel)
    {
    	EntityManager em = entityManager();
        TypedQuery<Long> q = em.createQuery("select count(s.skillLevel) from Skill as s where s.skillLevel= "+skillLevel, Long.class);
        Log.info("Query String: " + q);
        return q.getSingleResult();		
    }
  public static List<Skill> findSkillBySearchCriteria(int start, int max, Long mainClassificationId, Long classificationTopicId, Long topicId)
	{
		/*EntityManager em = entityManager();
		String sql = "SELECT s FROM Skill As s where";
		
		if(topicId != null) //Topic
			sql = sql + " s.topic.id = " + topicId +" AND  " ;
		
		if(classificationTopicId != null) //ClassificationTopic
			sql = sql + " s.topic.classificationTopic.id = " + classificationTopicId +" AND  " ;
		
		if(mainClassificationId != null) // main classification
			sql = sql + " s.topic.classificationTopic.mainClassification.id = " + mainClassificationId +" AND  " ;

		sql = sql.substring(0, sql.length()-5);
		//sql = sql + " order by s.topic,s.topic.classificationTopic,s.topic.classificationTopic.mainClassification";
		sql = sql + " order by s.topic";
		//System.out.println("QUERY : " + sql);
		
		System.out.println("Query :" + sql);
		
		TypedQuery<Skill> result = em.createQuery(sql, Skill.class);
		result.setFirstResult(start);
		result.setMaxResults(max);
		List<Skill> response = result.getResultList();
		return response; */
		
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		CriteriaQuery<Skill> select = criteriaQuery.select(from);
		select.orderBy(criteriaBuilder.asc(from.get("topic")));
		//select.orderBy(criteriaBuilder.asc(from.get("topic").get("classificationTopic")));
		//select.orderBy(criteriaBuilder.asc(from.get("topic").get("classificationTopic").get("mainClassification")));
		
		Predicate predicate1 = null;
		Predicate predicate2 = null;
		Predicate predicate3 = null;
		Predicate andPredicate = null;
		
		
		if(topicId != null) //Topic
		{
			predicate1 = criteriaBuilder.equal(from.get("topic").get("id"), topicId);
			if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate1);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate1);
		}		
		else if(classificationTopicId != null) //ClassificationTopic
		{
			predicate2 = criteriaBuilder.equal(from.get("topic").get("classificationTopic").get("id"), classificationTopicId);
			if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate2);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate2);
		}		
		else if(mainClassificationId != null) // main classification
		{
			predicate3 = criteriaBuilder.equal(from.get("topic").get("classificationTopic").get("mainClassification").get("id"), mainClassificationId);
			if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate3);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate3);
		}
		
		if (andPredicate != null)
			criteriaQuery.where(andPredicate);
		
		TypedQuery<Skill> result = entityManager().createQuery(criteriaQuery);
		
		result.setFirstResult(start);
		result.setMaxResults(max);
		
		System.out.println("~~QUERY : " + result.unwrap(org.hibernate.Query.class).getQueryString());		
		
		List<Skill> resultListSize  = result.getResultList();
			
		System.out.println("RESULTLISTSIZE : " + resultListSize.size());
		
		return resultListSize;
	}
    
    public static String retrieveHtmlFile() {
    	
    	try {
    	String fileSeparator = System.getProperty("file.separator");
		String File_To_Convert =RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath(fileSeparator) +  "public/assignment_sp_1.htm";
		
		
		return  FileUtils.readFileToString(new File(File_To_Convert));
    	}catch(Exception e){
    		
    		return "No data found";
    	}
    }
}
