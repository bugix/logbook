package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.MainClassificationRequest;
import logbook.client.managed.ui.ClassificationTopicSetEditor;
import logbook.client.managed.ui.MainClassificationDetailsView;
import logbook.client.managed.ui.MainClassificationEditView;
import logbook.client.managed.ui.MainClassificationListView;
import logbook.client.managed.ui.MainClassificationMobileDetailsView;
import logbook.client.managed.ui.MainClassificationMobileEditView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class MainClassificationActivitiesMapper extends MainClassificationActivitiesMapper_Roo_Gwt {

    public MainClassificationActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new MainClassificationDetailsActivity((EntityProxyId<MainClassificationProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? MainClassificationMobileDetailsView.instance() : MainClassificationDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
