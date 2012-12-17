package logbook.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;
import java.util.Set;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.ClassificationTopicSetEditor;
import logbook.client.scaffold.ScaffoldMobileApp;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.AbstractProxyListActivity;
import logbook.client.scaffold.place.ProxyListView;

public class MainClassificationListActivity extends MainClassificationListActivity_Roo_Gwt {

    public MainClassificationListActivity(ApplicationRequestFactory requests, ProxyListView<logbook.client.managed.proxy.MainClassificationProxy> view, PlaceController placeController) {
        super(placeController, view, MainClassificationProxy.class);
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
        return "MainClassifications";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> createRangeRequest(Range range) {
        return requests.mainClassificationRequest().findMainClassificationEntries(range.getStart(), range.getLength());
    }
}
