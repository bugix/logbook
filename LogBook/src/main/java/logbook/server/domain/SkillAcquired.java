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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
 
}
