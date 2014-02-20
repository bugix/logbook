// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.logbook.client.managed.request;

import org.springframework.roo.addon.gwt.RooGwtRequest;

import ch.unibas.medizin.logbook.client.managed.proxy.KeywordProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@RooGwtRequest("logbook.server.domain.Keyword")
@ServiceName("logbook.server.domain.Keyword")
public interface KeywordRequest extends RequestContext {

    abstract Request<java.lang.Long> countKeywords();

    abstract Request<java.util.List<KeywordProxy>> findAllKeywords();

    abstract Request<java.util.List<KeywordProxy>> findKeywordEntries(int firstResult, int maxResults);

    abstract Request<KeywordProxy> findKeyword(Long id);

    abstract InstanceRequest<KeywordProxy, java.lang.Void> persist();

    abstract InstanceRequest<KeywordProxy, java.lang.Void> remove();
}
