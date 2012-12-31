package logbook.server.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
		/*EntityManager em = entityManager();
		
		String sql = "";
		
		if (value != null)
			sql = "SELECT c FROM ClassificationTopic c WHERE c.mainClassification.id = " + value;
		else
			sql = "SELECT c FROM ClassificationTopic c";
			
		TypedQuery<ClassificationTopic> q = em.createQuery(sql, ClassificationTopic.class);
		return q.getResultList();*/
		
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<ClassificationTopic> criteriaQuery = criteriaBuilder.createQuery(ClassificationTopic.class);
		Root<ClassificationTopic> from = criteriaQuery.from(ClassificationTopic.class);
		CriteriaQuery<ClassificationTopic> select = criteriaQuery.select(from);
		
		if (value != null)
			criteriaQuery.where(criteriaBuilder.equal(from.get("mainClassification"), value));
		
		TypedQuery<ClassificationTopic> q = entityManager().createQuery(criteriaQuery);
		return q.getResultList();
	}
}
