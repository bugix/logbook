// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import org.springframework.roo.addon.gwt.RooGwtRequest;

import ch.unibas.medizin.logbook.client.managed.proxy.StudentProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@RooGwtRequest("logbook.server.domain.Student")
@ServiceName("logbook.server.domain.Student")
public interface StudentRequest extends RequestContext {

    abstract Request<java.lang.Long> countStudents();

    abstract Request<java.util.List<StudentProxy>> findAllStudents();

    abstract Request<java.util.List<StudentProxy>> findStudentEntries(int firstResult, int maxResults);

    abstract Request<StudentProxy> findStudent(Long id);

    abstract InstanceRequest<StudentProxy, Void> persist();

    abstract InstanceRequest<StudentProxy, Void> remove();
}
