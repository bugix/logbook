// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.Skill")
@ServiceName("logbook.server.domain.Skill")
public interface SkillRequest extends RequestContext {

    abstract Request<java.lang.Long> countSkills();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkillProxy>> findAllSkills();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkillProxy>> findSkillEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.SkillProxy> findSkill(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.SkillProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.SkillProxy, java.lang.Void> remove();
}
