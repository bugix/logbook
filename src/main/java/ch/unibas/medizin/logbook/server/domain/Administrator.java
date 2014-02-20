package ch.unibas.medizin.logbook.server.domain;

import static ch.unibas.medizin.logbook.shared.scaffold.LogBookConstant.UNIQUE_ID;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;
import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

@Configurable
@Entity
public class Administrator {

	@NotNull
	@Size(max = 40)   
    private String email;
    
    @NotNull
    @Size(max = 40)
    private String name;

    @NotNull
    @Size(max = 40)
    private String preName;
    
    public static Administrator findAdministratorFromSession()
    {
        HttpSession session = RequestFactoryServlet.getThreadLocalRequest().getSession();
        String mailId = (String) session.getAttribute(UNIQUE_ID);
        Log.info("mail id: " + mailId); 
        Administrator administrator = Administrator.findAdministratorUsingEmail(mailId);
        return administrator;
 	
    }

	public static Administrator findAdministratorUsingEmail(String mailId) 
	{
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Administrator> criteriaQuery = criteriaBuilder.createQuery(Administrator.class);
		Root<Administrator> from = criteriaQuery.from(Administrator.class);
					
		Predicate emailAddress = criteriaBuilder.equal(from.get("email"), mailId);
		criteriaQuery.where(emailAddress);
		
		TypedQuery<Administrator> q = entityManager().createQuery(criteriaQuery);
		
		Log.info("Query : " + q.unwrap(Query.class).getQueryString());
		
        return q.getSingleResult();	
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

	public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public String getPreName() {
        return this.preName;
    }

	public void setPreName(String preName) {
        this.preName = preName;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Administrator().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAdministrators() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Administrator o", Long.class).getSingleResult();
    }

	public static List<Administrator> findAllAdministrators() {
        return entityManager().createQuery("SELECT o FROM Administrator o", Administrator.class).getResultList();
    }

	public static Administrator findAdministrator(Long id) {
        if (id == null) return null;
        return entityManager().find(Administrator.class, id);
    }

	public static List<Administrator> findAdministratorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Administrator o", Administrator.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Administrator attached = Administrator.findAdministrator(this.id);
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
    public Administrator merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Administrator merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
