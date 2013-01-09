package logbook.client.managed.activity;

import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.SkillDetailsView;
import logbook.client.managed.ui.SkillMobileDetailsView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.ProxyPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;

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
