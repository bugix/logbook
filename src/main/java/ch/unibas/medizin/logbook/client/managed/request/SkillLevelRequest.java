// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import org.springframework.roo.addon.gwt.RooGwtRequest;

import ch.unibas.medizin.logbook.client.managed.proxy.SkillLevelProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@RooGwtRequest("logbook.server.domain.SkillLevel")
@ServiceName("logbook.server.domain.SkillLevel")
public interface SkillLevelRequest extends RequestContext {

    abstract Request<java.lang.Long> countSkillLevels();

    abstract Request<java.util.List<SkillLevelProxy>> findAllSkillLevels();

    abstract Request<java.util.List<SkillLevelProxy>> findSkillLevelEntries(int firstResult, int maxResults);

    abstract Request<SkillLevelProxy> findSkillLevel(Long id);

    abstract InstanceRequest<SkillLevelProxy, Void> persist();

    abstract InstanceRequest<SkillLevelProxy, Void> remove();
}
