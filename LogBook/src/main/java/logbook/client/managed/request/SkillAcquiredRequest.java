// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.SkillAcquired")
@ServiceName("logbook.server.domain.SkillAcquired")
public interface SkillAcquiredRequest extends RequestContext {

    abstract Request<java.lang.Long> countSkillAcquireds();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkillAcquiredProxy>> findAllSkillAcquireds();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkillAcquiredProxy>> findSkillAcquiredEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.SkillAcquiredProxy> findSkillAcquired(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.SkillAcquiredProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.SkillAcquiredProxy, java.lang.Void> remove();
}
