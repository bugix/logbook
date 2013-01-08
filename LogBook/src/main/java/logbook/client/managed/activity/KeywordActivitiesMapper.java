package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import logbook.client.managed.proxy.KeywordProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.KeywordRequest;
import logbook.client.managed.ui.KeywordDetailsView;
import logbook.client.managed.ui.KeywordEditView;
import logbook.client.managed.ui.KeywordListView;
import logbook.client.managed.ui.KeywordMobileDetailsView;
import logbook.client.managed.ui.KeywordMobileEditView;
import logbook.client.managed.ui.SkillSetEditor;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;

public class KeywordActivitiesMapper extends KeywordActivitiesMapper_Roo_Gwt {

    public KeywordActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new KeywordDetailsActivity((EntityProxyId<KeywordProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? KeywordMobileDetailsView.instance() : KeywordDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
