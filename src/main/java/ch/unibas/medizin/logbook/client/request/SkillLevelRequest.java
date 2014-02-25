package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.SkillLevelProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.SkillLevel")
public interface SkillLevelRequest extends RequestContext {

	//abstract Request<Long> countSkillLevels();

	//abstract Request<List<SkillLevelProxy>> findAllSkillLevels();

	//abstract Request<List<SkillLevelProxy>> findSkillLevelEntries(int firstResult, int maxResults);

	//abstract Request<SkillLevelProxy> findSkillLevel(Long id);

	//abstract InstanceRequest<SkillLevelProxy, Void> persist();

	//abstract InstanceRequest<SkillLevelProxy, Void> remove();
}
