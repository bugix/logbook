package logbook.server.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Topic {

    @Size(max = 1024)
    private String topicDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    private Set<Skill> skills = new HashSet<Skill>();

    @ManyToOne
    private ClassificationTopic classificationTopic;
}
