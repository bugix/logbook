package logbook.server.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class MainClassification {

    private String description;

    @Size(max = 2)
    private String shortcut;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "mainClassification")
    private Set<ClassificationTopic> classificationTopics = new HashSet<ClassificationTopic>();*/
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainClassification")
    private List<ClassificationTopic> classificationTopics = new ArrayList<ClassificationTopic>();

}
