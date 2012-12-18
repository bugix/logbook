// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import logbook.client.managed.proxy.SkilAcquiredProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.SkilAcquiredRequest;
import logbook.client.managed.ui.SkilAcquiredDetailsView;
import logbook.client.managed.ui.SkilAcquiredEditView;
import logbook.client.managed.ui.SkilAcquiredListView;
import logbook.client.managed.ui.SkilAcquiredMobileDetailsView;
import logbook.client.managed.ui.SkilAcquiredMobileEditView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public abstract class SkilAcquiredActivitiesMapper_Roo_Gwt {

    protected ApplicationRequestFactory requests;

    protected PlaceController placeController;

    protected Activity makeCreateActivity() {
        SkilAcquiredEditView.instance().setCreating(true);
        final SkilAcquiredRequest request = requests.skilAcquiredRequest();
        Activity activity = new CreateAndEditProxy<SkilAcquiredProxy>(SkilAcquiredProxy.class, request, ScaffoldApp.isMobile() ? SkilAcquiredMobileEditView.instance() : SkilAcquiredEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(SkilAcquiredProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new SkilAcquiredEditActivityWrapper(requests, ScaffoldApp.isMobile() ? SkilAcquiredMobileEditView.instance() : SkilAcquiredEditView.instance(), activity, null);
    }

    @SuppressWarnings("unchecked")
    protected EntityProxyId<logbook.client.managed.proxy.SkilAcquiredProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<SkilAcquiredProxy>) place.getProxyId();
    }

    protected Activity makeEditActivity(ProxyPlace place) {
        SkilAcquiredEditView.instance().setCreating(false);
        EntityProxyId<SkilAcquiredProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<SkilAcquiredProxy>(proxyId, requests, ScaffoldApp.isMobile() ? SkilAcquiredMobileEditView.instance() : SkilAcquiredEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(SkilAcquiredProxy proxy) {
                SkilAcquiredRequest request = requests.skilAcquiredRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new SkilAcquiredEditActivityWrapper(requests, ScaffoldApp.isMobile() ? SkilAcquiredMobileEditView.instance() : SkilAcquiredEditView.instance(), activity, proxyId);
    }
}