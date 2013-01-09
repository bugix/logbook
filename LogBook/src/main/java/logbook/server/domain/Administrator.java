package logbook.server.domain;

import static logbook.shared.scaffold.LogBookConstant.UNIQUE_ID;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.math.util.MathUtils;
import org.hibernate.Query;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
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
        System.out.println("mail id: " + mailId); 
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
		
		System.out.println("Query : " + q.unwrap(Query.class).getQueryString());
		
        return q.getSingleResult();	
	}
    
}