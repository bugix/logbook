package logbook.server.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.validation.constraints.Size;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import logbook.shared.SkillFilteredResult;
import logbook.shared.SkillLevels;

import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.allen_sauer.gwt.log.client.Log;
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
    
    @Size(max = 255)
    private String german_text;
    
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
    	/*EntityManager em = entityManager();
    	String query="select count(s) from Skill as s where s.skillLevel.levelNumber= "+skillLevel;
        TypedQuery<Long> q = em.createQuery("select count(s) from Skill as s where s.skillLevel.levelNumber= "+skillLevel, Long.class);
        System.out.println("Total Skill Count Query String: " + query);
        return q.getSingleResult();		*/
    	
    	CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
					
		criteriaQuery.select(criteriaBuilder.count(from));
		
		Predicate skillLevelPredicate = criteriaBuilder.equal(from.get("skillLevel").get("levelNumber"),skillLevel);
		criteriaQuery.where(skillLevelPredicate);
		
		TypedQuery<Long> q = entityManager().createQuery(criteriaQuery);
		//System.out.println("Total Skill Count Query : " + q.unwrap(Query.class).getQueryString());
        return q.getSingleResult();		
		
    }
  public static SkillFilteredResult findSkillBySearchCriteria(int start, int max,Long studentId,Long mainClassificationId, Long classificationTopicId, Long topicId,String fulltextSearch,int chkAsc)
	{
	  
	  	//select s from Skill s,Topic t,ClassificationTopic c,MainClassification m  where s.topic=t.id and t.classificationTopic=c.id and c.mainClassification=m.id order by m.description,c.description,t.topicDescription,s.description
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
		
	  Log.info("Asc :" + chkAsc);
	  Log.info("Start :" + start);
	  Log.info("Max :" + max);
	  
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		CriteriaQuery<Skill> select = criteriaQuery.select(from);
		
		Join<Skill, Topic> join1 = from.join("topic");
		SetJoin<Skill, Keyword> join4=from.joinSet("keywords",JoinType.LEFT);
		Join<Topic, ClassificationTopic> join2 = join1.join("classificationTopic");
		Join<ClassificationTopic, MainClassification> join3 = join2.join("mainClassification");
		
		
		//ListJoin<Skill, Topic> test = from.join("");
		
		//select.groupBy(from.get("topic").get("id"));
//		select.orderBy(criteriaBuilder.asc(join3.get("description")), criteriaBuilder.asc(join2.get("description")), criteriaBuilder.asc(join1.get("topicDescription")),criteriaBuilder.asc(from.get("description")));
		
		/*if (chkAsc == 0)
			select.orderBy(criteriaBuilder.asc(join3.get("description")), criteriaBuilder.asc(join2.get("description")), criteriaBuilder.asc(join1.get("topicDescription")), criteriaBuilder.asc(from.get("description")), criteriaBuilder.asc(from.get("shortcut")));
		else if (chkAsc == 1)
			select.orderBy(criteriaBuilder.desc(from.get("shortcut")), criteriaBuilder.asc(join3.get("description")), criteriaBuilder.asc(join2.get("description")), criteriaBuilder.asc(join1.get("topicDescription")), criteriaBuilder.asc(from.get("description")));*/
		
		if (chkAsc == 0)
			select.orderBy(criteriaBuilder.asc(join3.get("shortcut")), criteriaBuilder.asc(join2.get("shortcut")), criteriaBuilder.asc(join1.get("topicDescription"))/*, criteriaBuilder.asc(from.get("description"))*/, criteriaBuilder.asc(from.get("shortcut")));
		else if (chkAsc == 1)
			//select.orderBy(criteriaBuilder.desc(join3.get("shortcut")), criteriaBuilder.desc(join2.get("shortcut")), criteriaBuilder.desc(join1.get("topicDescription"))/*, criteriaBuilder.desc(from.get("description"))*/, criteriaBuilder.desc(join1.get("topicDescription")), criteriaBuilder.desc(from.get("shortcut")));
			select.orderBy(criteriaBuilder.desc(join3.get("shortcut")), criteriaBuilder.desc(join2.get("shortcut")), criteriaBuilder.desc(join1.get("topicDescription"))/*, criteriaBuilder.asc(from.get("description"))*/, criteriaBuilder.desc(from.get("shortcut")));
		
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		Predicate predicate1 = null;
		Predicate predicate2 = null;
		Predicate predicate3 = null;
		Predicate andPredicate = null;
		
		
		if(topicId != null) //Topic
		{
			predicate1 = criteriaBuilder.equal(from.get("topic").get("id"), topicId);
			predicateList.add(predicate1);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate1);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate1);*/
		}		
		
		if(classificationTopicId != null) //ClassificationTopic
		{
			//predicate2 = criteriaBuilder.equal(from.get("topic").get("classificationTopic").get("id"), classificationTopicId);
			predicate2 = criteriaBuilder.equal(join2.get("id"), classificationTopicId);
			predicateList.add(predicate2);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate2);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate2);*/
		}		
		
		if(mainClassificationId != null) // main classification
		{
			//predicate3 = criteriaBuilder.equal(from.get("topic").get("classificationTopic").get("mainClassification").get("id"), mainClassificationId);
			predicate3 = criteriaBuilder.equal(join3.get("id"), mainClassificationId);
			predicateList.add(predicate3);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate3);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate3);*/
		}
		
		if (fulltextSearch != "" && (!fulltextSearch.equals("")) && fulltextSearch != null)
		{
			
			fulltextSearch=fulltextSearch.trim();
			Expression<String> skillDescExp = from.get("description");
			Expression<String> germanTestExp = from.get("german_text");
			
			
			Expression<String> keywordDesc =  join4.get("name");
			
			//Join<Skill, X> keyordJoin=from.join("keywords",JoinType.INNER);
		//	Expression<Keyword> keywordsExp = from.get(Keyword.class);
			
			/*String sql = "SELECT s FROM Keyword k join k.skill s WHERE k.name LIKE '%" + fulltextSearch + "%'";
			TypedQuery<Skill> q = entityManager().createQuery(sql, Skill.class);
			List<Skill> skillList = q.getResultList();
			
			System.out.println("SKILL QUERY : " + sql);
			System.out.println("SKILL LIST SIZE : " + skillList.size());*/
			
			Predicate pre1 = criteriaBuilder.like(skillDescExp, "%" + fulltextSearch + "%");
			Predicate pre2 = criteriaBuilder.like(germanTestExp, "%" + fulltextSearch + "%");
			Predicate pre3 = criteriaBuilder.like(keywordDesc, "%" + fulltextSearch + "%");
			
			
			Predicate orPre = criteriaBuilder.or(pre1, pre2,pre3/*, criteriaBuilder.in(from).value(getSkillIdList(skillList))*/);
			
			predicateList.add(orPre);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(orPre);
			else
				andPredicate = criteriaBuilder.and(andPredicate, orPre);*/
		}
		
		
		if (predicateList.size() > 0)
			criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
		
		TypedQuery<Skill> result = entityManager().createQuery(criteriaQuery);
		
		System.out.println("Critera query is :" + result.unwrap(Query.class).getQueryString());
		
		List<Skill> skillresultList  = new ArrayList<Skill>();
		
		int totalSize = 0;
		
/*		if (fulltextSearch != "" && (!fulltextSearch.equals("")) && fulltextSearch != null)
		{
			String sql = "SELECT s FROM Keyword k join k.skill s WHERE k.name LIKE '%" + fulltextSearch + "%'";
			TypedQuery<Skill> q = entityManager().createQuery(sql, Skill.class);
			List<Skill> skillKeywordList = q.getResultList();
			
			List<Skill> skillList = result.getResultList();
			
			Iterator<Skill> itr = skillKeywordList.iterator();
			while (itr.hasNext())
			{
				Skill skill = itr.next();
				
				if(!skillList.contains(skill))
					skillList.add(skill);
			}
			
			totalSize=skillList.size();
			
			if (totalSize > max)
			{
				 max = max + start;
				 
				 if (max > totalSize) max -= 1;
				 
				skillresultList = skillList.subList(start, max);
			}
			else
				skillresultList = skillList;
			
		}
		else*/
		{
			totalSize=result.getResultList().size();
			
			result.setFirstResult(start);
			
			result.setMaxResults(max);
			
			skillresultList  = result.getResultList();
			
			Log.info("RESULTLISTSIZE : " + skillresultList.size());
		}
		
		//System.out.println("~~QUERY : " + result.unwrap(org.hibernate.Query.class).getQueryString());		
		
		/*if (chkAsc==0){
			
			//System.out.println("In side Asc ");
			Collections.sort(skillresultList,new Comparator<Skill>() {

				@Override
				public int compare(Skill o1, Skill o2) {
					return o1.getDescription().compareTo(o2.getDescription());
				}
				
				
			});
		}*/
/*		if (chkAsc == 1){
			
			//System.out.println("In side Desc ");
			Collections.sort(skillresultList,new Comparator<Skill>() {

				@Override
				public int compare(Skill o1, Skill o2) {
					
					if (o2.getTopic().getClassificationTopic().getMainClassification().getDescription().compareTo(o1.getTopic().getClassificationTopic().getMainClassification().getDescription()) != 0)
						return o2.getTopic().getClassificationTopic().getMainClassification().getDescription().compareTo(o1.getTopic().getClassificationTopic().getMainClassification().getDescription());
					
					if (o2.getTopic().getClassificationTopic().getDescription().compareTo(o1.getTopic().getClassificationTopic().getDescription()) != 0)
						return o2.getTopic().getClassificationTopic().getDescription().compareTo(o1.getTopic().getClassificationTopic().getDescription());		
					
					if (o2.getTopic().getTopicDescription().compareTo(o1.getTopic().getTopicDescription()) != 0)
						return o2.getTopic().getTopicDescription().compareTo(o1.getTopic().getTopicDescription());
					
					if (o2.getDescription().compareTo(o1.getDescription()) != 0)
						return o2.getDescription().compareTo(o1.getDescription());
					
					return o2.getShortcut().compareTo(o1.getShortcut());
				}
				
				
			});
		}*/
		
		List<SkillLevels> skillAcquiredList =findSkillAcquiredByStudents(skillresultList,studentId);
		//System.out.println("Skill Acquired size :" + skillAcquiredList.size());
		
		SkillFilteredResult finalresult = new SkillFilteredResult();
		
		/*for (Skill skill : skillresultList)
		{
			System.out.println("ID : " + skill.getId());
		}*/

		finalresult.setTotalSkill(totalSize);
		finalresult.setSkillList(skillresultList);
		finalresult.setSkilltLevelsAcquiredList(skillAcquiredList);
		
	
		
		/* calulate progress(5/20) for main/class topic/topic */
		
		/*List<Topic> topics=new ArrayList<Topic>();
		List<ClassificationTopic> ctopics=new ArrayList<ClassificationTopic>();
		List<MainClassification> mainClassifications=new ArrayList<MainClassification>();
		
		for(int i=0;i<skillresultList.size();i++)
		{
			Skill skill=skillresultList.get(i);
			Topic topic=skill.getTopic();
			ClassificationTopic ctopic=topic.getClassificationTopic();
			MainClassification mainClassification=ctopic.getMainClassification();
			
			
			if(i==0)
			{
				
				topics.add(topic);
				ctopics.add(ctopic);
				mainClassifications.add(mainClassification);
					
				
				
			}
			else
			{
				if( ( topic.getId() != skillresultList.get(i-1).getTopic().getId()))
				{
					topics.add(topic);
				}
				else if( ( ctopic.getId() != skillresultList.get(i-1).getTopic().getClassificationTopic().getId()))
					{
						ctopics.add(ctopic);
					}
				else if( ( mainClassification.getId() != skillresultList.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
				{
					mainClassifications.add(mainClassification);
				}
				}
			}
		
		List<String> mainClassificationProgress=new ArrayList<String>();
		List<String> mainClassificationkey=new ArrayList<String>();
		for(int i=0;i<mainClassifications.size();i++)
		{
			mainClassificationProgress.add(findProgressOfMainClassification( mainClassifications.get(i), studentId));
			mainClassificationkey.add("m"+mainClassifications.get(i));
		}
			 
		finalresult.setMainClassificationkey(mainClassificationkey);
		finalresult.setMainClassificationProgress(mainClassificationProgress);*/
		
		return finalresult;
	}  
    
  
  public static SkillFilteredResult findMainClassificatonBySearchCriteria(Long studentId,Long mainClassificationId, Long classificationTopicId, Long topicId,String fulltextSearch,int chkAsc)
	{
	  
	  
	  Log.info("Asc :" + chkAsc);
	
	  
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		CriteriaQuery<Skill> select = criteriaQuery.select(from);
		
		Join<Skill, Topic> join1 = from.join("topic");
		SetJoin<Skill, Keyword> join4=from.joinSet("keywords",JoinType.LEFT);
		Join<Topic, ClassificationTopic> join2 = join1.join("classificationTopic");
		Join<ClassificationTopic, MainClassification> join3 = join2.join("mainClassification");
		
		
		//ListJoin<Skill, Topic> test = from.join("");
		
		//select.groupBy(from.get("topic").get("id"));
//		select.orderBy(criteriaBuilder.asc(join3.get("description")), criteriaBuilder.asc(join2.get("description")), criteriaBuilder.asc(join1.get("topicDescription")),criteriaBuilder.asc(from.get("description")));
		
		/*if (chkAsc == 0)
			select.orderBy(criteriaBuilder.asc(join3.get("description")), criteriaBuilder.asc(join2.get("description")), criteriaBuilder.asc(join1.get("topicDescription")), criteriaBuilder.asc(from.get("description")), criteriaBuilder.asc(from.get("shortcut")));
		else if (chkAsc == 1)
			select.orderBy(criteriaBuilder.desc(from.get("shortcut")), criteriaBuilder.asc(join3.get("description")), criteriaBuilder.asc(join2.get("description")), criteriaBuilder.asc(join1.get("topicDescription")), criteriaBuilder.asc(from.get("description")));*/
		
		if (chkAsc == 0)
			select.orderBy(criteriaBuilder.asc(join3.get("shortcut")), criteriaBuilder.asc(join2.get("shortcut")), criteriaBuilder.asc(join1.get("topicDescription"))/*, criteriaBuilder.asc(from.get("description"))*/, criteriaBuilder.asc(from.get("shortcut")));
		else if (chkAsc == 1)
			//select.orderBy(criteriaBuilder.desc(join3.get("shortcut")), criteriaBuilder.desc(join2.get("shortcut")), criteriaBuilder.desc(join1.get("topicDescription"))/*, criteriaBuilder.desc(from.get("description"))*/, criteriaBuilder.desc(join1.get("topicDescription")), criteriaBuilder.desc(from.get("shortcut")));
			select.orderBy(criteriaBuilder.desc(join3.get("shortcut")), criteriaBuilder.desc(join2.get("shortcut")), criteriaBuilder.desc(join1.get("topicDescription"))/*, criteriaBuilder.asc(from.get("description"))*/, criteriaBuilder.desc(from.get("shortcut")));
		
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		Predicate predicate1 = null;
		Predicate predicate2 = null;
		Predicate predicate3 = null;
		Predicate andPredicate = null;
		
		
		if(topicId != null) //Topic
		{
			predicate1 = criteriaBuilder.equal(from.get("topic").get("id"), topicId);
			predicateList.add(predicate1);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate1);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate1);*/
		}		
		
		if(classificationTopicId != null) //ClassificationTopic
		{
			//predicate2 = criteriaBuilder.equal(from.get("topic").get("classificationTopic").get("id"), classificationTopicId);
			predicate2 = criteriaBuilder.equal(join2.get("id"), classificationTopicId);
			predicateList.add(predicate2);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate2);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate2);*/
		}		
		
		if(mainClassificationId != null) // main classification
		{
			//predicate3 = criteriaBuilder.equal(from.get("topic").get("classificationTopic").get("mainClassification").get("id"), mainClassificationId);
			predicate3 = criteriaBuilder.equal(join3.get("id"), mainClassificationId);
			predicateList.add(predicate3);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(predicate3);
			else
				andPredicate = criteriaBuilder.and(andPredicate, predicate3);*/
		}
		
		if (fulltextSearch != "" && (!fulltextSearch.equals("")) && fulltextSearch != null)
		{
			
			fulltextSearch=fulltextSearch.trim();
			Expression<String> skillDescExp = from.get("description");
			Expression<String> germanTestExp = from.get("german_text");
			
			
			Expression<String> keywordDesc =  join4.get("name");
			
			//Join<Skill, X> keyordJoin=from.join("keywords",JoinType.INNER);
		//	Expression<Keyword> keywordsExp = from.get(Keyword.class);
			
			/*String sql = "SELECT s FROM Keyword k join k.skill s WHERE k.name LIKE '%" + fulltextSearch + "%'";
			TypedQuery<Skill> q = entityManager().createQuery(sql, Skill.class);
			List<Skill> skillList = q.getResultList();
			
			System.out.println("SKILL QUERY : " + sql);
			System.out.println("SKILL LIST SIZE : " + skillList.size());*/
			
			Predicate pre1 = criteriaBuilder.like(skillDescExp, "%" + fulltextSearch + "%");
			Predicate pre2 = criteriaBuilder.like(germanTestExp, "%" + fulltextSearch + "%");
			Predicate pre3 = criteriaBuilder.like(keywordDesc, "%" + fulltextSearch + "%");
			
			
			Predicate orPre = criteriaBuilder.or(pre1, pre2,pre3/*, criteriaBuilder.in(from).value(getSkillIdList(skillList))*/);
			
			predicateList.add(orPre);
			/*if (andPredicate == null)
				andPredicate = criteriaBuilder.and(orPre);
			else
				andPredicate = criteriaBuilder.and(andPredicate, orPre);*/
		}
		
		
		if (predicateList.size() > 0)
			criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
		
		TypedQuery<Skill> result = entityManager().createQuery(criteriaQuery);
		
		System.out.println("Critera query is :" + result.unwrap(Query.class).getQueryString());
		
		List<Skill> skillresultList  = new ArrayList<Skill>();
		
		int totalSize = 0;
		
		totalSize=result.getResultList().size();
		
		
		
		skillresultList  = result.getResultList();
		
		Log.info("RESULTLISTSIZE : " + skillresultList.size());
		
/*		if (fulltextSearch != "" && (!fulltextSearch.equals("")) && fulltextSearch != null)
		{
			String sql = "SELECT s FROM Keyword k join k.skill s WHERE k.name LIKE '%" + fulltextSearch + "%'";
			TypedQuery<Skill> q = entityManager().createQuery(sql, Skill.class);
			List<Skill> skillKeywordList = q.getResultList();
			
			List<Skill> skillList = result.getResultList();
			
			Iterator<Skill> itr = skillKeywordList.iterator();
			while (itr.hasNext())
			{
				Skill skill = itr.next();
				
				if(!skillList.contains(skill))
					skillList.add(skill);
			}
			
			totalSize=skillList.size();
			
			if (totalSize > max)
			{
				 max = max + start;
				 
				 if (max > totalSize) max -= 1;
				 
				skillresultList = skillList.subList(start, max);
			}
			else
				skillresultList = skillList;
			
		}
		
			totalSize=result.getResultList().size();
			
		
			
			skillresultList  = result.getResultList();
			
			Log.info("RESULTLISTSIZE : " + skillresultList.size());
	
		
		//System.out.println("~~QUERY : " + result.unwrap(org.hibernate.Query.class).getQueryString());		
		
		/*if (chkAsc==0){
			
			//System.out.println("In side Asc ");
			Collections.sort(skillresultList,new Comparator<Skill>() {

				@Override
				public int compare(Skill o1, Skill o2) {
					return o1.getDescription().compareTo(o2.getDescription());
				}
				
				
			});
		}*/
/*		if (chkAsc == 1){
			
			//System.out.println("In side Desc ");
			Collections.sort(skillresultList,new Comparator<Skill>() {

				@Override
				public int compare(Skill o1, Skill o2) {
					
					if (o2.getTopic().getClassificationTopic().getMainClassification().getDescription().compareTo(o1.getTopic().getClassificationTopic().getMainClassification().getDescription()) != 0)
						return o2.getTopic().getClassificationTopic().getMainClassification().getDescription().compareTo(o1.getTopic().getClassificationTopic().getMainClassification().getDescription());
					
					if (o2.getTopic().getClassificationTopic().getDescription().compareTo(o1.getTopic().getClassificationTopic().getDescription()) != 0)
						return o2.getTopic().getClassificationTopic().getDescription().compareTo(o1.getTopic().getClassificationTopic().getDescription());		
					
					if (o2.getTopic().getTopicDescription().compareTo(o1.getTopic().getTopicDescription()) != 0)
						return o2.getTopic().getTopicDescription().compareTo(o1.getTopic().getTopicDescription());
					
					if (o2.getDescription().compareTo(o1.getDescription()) != 0)
						return o2.getDescription().compareTo(o1.getDescription());
					
					return o2.getShortcut().compareTo(o1.getShortcut());
				}
				
				
			});
		}*/
		
		List<SkillLevels> skillAcquiredList =findSkillAcquiredByStudents(skillresultList,studentId);
		//System.out.println("Skill Acquired size :" + skillAcquiredList.size());
		
		SkillFilteredResult finalresult = new SkillFilteredResult();
		
		/*for (Skill skill : skillresultList)
		{
			System.out.println("ID : " + skill.getId());
		}*/

		finalresult.setTotalSkill(totalSize);
		finalresult.setSkillList(skillresultList);
		finalresult.setSkilltLevelsAcquiredList(skillAcquiredList);
		
	
		
		/* calulate progress(5/20) for main/class topic/topic */
		
		/*List<Topic> topics=new ArrayList<Topic>();
		List<ClassificationTopic> ctopics=new ArrayList<ClassificationTopic>();
		List<MainClassification> mainClassifications=new ArrayList<MainClassification>();
		
		for(int i=0;i<skillresultList.size();i++)
		{
			Skill skill=skillresultList.get(i);
			Topic topic=skill.getTopic();
			ClassificationTopic ctopic=topic.getClassificationTopic();
			MainClassification mainClassification=ctopic.getMainClassification();
			
			
			if(i==0)
			{
				
				topics.add(topic);
				ctopics.add(ctopic);
				mainClassifications.add(mainClassification);
					
				
				
			}
			else
			{
				if( ( topic.getId() != skillresultList.get(i-1).getTopic().getId()))
				{
					topics.add(topic);
				}
				else if( ( ctopic.getId() != skillresultList.get(i-1).getTopic().getClassificationTopic().getId()))
					{
						ctopics.add(ctopic);
					}
				else if( ( mainClassification.getId() != skillresultList.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
				{
					mainClassifications.add(mainClassification);
				}
				}
			}
		
		List<String> mainClassificationProgress=new ArrayList<String>();
		List<String> mainClassificationkey=new ArrayList<String>();
		for(int i=0;i<mainClassifications.size();i++)
		{
			mainClassificationProgress.add(findProgressOfMainClassification( mainClassifications.get(i), studentId));
			mainClassificationkey.add("m"+mainClassifications.get(i));
		}
			 
		finalresult.setMainClassificationkey(mainClassificationkey);
		finalresult.setMainClassificationProgress(mainClassificationProgress);*/
		
		return finalresult;
	}
  
  
  	public static String findProgressOfMainClassification(MainClassification mainClassification,Long studentId)
  	{
  		
  		List<ClassificationTopic> cts=mainClassification.getClassificationTopics();
  		Long aquiredSkillCount=0l;
  		Long totalSkill=0l;
  		for(int i=0;i<cts.size();i++)
  		{
  			ClassificationTopic ctopic=cts.get(i);
  			
  			List<Topic> topics=ctopic.getTopics();
  			
  			for(int j=0;j<topics.size();j++)
  			{
  				Topic topic=topics.get(j);
  				aquiredSkillCount=aquiredSkillCount+findTotalSkillAcquiredByTopicAndStudent(topic.getId(),studentId);
  				
  				totalSkill=totalSkill+topic.getSkills().size();
  			}
  		}
  		
  		return aquiredSkillCount+"/"+totalSkill.toString();
  	}
  	
  	public static String findProgressOfClassificationTopic(ClassificationTopic classificationTopic,Long studentId)
  	{
  		
  		List<Topic> ts=classificationTopic.getTopics();
  		Long aquiredSkillCount=0l;
  		Long totalSkill=0l;
  		for(int i=0;i<ts.size();i++)
  		{
  			Topic topic=ts.get(i);
  			
  			
  			

  				aquiredSkillCount=aquiredSkillCount+findTotalSkillAcquiredByTopicAndStudent(topic.getId(),studentId);
  				
  				totalSkill=totalSkill+topic.getSkills().size();
  			
  		}
  		
  		return aquiredSkillCount+"/"+totalSkill.toString();
  	}
  	
  	public static String findProgressOfTopic(Topic topic,Long studentId)
  	{
  		
  		
  		Long aquiredSkillCount=0l;
  		Integer totalSkill=topic.getSkills().size();
  		
  		aquiredSkillCount=aquiredSkillCount+findTotalSkillAcquiredByTopicAndStudent(topic.getId(),studentId);
  				

  		return aquiredSkillCount+"/"+totalSkill.toString();
  	}
  	
  	public static Long findTotalSkillAcquiredByTopicAndStudent(long topicId,long studentId)
    {
    	/*EntityManager em = entityManager();
    	//String query="select count(sa.skill) from SkillAcquired as sa , Skill as s where sa.skill=s.id and sa.student= "+studentId + " and sa.skill in ( select s.id from Skill as s where s.topic= "+topicId+" ) and sa.skillLevel.levelNumber<=s.skillLevel.levelNumber";
    	TypedQuery<Long> q = em.createQuery("select count(sa) from SkillAcquired as sa , Skill as s where sa.skill=s.id and sa.student= "+studentId + " and sa.skill in ( select s.id from Skill as s where s.topic= "+topicId+" ) and sa.skillLevel.levelNumber>=s.skillLevel.levelNumber", Long.class);
        //System.out.println("Query String: " + query + "=>" + q.getSingleResult());
        return q.getSingleResult();	*/
  		
  		Long count=SkillAcquired.findTotalSkillAcquiredByTopicAndStudent(topicId, studentId);
  		return count;
    }

  		public static Integer findSkillLevelAcquired(long studentId,long skillId)
  	{
  		EntityManager em = entityManager();
  		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
		CriteriaQuery<SkillAcquired> select = criteriaQuery.select(from);
		Predicate p1=criteriaBuilder.and(criteriaBuilder.equal(from.get("student").get("id"), studentId));
		Predicate p2=criteriaBuilder.and(criteriaBuilder.equal(from.get("skill").get("id"), skillId));
		select.where(p1);
		select.where(p2);
		
		TypedQuery<SkillAcquired> result=em.createQuery(criteriaQuery);
		
		if(result.getResultList().size() > 0)
			return result.getResultList().get(0).getSkillLevel().getLevelNumber();
		else 
			return null;
  	}
  	
    private static List<SkillLevels> findSkillAcquiredByStudents(List<Skill> skillresultList,Long studentId) {
    	
    	
    	List<SkillLevels> result = new ArrayList<SkillLevels>();
    	
    	for(Skill skill : skillresultList){
    		
    		
    		try {
    		    			
    			result.add(getSkillAcquiredbyStudentAtThisLevel(studentId, skill.getId()));
    			
    		}catch(Exception e){
    			System.out.println("Error" + e.getStackTrace());
    		}
    	}
    	
    	
    	
    	
    	return result;
    	
	
}
	public static String retrieveHtmlFile(Long studentId,Long mainClassificationId, Long classificationTopicId, Long topicId,String fulltextSearch,int chkAsc) {
    	
    	try {
   // 	String fileSeparator = System.getProperty("file.separator");
	//	String File_To_Convert =RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath(fileSeparator) +  "public/assignment_sp_1.htm";
		
		String File_To_Convert=createHtml(Skill.findMainClassificatonBySearchCriteria(studentId, mainClassificationId, classificationTopicId, topicId, fulltextSearch, chkAsc), studentId);
		
		return  FileUtils.readFileToString(new File(File_To_Convert));
    	}catch(Exception e){
    		
    		return "No data found";
    	}
    }
    
	
	public static org.w3c.dom.Document createDocument()
	{
		try{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.newDocument();
        return doc;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        
	}
	
	public static Element createChildNode(String nodeName,String nodeValue,org.w3c.dom.Document doc,Element parent)
	{
		 Element element = doc.createElement(nodeName);//create  node
		 parent.appendChild(element);	//append to its parent
	        Text text2 = doc.createTextNode(nodeValue);	//create Text node/ value
	        element.appendChild(text2); 
	        return element;
	}
	public static Element createEmptyChildNode(String nodeName,org.w3c.dom.Document doc,Element parent)
	{
		 Element element = doc.createElement(nodeName);//create  node
		 parent.appendChild(element);	//append to its parent
	      //  Text text2 = doc.createTextNode(nodeValue);	//create Text node/ value
	    //    element.appendChild(text2); 
	        return element;
	}
	
	public static String  createHtml(SkillFilteredResult result,Long studentId)
	{
		org.w3c.dom.Document doc=createDocument();
		
		Element root = doc.createElement("mainClassifications");
		
		//append root to document
		doc.appendChild(root);
		List<Skill> skills=result.getSkillList();
		
		Element classificationTopicsElement=null;
		Element topicsElement=null;
		Element skillsElement=null;

		for(int i=0;i<skills.size();i++)
		{
			Skill skill=skills.get(i);
			String topicDescription=skill.getTopic().getTopicDescription();
			String ctopicDescription=skill.getTopic().getClassificationTopic().getDescription();
			String mDescription=(skill.getTopic().getClassificationTopic().getMainClassification().getDescription());
			
			
		
			
			if(i==0)
			{
				 Element mainClassificationElement=createEmptyChildNode("mainClassification",doc,root);
				 createChildNode("description", mDescription, doc, mainClassificationElement);
				 
				  classificationTopicsElement=createEmptyChildNode("classificationTopics",doc,mainClassificationElement);
				 Element classificationTopicElement=createEmptyChildNode("classificationTopic",doc,classificationTopicsElement);
				 createChildNode("description", ctopicDescription, doc, classificationTopicElement);
				 
				  topicsElement=createEmptyChildNode("topics",doc,classificationTopicElement);
				 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
				 createChildNode("description", topicDescription, doc, topicElement);
				  skillsElement=createEmptyChildNode("skills",doc,topicElement);

			}
			else
			{
				if( ( skill.getTopic().getId() != skills.get(i-1).getTopic().getId()))
				{
					
					 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
					 createChildNode("description", topicDescription, doc, topicElement);
					 skillsElement=createEmptyChildNode("skills",doc,topicElement);
					
				}
				else if( ( skill.getTopic().getClassificationTopic().getId() != skills.get(i-1).getTopic().getClassificationTopic().getId()))
					{
					if(!skill.getTopic().getClassificationTopic().getDescription().equals("Blank"))
					{
						
						 Element classificationTopicElement=createEmptyChildNode("classificationTopic",doc,classificationTopicsElement);
						 createChildNode("description", ctopicDescription, doc, classificationTopicElement);
						 
						  topicsElement=createEmptyChildNode("topics",doc,classificationTopicElement);
						 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
						 createChildNode("description", topicDescription, doc, topicElement);
					}
					}
				else if( ( skill.getTopic().getClassificationTopic().getMainClassification().getId() != skills.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
				{
					Element mainClassificationElement=createEmptyChildNode("mainClassification",doc,root);
					 createChildNode("description", mDescription, doc, mainClassificationElement);
					 
					  classificationTopicsElement=createEmptyChildNode("classificationTopics",doc,mainClassificationElement);
					 Element classificationTopicElement=createEmptyChildNode("classificationTopic",doc,classificationTopicsElement);
					 createChildNode("description", ctopicDescription, doc, classificationTopicElement);
					 
					  topicsElement=createEmptyChildNode("topics",doc,classificationTopicElement);
					 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
					 createChildNode("description", topicDescription, doc, topicElement);
					 skillsElement=createEmptyChildNode("skills",doc,topicElement);
				}
			}
			
			
			Element skillElement=createEmptyChildNode("skill",doc,skillsElement);
			createChildNode("description", skill.getDescription(), doc, skillElement);
			
			String ctopicShortCut="";
			String mainClassificationShortcut="";
			if(skill.getTopic().getClassificationTopic().getShortcut() !=null)
				ctopicShortCut=skill.getTopic().getClassificationTopic().getShortcut();
			
			if(skill.getTopic().getClassificationTopic().getMainClassification().getShortcut() !=null)
				mainClassificationShortcut=skill.getTopic().getClassificationTopic().getMainClassification().getShortcut();
			
			
			createChildNode("shortcut", mainClassificationShortcut+ " "+ ctopicShortCut +" "+skill.getShortcut(), doc, skillElement);
			createChildNode("skillLevel", skill.getSkillLevel().getLevelNumber().toString(), doc, skillElement);	
			
			Integer levelNum=Skill.findSkillLevelAcquired(studentId, skill.getId());
			if(levelNum !=null)
				createChildNode("skillLevelAcquired", levelNum.toString(), doc, skillElement);
			else
				createChildNode("skillLevelAcquired", "-", doc, skillElement);
			
			
		}
		
		
		return saveXML(doc);
		
	}
	
	
	
	
	public static String saveXML(org.w3c.dom.Document doc)
	{
		try{
			TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer = factory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        StringWriter sw = new StringWriter();
	        StreamResult result = new StreamResult(sw);
	        DOMSource source = new DOMSource(doc);
	        transformer.transform(source, result);
	        String xmlString = sw.toString();

	       // File file = new File("osMaEntry/gwt/unibas/"+System.currentTimeMillis()+".xml");
	        String path=RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath("/applicationScaffold/gwt/logbook/");
	        String fileName=path+System.currentTimeMillis()+".xml";
	        
	        
	        File file = new File(fileName);
	        file.createNewFile();
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
	        bw.write(xmlString);
	        bw.flush();
	        bw.close();
	        
	        
	        String htmlFileName=convertXmlToHtml(fileName);
	        
	        return htmlFileName;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String convertXmlToHtml(String fileName)
	{
		 try
	        {
			 
			 	
			 	
	            TransformerFactory tFactory = TransformerFactory.newInstance();
	            String xslPath=RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath("/applicationScaffold/gwt/logbook/skill.xsl");
	            Source xslDoc = new StreamSource(xslPath);
	            Source xmlDoc = new StreamSource(fileName);
	            
	            String path=RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath("/applicationScaffold/gwt/logbook/");
	            String outputFileName =path +System.currentTimeMillis()+".html";
	            OutputStream htmlFile = new FileOutputStream(outputFileName);

	            Transformer transformer = tFactory.newTransformer(xslDoc);
	            transformer.setErrorListener(new ErrorListener() {
					
					@Override
					public void warning(TransformerException exception)
							throws TransformerException {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void fatalError(TransformerException exception)
							throws TransformerException {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void error(TransformerException exception)
							throws TransformerException {
						// TODO Auto-generated method stub
						
					}
				});
	            transformer.transform(xmlDoc, new StreamResult(htmlFile));
	            htmlFile.close();
	            File xmlFile=new File(fileName);
	            xmlFile.delete();
	           return outputFileName;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	}
	
    public static SkillLevels getSkillAcquiredbyStudentAtThisLevel(Long studentID,Long skillID){
    	
    	Log.info("Inside isSkillAcquiredbyStudentAtFirstLevel with student " + studentID + " skill : " +skillID );
    	EntityManager em = entityManager();
    	
    	String query = "SELECT sa.skillLevel from SkillAcquired as sa where sa.student="+studentID + " and sa.skill="+skillID ;
    	Log.info("Query is :" + query);
    	TypedQuery<SkillLevel> result = em.createQuery(query, SkillLevel.class);
    	if(result.getResultList().size()==0)
    	{
    		return SkillLevels.NONE;
    	}
    	else
    	{	
    		
    		 if(result.getResultList().get(0).getLevelNumber()==1)
    		 {
    			 return SkillLevels.SOME_PRACTICLE_EXPERIENCE;
    		 }
    		 else if(result.getResultList().get(0).getLevelNumber() ==2){
    			 return SkillLevels.ROUTINE;
    		 }
    	}
		
		return SkillLevels.NONE;
    	
    }
     public static Long findTotalSkillByTopic(long topicId)
    {
    	/*EntityManager em = entityManager();
        String query="select count(s.id) from Skill as s where s.topic= "+topicId;
    	TypedQuery<Long> q = em.createQuery("select count(s) from Skill as s where s.topic= "+topicId, Long.class);
        System.out.println("Query String: " + query);
        return q.getSingleResult();*/
    	
    	CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		criteriaQuery.select(criteriaBuilder.count(from));				
		criteriaQuery.where(criteriaBuilder.equal(from.get("topic"), topicId));
		TypedQuery<Long> result = entityManager().createQuery(criteriaQuery);
		//System.out.println("~~QUERY +++ : " + result.unwrap(org.hibernate.Query.class).getQueryString());		
        return result.getSingleResult();
    }
private static String getSkillIdList(List<Skill> skillList){
		
		if (skillList == null || skillList.size() == 0) {
			Log.info("SkillList Return as null");
			return "";
		}
		Iterator<Skill> skillListIterator = skillList.iterator();
		StringBuilder skillId = new StringBuilder();
		skillId.append(",");
		while (skillListIterator.hasNext()) {
			Skill skill = skillListIterator.next();

			skillId.append(skill.getId().toString());
			if (skillListIterator.hasNext()) {
				skillId.append(" ,");
			}
		}
		return skillId.toString();
	}
    

}
