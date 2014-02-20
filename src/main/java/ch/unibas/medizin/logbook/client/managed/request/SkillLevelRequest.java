// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.SkillLevel")
@ServiceName("logbook.server.domain.SkillLevel")
public interface SkillLevelRequest extends RequestContext {

    abstract Request<java.lang.Long> countSkillLevels();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkillLevelProxy>> findAllSkillLevels();

    abstract Request<java.util.List<logbook.client.managed.proxy.SkillLevelProxy>> findSkillLevelEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.SkillLevelProxy> findSkillLevel(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.SkillLevelProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.SkillLevelProxy, java.lang.Void> remove();
}
