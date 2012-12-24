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
@RooJpaActiveRecord(finders = { "findClassificationTopicsByMainClassification" })
public class ClassificationTopic {

    @Size(max = 255)
    private String description;

    @Size(max = 8)
    private String shortcut;

    @ManyToOne
    private MainClassification mainClassification;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classificationTopic")
    private Set<Topic> topics = new HashSet<Topic>();
}
