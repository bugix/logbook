package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.SkillAcquiredRequest;
import logbook.client.managed.ui.SkillAcquiredDetailsView;
import logbook.client.managed.ui.SkillAcquiredEditView;
import logbook.client.managed.ui.SkillAcquiredListView;
import logbook.client.managed.ui.SkillAcquiredMobileDetailsView;
import logbook.client.managed.ui.SkillAcquiredMobileEditView;
import logbook.client.managed.ui.SkillSetEditor;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class SkillAcquiredActivitiesMapper extends SkillAcquiredActivitiesMapper_Roo_Gwt {

    public SkillAcquiredActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new SkillAcquiredDetailsActivity((EntityProxyId<SkillAcquiredProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? SkillAcquiredMobileDetailsView.instance() : SkillAcquiredDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
