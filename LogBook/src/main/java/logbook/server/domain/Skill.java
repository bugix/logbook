package logbook.server.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
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
    
}
