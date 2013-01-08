package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.List;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.TopicRequest;
import logbook.client.managed.ui.SkillListEditor;
import logbook.client.managed.ui.TopicDetailsView;
import logbook.client.managed.ui.TopicEditView;
import logbook.client.managed.ui.TopicListView;
import logbook.client.managed.ui.TopicMobileDetailsView;
import logbook.client.managed.ui.TopicMobileEditView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class TopicActivitiesMapper extends TopicActivitiesMapper_Roo_Gwt {

    public TopicActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new TopicDetailsActivity((EntityProxyId<TopicProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? TopicMobileDetailsView.instance() : TopicDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
