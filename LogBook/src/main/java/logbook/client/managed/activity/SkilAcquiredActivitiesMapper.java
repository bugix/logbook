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

public class SkilAcquiredActivitiesMapper extends SkilAcquiredActivitiesMapper_Roo_Gwt {

    public SkilAcquiredActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new SkilAcquiredDetailsActivity((EntityProxyId<SkilAcquiredProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? SkilAcquiredMobileDetailsView.instance() : SkilAcquiredDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
