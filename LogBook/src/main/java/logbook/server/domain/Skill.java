package logbook.server.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;

import org.mortbay.log.Log;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

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
}
