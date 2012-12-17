// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("logbook.server.domain.Keyword")
@ServiceName("logbook.server.domain.Keyword")
public interface KeywordRequest extends RequestContext {

    abstract Request<java.lang.Long> countKeywords();

    abstract Request<java.util.List<logbook.client.managed.proxy.KeywordProxy>> findAllKeywords();

    abstract Request<java.util.List<logbook.client.managed.proxy.KeywordProxy>> findKeywordEntries(int firstResult, int maxResults);

    abstract Request<logbook.client.managed.proxy.KeywordProxy> findKeyword(Long id);

    abstract InstanceRequest<logbook.client.managed.proxy.KeywordProxy, java.lang.Void> persist();

    abstract InstanceRequest<logbook.client.managed.proxy.KeywordProxy, java.lang.Void> remove();
}
