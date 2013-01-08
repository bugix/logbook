package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import logbook.client.managed.proxy.KeywordProxy;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.KeywordSetEditor;
import logbook.client.managed.ui.SkillAcquiredSetEditor;
import logbook.client.managed.ui.SkillDetailsView;
import logbook.client.managed.ui.SkillEditView;
import logbook.client.managed.ui.SkillListView;
import logbook.client.managed.ui.SkillMobileDetailsView;
import logbook.client.managed.ui.SkillMobileEditView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;
import logbook.shared.scaffold.SkillNonRooRequest;

public class SkillActivitiesMapper extends SkillActivitiesMapper_Roo_Gwt {

    public SkillActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new SkillDetailsActivity((EntityProxyId<SkillProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? SkillMobileDetailsView.instance() : SkillDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
