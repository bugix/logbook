package logbook.server.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
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
    private List<Topic> topics = new ArrayList<Topic>();
    
    public static List<ClassificationTopic> findClassiTopicByMainClassfication(Long value)
	{
		EntityManager em = entityManager();
		
		String sql = "";
		
		if (value != null)
			sql = "SELECT c FROM ClassificationTopic c WHERE c.mainClassification.id = " + value;
		else
			sql = "SELECT c FROM ClassificationTopic c";
			
		TypedQuery<ClassificationTopic> q = em.createQuery(sql, ClassificationTopic.class);
		return q.getResultList();
	}
}
