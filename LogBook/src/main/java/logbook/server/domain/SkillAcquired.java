package logbook.server.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java_cup.internal_error;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import logbook.shared.SkillLevels;

import org.hibernate.Query;
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
    
    public static Long findCountOfSkillAcquiredBySkillLevelAndStudent(long studentId,long skillLevelId) 
    {
    	/*EntityManager em = entityManager();
         TypedQuery<Long> q = em.createQuery("select count(sa.skillLevel) from SkillAcquired as sa where sa.student = " + studentId + " and skillLevel = " + skillLevelId + " order by sa.created desc", Long.class);                  
         return q.getSingleResult();*/	
    	CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
		CriteriaQuery<SkillAcquired> select = criteriaQuery.select(from);
		select.orderBy(criteriaBuilder.desc(from.get("created")));
		
		Predicate predicate1 = criteriaBuilder.equal(from.get("student"), studentId);
		predicate1 = criteriaBuilder.and(predicate1, criteriaBuilder.equal(from.get("skillLevel"), skillLevelId));
		
		criteriaQuery.where(predicate1);
		
		TypedQuery<SkillAcquired> query = entityManager().createQuery(criteriaQuery);
		System.out.println("~~QUERY : " + query.unwrap(Query.class).getQueryString());
		Long count = (long) query.getResultList().size();
		return count;
    }
    
    public static List<Long> findTotalSkillAcquiredByStudentLevelVise(long studentId) 
    {
    	List<Long> listOfSkillAcquiredBySkillLevelAndStudent=new ArrayList<Long>();
    	listOfSkillAcquiredBySkillLevelAndStudent.add(findCountOfSkillAcquiredBySkillLevelAndStudent(studentId,1l));
    	listOfSkillAcquiredBySkillLevelAndStudent.add(findCountOfSkillAcquiredBySkillLevelAndStudent(studentId,2l));
    	return listOfSkillAcquiredBySkillLevelAndStudent;
         
    }
    
    public static List<SkillAcquired> findLatestAcquiredSkillByStudent(Long studentId, String sortOrder,String sortBy,Integer start,Integer rangeLength)
    {
    	EntityManager em = entityManager();
        TypedQuery<SkillAcquired> q = em.createQuery("select sa from SkillAcquired as sa where sa.student = " +studentId+ " order by sa."+sortBy+" "+sortOrder, SkillAcquired.class).setFirstResult(start).setMaxResults(rangeLength);
    	//TypedQuery<SkillAcquired> q = em.createQuery("select sa from SkillAcquired as sa order by sa.created "+sortOrder, SkillAcquired.class);
        Log.info("Query String: " + q);
        return q.getResultList();		
    }
    
    public static Integer findCountLatestAcquiredSkillByStudent(Long studentId, Integer totalRecords, String sortOrder,String sortBy)
    {
    	EntityManager em = entityManager();
        TypedQuery<SkillAcquired> q = em.createQuery("select sa from SkillAcquired as sa where sa.student = " +studentId+ " order by sa."+sortBy+" "+sortOrder, SkillAcquired.class).setFirstResult(0).setMaxResults(totalRecords);
    	//TypedQuery<SkillAcquired> q = em.createQuery("select sa from SkillAcquired as sa order by sa.created "+sortOrder, SkillAcquired.class);
        Log.info("Query String: " + q);
        return q.getResultList().size();		
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
