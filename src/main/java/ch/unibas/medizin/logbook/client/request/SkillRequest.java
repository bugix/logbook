package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.SkillProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Skill")
public interface SkillRequest extends RequestContext {

	abstract Request<Long> countSkills();

	abstract Request<List<SkillProxy>> findAllSkills();

	abstract Request<List<SkillProxy>> findSkillEntries(int firstResult, int maxResults);

	abstract Request<SkillProxy> findSkill(Long id);

	abstract InstanceRequest<SkillProxy, Void> persist();

	abstract InstanceRequest<SkillProxy, Void> remove();
}
