// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import ch.unibas.medizin.logbook.client.managed.proxy.SkillProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("logbook.server.domain.Skill")
public interface SkillRequest extends RequestContext {

    abstract Request<java.lang.Long> countSkills();

    abstract Request<java.util.List<SkillProxy>> findAllSkills();

    abstract Request<java.util.List<SkillProxy>> findSkillEntries(int firstResult, int maxResults);

    abstract Request<SkillProxy> findSkill(Long id);

    abstract InstanceRequest<SkillProxy, java.lang.Void> persist();

    abstract InstanceRequest<SkillProxy, java.lang.Void> remove();
}
