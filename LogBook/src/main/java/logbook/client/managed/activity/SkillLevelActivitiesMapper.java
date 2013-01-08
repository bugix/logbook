package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.SkillLevelRequest;
import logbook.client.managed.ui.SkillAcquiredSetEditor;
import logbook.client.managed.ui.SkillLevelDetailsView;
import logbook.client.managed.ui.SkillLevelEditView;
import logbook.client.managed.ui.SkillLevelListView;
import logbook.client.managed.ui.SkillLevelMobileDetailsView;
import logbook.client.managed.ui.SkillLevelMobileEditView;
import logbook.client.managed.ui.SkillSetEditor;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class SkillLevelActivitiesMapper extends SkillLevelActivitiesMapper_Roo_Gwt {

    public SkillLevelActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new SkillLevelDetailsActivity((EntityProxyId<SkillLevelProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? SkillLevelMobileDetailsView.instance() : SkillLevelDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
