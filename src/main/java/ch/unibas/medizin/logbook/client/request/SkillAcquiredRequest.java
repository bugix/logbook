package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.SkillAcquiredProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.SkillAcquired")
public interface SkillAcquiredRequest extends RequestContext {

	abstract Request<Long> countSkillAcquireds();

	abstract Request<List<SkillAcquiredProxy>> findAllSkillAcquireds();

	abstract Request<List<SkillAcquiredProxy>> findSkillAcquiredEntries(int firstResult, int maxResults);

	abstract Request<SkillAcquiredProxy> findSkillAcquired(Long id);

	abstract InstanceRequest<SkillAcquiredProxy, Void> persist();

	abstract InstanceRequest<SkillAcquiredProxy, Void> remove();
}
