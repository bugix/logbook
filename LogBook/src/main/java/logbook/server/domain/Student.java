package logbook.server.domain;

import static logbook.shared.scaffold.LogBookConstant.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import logbook.shared.Gender;
import logbook.shared.StudentStatus;
import logbook.shared.StudyYears;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findStudentsByEmailEquals" })
public class Student {

    @Size(max = 45)
    private String studentId;

    @Size(max = 50)
    private String shib_id;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")
    @Size(max = 40)   
    private String email;

    @Enumerated
    private Gender gender;

    @NotNull
    @Size(max = 40)
    private String name;

    @NotNull
    @Size(max = 40)
    private String preName;

    @Enumerated
    private StudentStatus studentStatus;

    @Enumerated
    private StudyYears studyYear;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<SkillAcquired> skillAcquired = new HashSet<SkillAcquired>();

    public static logbook.server.domain.Student findStudentFromSession() 
    {
        HttpSession session = RequestFactoryServlet.getThreadLocalRequest().getSession();
        Long studId = Long.parseLong((String) session.getAttribute(UNIQUE_ID),10);
        System.out.println("Student id: " + studId);
        Student student=Student.findStudent(studId);
        return student;
    }
    
    public static Boolean isCurrentUserStudent() {
    	HttpSession session = RequestFactoryServlet.getThreadLocalRequest().getSession();
    	if(STUDENT.equals(session.getAttribute(CURRENT_USER))) {
    		return true;
    	}else if(ADMIN.equals(session.getAttribute(CURRENT_USER))) {
    		return false;
    	}
    	else {
    		return null;
    	}
    }
}
