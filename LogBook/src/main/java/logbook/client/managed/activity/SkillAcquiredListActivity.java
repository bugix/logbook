package logbook.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.scaffold.ScaffoldMobileApp;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.AbstractProxyListActivity;
import logbook.client.scaffold.place.ProxyListView;

public class SkillAcquiredListActivity extends SkillAcquiredListActivity_Roo_Gwt {

    public SkillAcquiredListActivity(ApplicationRequestFactory requests, ProxyListView<logbook.client.managed.proxy.SkillAcquiredProxy> view, PlaceController placeController) {
        super(placeController, view, SkillAcquiredProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "SkillAcquireds";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<logbook.client.managed.proxy.SkillAcquiredProxy>> createRangeRequest(Range range) {
        return requests.skillAcquiredRequest().findSkillAcquiredEntries(range.getStart(), range.getLength());
    }
}
