package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.StudentProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Student")
public interface StudentRequest extends RequestContext {

	//abstract Request<Long> countStudents();

	//abstract Request<List<StudentProxy>> findAllStudents();

	//abstract Request<List<StudentProxy>> findStudentEntries(int firstResult, int maxResults);

	abstract Request<StudentProxy> findStudent(Long id);

	abstract InstanceRequest<StudentProxy, Void> persist();

	//abstract InstanceRequest<StudentProxy, Void> remove();
	
	abstract Request<StudentProxy> findStudentFromSession();

	abstract Request<Boolean> isCurrentUserStudent();
}
