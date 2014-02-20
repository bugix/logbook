// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.Student")
@ServiceName("logbook.server.domain.Student")
public interface StudentRequest extends RequestContext {

    abstract Request<java.lang.Long> countStudents();

    abstract Request<java.util.List<logbook.client.managed.proxy.StudentProxy>> findAllStudents();

    abstract Request<java.util.List<logbook.client.managed.proxy.StudentProxy>> findStudentEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.StudentProxy> findStudent(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.StudentProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.StudentProxy, java.lang.Void> remove();
}
