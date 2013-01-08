package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.List;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.ClassificationTopicRequest;
import logbook.client.managed.ui.ClassificationTopicDetailsView;
import logbook.client.managed.ui.ClassificationTopicEditView;
import logbook.client.managed.ui.ClassificationTopicListView;
import logbook.client.managed.ui.ClassificationTopicMobileDetailsView;
import logbook.client.managed.ui.ClassificationTopicMobileEditView;
import logbook.client.managed.ui.TopicListEditor;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class ClassificationTopicActivitiesMapper extends ClassificationTopicActivitiesMapper_Roo_Gwt {

    public ClassificationTopicActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new ClassificationTopicDetailsActivity((EntityProxyId<ClassificationTopicProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? ClassificationTopicMobileDetailsView.instance() : ClassificationTopicDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
