package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.KeywordProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Keyword")
public interface KeywordRequest extends RequestContext {

	//abstract Request<Long> countKeywords();

	//abstract Request<List<KeywordProxy>> findAllKeywords();

	//abstract Request<List<KeywordProxy>> findKeywordEntries(int firstResult, int maxResults);

	//abstract Request<KeywordProxy> findKeyword(Long id);

	//abstract InstanceRequest<KeywordProxy, Void> persist();

	//abstract InstanceRequest<KeywordProxy, Void> remove();
}
