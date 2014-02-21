package ch.unibas.medizin.logbook.shared.request;

import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.server.domain.Student;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Student.class)
public interface StudentRequestNonRoo extends RequestContext {
	abstract Request<StudentProxy> findStudentFromSession();

	abstract Request<Boolean> isCurrentUserStudent();
}
