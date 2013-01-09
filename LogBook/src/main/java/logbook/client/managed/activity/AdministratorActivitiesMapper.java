package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import logbook.client.managed.proxy.AdministratorProxy;
import logbook.client.managed.request.AdministratorRequest;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.AdministratorDetailsView;
import logbook.client.managed.ui.AdministratorEditView;
import logbook.client.managed.ui.AdministratorListView;
import logbook.client.managed.ui.AdministratorMobileDetailsView;
import logbook.client.managed.ui.AdministratorMobileEditView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class AdministratorActivitiesMapper extends AdministratorActivitiesMapper_Roo_Gwt {

    public AdministratorActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new AdministratorDetailsActivity((EntityProxyId<AdministratorProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? AdministratorMobileDetailsView.instance() : AdministratorDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
