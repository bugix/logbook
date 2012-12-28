package logbook.server.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.allen_sauer.gwt.log.client.Log;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class SkillAcquired {
   
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date created = new Date();

    @ManyToOne
    private Skill skill;

    @ManyToOne
    private Student student;

    @ManyToOne
    private SkillLevel skillLevel;
    
  /*  public static Long findCountOfSkillAcquiredBySkillLevelAndStudent(long studentId,long skillLevelId) 
    {
    	EntityManager em = entityManager();
         TypedQuery<Long> q = em.createQuery("select count(sa.skillLevel) from SkillAcquired as sa where sa.student = " + studentId + " and skillLevel = " + skillLevelId + " order by sa.created desc", Long.class);                  
         return q.getSingleResult();	
    }*/
    
   	public static Long findCountOfSkillAcquiredBySkillLevelAndStudent(long studentId, long skillLevelId) 
	{
		
		EntityManager em = entityManager();
		String query="select count(sa.id) from SkillAcquired as sa where sa.skill in (select s.id from Skill as s where s.skillLevel in (select sl.levelNumber from SkillLevel as sl where sl.levelNumber= "+skillLevelId+")) and sa.student= "+ studentId ;
		TypedQuery<Long> q =em.createQuery(query, Long.class); 
		Long count = (long) q.getSingleResult();
		return count;
		
		/*// "select count(sa.id) from SkillAcquired as sa where sa.skill in (select s.id from Skill as s where s.skillLevel in (select sl.levelNumber from SkillLevel as sl where sl.levelNumber= "+skillLevelId+")) and sa.student= "+ studentId 
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
		
		criteriaQuery.select(criteriaBuilder.count(from));				
	
		Predicate predicate1 = criteriaBuilder.equal(from.get("skill").get("skillLevel").get("levelNumber"), skillLevelId);
		Predicate predicate3 = criteriaBuilder.equal(from.get("student"),studentId);
		
		Predicate andPre = criteriaBuilder.and(predicate1, predicate3);
		
		criteriaQuery.where(andPre);
    	
		TypedQuery<Long> q = entityManager().createQuery(criteriaQuery);
		System.out.println("~~QUERY : " + q.unwrap(Query.class).getQueryString());
		return q.getSingleResult();*/
	}
    
    public static List<Long> findTotalSkillAcquiredByStudentLevelVise(long studentId) 
    {
    	List<Long> listOfSkillAcquiredBySkillLevelAndStudent=new ArrayList<Long>();
    	listOfSkillAcquiredBySkillLevelAndStudent.add(findCountOfSkillAcquiredBySkillLevelAndStudent(studentId,1l));
    	listOfSkillAcquiredBySkillLevelAndStudent.add(findCountOfSkillAcquiredBySkillLevelAndStudent(studentId,2l));
    	return listOfSkillAcquiredBySkillLevelAndStudent;
         
    }
    
   	public static List<SkillAcquired> findLatestAcquiredSkillByStudent(Long studentId, String sortOrder, String sortBy, Integer start,Integer rangeLength) {
		/*EntityManager em = entityManager();
		TypedQuery<SkillAcquired> q = em.createQuery("select sa from SkillAcquired as sa where sa.student = "+ studentId + " order by sa." + sortBy + " "+ sortOrder, SkillAcquired.class).setFirstResult(start).setMaxResults(rangeLength);
		Log.info("Query String: " + q);*/
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
					
		criteriaQuery.select(from);
		
		Predicate studentPredicate = criteriaBuilder.equal(from.get("student"),studentId);
		criteriaQuery.where(studentPredicate);
		
		if(sortOrder.compareToIgnoreCase("ASCE")==0)
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get(sortBy)));
		else
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get(sortBy)));
		
		TypedQuery<SkillAcquired> q = entityManager().createQuery(criteriaQuery);
		q.setFirstResult(start);
		q.setMaxResults(rangeLength);
		//System.out.println("~~QUERY ++++: " + q.unwrap(Query.class).getQueryString() + "  Size: " + q.getResultList().size());
		return q.getResultList();
	}

    
   public static Integer findCountLatestAcquiredSkillByStudent(Long studentId,Integer totalRecords, String sortOrder, String sortBy) 
	{
		/*EntityManager em = entityManager();
		TypedQuery<SkillAcquired> q = em.createQuery("select sa from SkillAcquired as sa where sa.student = "+ studentId + " order by sa." + sortBy + " " + sortOrder, SkillAcquired.class).setFirstResult(0).setMaxResults(totalRecords);
		return q.getResultList().size();*/
			
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
					
		criteriaQuery.select(from);
		
		Predicate studentPredicate = criteriaBuilder.equal(from.get("student"),studentId);
		criteriaQuery.where(studentPredicate);
		
		if(sortOrder.compareToIgnoreCase("ASCE")==0)
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get(sortBy)));
		else
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get(sortBy)));
		
		TypedQuery<SkillAcquired> q = entityManager().createQuery(criteriaQuery);
		q.setFirstResult(0);
		q.setMaxResults(totalRecords);
		//System.out.println("~~QUERY ++++: " + q.unwrap(Query.class).getQueryString() + "  Size: " + q.getResultList().size());
		return q.getResultList().size();
		
	}

public static Integer countSkillAcquiredByStudentandSkill(Long studentId,List<Skill> skillList) 
	{
		/*EntityManager em = entityManager();
		if (skillList.size() > 0) 
		{
			//String query="select count(sa.skill) from SkillAcquired as sa where sa.student= "+ studentId + " and sa.skill in ("+ StringUtils.join(skillList, ",") + ")";
			TypedQuery<Integer> q = em.createQuery("select count(sa.skill) from SkillAcquired as sa where sa.student= "+ studentId + " and sa.skill in ("+ StringUtils.join(skillList, ",") + ")",Integer.class);
			//System.out.println("Query String: " + query);
			return q.getSingleResult();
		} else {
			return 0;
		}*/
		
		if (skillList.size() > 0) 
		{
			CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
			CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
			Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
			
			criteriaQuery.select(criteriaBuilder.count(from));				
		
			Predicate predicate1 = criteriaBuilder.equal(from.get("student"), studentId);
			Expression<Integer> expLevelNo = from.get("skill");
			Predicate predicate3 = from.get("skill").in(StringUtils.join(skillList, ","));
			
			Predicate andPre = criteriaBuilder.and(predicate1, predicate3);
			
			criteriaQuery.where(andPre);
	    	
			TypedQuery<Long> q = entityManager().createQuery(criteriaQuery);
			//System.out.println("~~QUERY : " + q.unwrap(Query.class).getQueryString());
			return q.getSingleResult().intValue();
		} else {
			return 0;
		}
	}
 public static Long findTotalSkillAcquiredByTopicAndStudent(long topicId,long studentId)
	    {
	    	/*EntityManager em = entityManager();
	    	//String query="select count(sa.skill) from SkillAcquired as sa , Skill as s where sa.skill=s.id and sa.student= "+studentId + " and sa.skill in ( select s.id from Skill as s where s.topic= "+topicId+" ) and sa.skillLevel.levelNumber<=s.skillLevel.levelNumber";	    		  
	    	TypedQuery<Long> q = em.createQuery("select count(sa.skill) from SkillAcquired as sa , Skill as s where sa.skill=s.id and sa.student= "+studentId + " and sa.skill in ( select s.id from Skill as s where s.topic= "+topicId+" ) and sa.skillLevel.levelNumber<=s.skillLevel.levelNumber", Long.class);
	        //System.out.println("Query String: " + query + "=>" + q.getSingleResult());
	        return q.getSingleResult();*/
		  
		  	CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
			CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
			Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
			
			criteriaQuery.select(criteriaBuilder.count(from));				
			
			Join<SkillAcquired, Skill> join1 = from.join("skill");
			Predicate predicate1 = criteriaBuilder.equal(from.get("student"), studentId);
			Predicate predicate2 = criteriaBuilder.equal(from.get("skill").get("topic"), topicId);
			
			Expression<Integer> expLevelNo = from.get("skillLevel").get("levelNumber");
			Expression<Integer> expSkillLvlNo = join1.get("skillLevel").get("levelNumber");
			Predicate predicate3 = criteriaBuilder.ge(expLevelNo, expSkillLvlNo);			
			Predicate andPre = criteriaBuilder.and(predicate1, predicate2, predicate3);
			
			criteriaQuery.where(andPre);
	    	TypedQuery<Long> q = entityManager().createQuery(criteriaQuery);
	    	
	    	//System.out.println("~~QUERY : " + q.unwrap(Query.class).getQueryString());
	        return q.getSingleResult();		

	    }
    public static String acquireORDeleteSkill(Long studentId,Long skillId,Boolean isFirstSelected,Boolean isDeleteOperation){
    	Log.info("Inside  acquireORDeleteSkill with student :" + studentId + " and Skill " +skillId);
    	
    	try{
	    	String result="";
	    	
	    	if(isDeleteOperation){
	    		SkillAcquired sa =(findSkillAcquiredByStudent(studentId,skillId).get(0));
	    		sa.remove();
	    		result="DELETE";
	    	}
	    	else{
	    		
	    			List<SkillAcquired> saList =(findSkillAcquiredByStudent(studentId,skillId));
	    					
		    		if(saList.size()==0)
		        	{
		        		persistSkillAcquired(studentId,skillId,isFirstSelected);
		        		result="INSERT";
		        	}
		    		else{
		    			SkillAcquired sa= saList.get(0);
		    			if(isFirstSelected){
		    				sa.setSkillLevel(SkillLevel.findSkillByLevelNumber(1));
		    			}
		    			else{
		    				sa.setSkillLevel(SkillLevel.findSkillByLevelNumber(2));
		    			}
		    			sa.persist();
	        			result="UPDATE";
		    		}
	    		}
	    	return result;
    	}catch(Exception e){
    		return "ERROR";
    	}
    	
    }

	private static List<SkillAcquired> findSkillAcquiredByStudent(Long studentId, Long skillId) {
		
		EntityManager em = entityManager();
    	
    	String query = "select sa from SkillAcquired as sa where sa.student="+studentId + " and sa.skill="+skillId ;
    	Log.info("Query is :" + query);
    	
    	TypedQuery<SkillAcquired> saResult = em.createQuery(query, SkillAcquired.class);
    	return saResult.getResultList();
	}

	private static void persistSkillAcquired(Long studentId, Long skillId,Boolean isFirstSelected) {
		
		try{
			SkillAcquired sa =new SkillAcquired();
			sa.setCreated(new Date());
			sa.setSkill(Skill.findSkill(skillId));
			sa.setStudent(Student.findStudent(studentId));
			if(isFirstSelected){
				sa.setSkillLevel(SkillLevel.findSkillByLevelNumber(1));
			}
			else {
				sa.setSkillLevel(SkillLevel.findSkillByLevelNumber(2));
			}
				sa.persist();
		}catch(Exception e){
			System.out.println("Exception When new Skil Acquired created is :" + e.getStackTrace());
			
		}
	}
    
 
}
