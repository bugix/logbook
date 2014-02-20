// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "logbook.server.domain.Keyword", locator = "logbook.server.locator.KeywordLocator")
@RooGwtProxy(value = "logbook.server.domain.Keyword", readOnly = { "version", "id" })
public interface KeywordProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract Set<logbook.client.managed.proxy.SkillProxy> getSkill();

    abstract void setSkill(Set<logbook.client.managed.proxy.SkillProxy> skill);

    abstract Integer getVersion();
}
