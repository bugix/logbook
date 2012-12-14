package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.request.ApplicationEntityTypesProcessor;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.MainClassificationListView;
import logbook.client.managed.ui.MainClassificationMobileListView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.ProxyListPlace;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
