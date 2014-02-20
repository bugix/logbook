package ch.unibas.medizin.logbook.server.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;
import com.allen_sauer.gwt.log.client.Log;

@Entity
@Configurable
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
		
		/*EntityManager em = entityManager();
		String query="select count(sa) from SkillAcquired as sa , Skill as s where sa.skill=s.id and sa.student= "+studentId + " and sa.skillLevel.levelNumber= "+skillLevelId+" and sa.skillLevel.levelNumber>=s.skillLevel.levelNumber";	
		//String query="select count(sa.id) from SkillAcquired as sa where sa.skill in (select s.id from Skill as s where s.skillLevel.levelNumber in (select sl.levelNumber from SkillLevel as sl where sl.levelNumber= "+skillLevelId+")) and sa.student= "+ studentId ;
		TypedQuery<Long> q =em.createQuery(query, Long.class); 
		Long count = (long) q.getSingleResult();
		System.out.println("Query TotalCount Level 1: " + query + "Count: " + count);
		return count;*/
		
   		//String query="select count(sa) from SkillAcquired as sa , Skill as s 
   		//where sa.skill=s.id 
   		//and sa.student= "+studentId + " 
   		//and sa.skillLevel.levelNumber= "+skillLevelId+" 
   		//and sa.skillLevel.levelNumber>=s.skillLevel.levelNumber";
   		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
					
		criteriaQuery.select(criteriaBuilder.count(from));
		
		Join<SkillAcquired, Skill> join1 = from.join("skill");
		Predicate studentPredicate = criteriaBuilder.equal(from.get("student"),studentId);
		Predicate skillLevelPredicate = criteriaBuilder.equal(from.get("skillLevel").get("levelNumber"),skillLevelId);
		
		Expression<Integer> expLevelNo = from.get("skillLevel").get("levelNumber");
		Expression<Integer> expSkillLvlNo = join1.get("skillLevel").get("levelNumber");
		
		Predicate predicate3 = criteriaBuilder.ge(expLevelNo, expSkillLvlNo);			
		Predicate andPre = criteriaBuilder.and(studentPredicate, skillLevelPredicate, predicate3);
	
		criteriaQuery.where(andPre);
		
		TypedQuery<Long> q = entityManager().createQuery(criteriaQuery);
		//System.out.println("Total Skill Count Query : " + q.unwrap(Query.class).getQueryString());
		return q.getSingleResult();
				
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
		
		/*EntityManager em = entityManager();
    	
    	String query = "select sa from SkillAcquired as sa where sa.student="+studentId + " and sa.skill="+skillId ;
    	Log.info("Query is :" + query);
    	
    	TypedQuery<SkillAcquired> saResult = em.createQuery(query, SkillAcquired.class);
    	return saResult.getResultList();*/
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
		
		criteriaQuery.select(from);
		
		Predicate studentPredicate=criteriaBuilder.equal(from.get("student"),studentId);
		Predicate skillPredicate=criteriaBuilder.equal(from.get("skill"),skillId);
		Predicate andPredicate=criteriaBuilder.and(studentPredicate,skillPredicate);
				
		criteriaQuery.where(andPredicate);
		
		TypedQuery<SkillAcquired> q = entityManager().createQuery(criteriaQuery);
		//System.out.println("Query String : " + q.unwrap(Query.class).getQueryString());
		return q.getResultList();
		
		
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
    
	public static List<SkillAcquired> findSkillAcquiredByStudent(Long studentId){
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
		CriteriaQuery<SkillAcquired> select = criteriaQuery.select(from);
		
		select.orderBy(criteriaBuilder.asc(from.get("skill")));
				
		criteriaQuery.where(criteriaBuilder.equal(from.get("student"),studentId));
		TypedQuery<SkillAcquired> result = entityManager().createQuery(criteriaQuery);
		//System.out.println("~~QUERY +++ : " + result.unwrap(org.hibernate.Query.class).getQueryString());		
	    return result.getResultList();
		
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

	public Date getCreated() {
        return this.created;
    }

	public void setCreated(Date created) {
        this.created = created;
    }

	public Skill getSkill() {
        return this.skill;
    }

	public void setSkill(Skill skill) {
        this.skill = skill;
    }

	public Student getStudent() {
        return this.student;
    }

	public void setStudent(Student student) {
        this.student = student;
    }

	public SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

	public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new SkillAcquired().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSkillAcquireds() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SkillAcquired o", Long.class).getSingleResult();
    }

	public static List<SkillAcquired> findAllSkillAcquireds() {
        return entityManager().createQuery("SELECT o FROM SkillAcquired o", SkillAcquired.class).getResultList();
    }

	public static SkillAcquired findSkillAcquired(Long id) {
        if (id == null) return null;
        return entityManager().find(SkillAcquired.class, id);
    }

	public static List<SkillAcquired> findSkillAcquiredEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SkillAcquired o", SkillAcquired.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            SkillAcquired attached = SkillAcquired.findSkillAcquired(this.id);
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
    public SkillAcquired merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SkillAcquired merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
