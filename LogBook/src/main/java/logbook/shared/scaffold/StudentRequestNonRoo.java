package logbook.shared.scaffold;

import logbook.client.managed.proxy.StudentProxy;
import logbook.server.domain.Student;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Student.class)
public interface StudentRequestNonRoo extends RequestContext {
	abstract Request<StudentProxy> findStudentFromSession();

}
