package logbook.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.scaffold.ScaffoldMobileApp;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.AbstractProxyListActivity;
import logbook.client.scaffold.place.ProxyListView;

public class TopicListActivity extends TopicListActivity_Roo_Gwt {

    public TopicListActivity(ApplicationRequestFactory requests, ProxyListView<logbook.client.managed.proxy.TopicProxy> view, PlaceController placeController) {
        super(placeController, view, TopicProxy.class);
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
        return "Topics";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<logbook.client.managed.proxy.TopicProxy>> createRangeRequest(Range range) {
        return requests.topicRequest().findTopicEntries(range.getStart(), range.getLength());
    }
}