package logbook.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.SkillAcquiredSetEditor;
import logbook.client.scaffold.ScaffoldMobileApp;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.AbstractProxyListActivity;
import logbook.client.scaffold.place.ProxyListView;
import logbook.shared.Gender;
import logbook.shared.StudentStatus;
import logbook.shared.StudyYears;

public class StudentListActivity extends StudentListActivity_Roo_Gwt {

    public StudentListActivity(ApplicationRequestFactory requests, ProxyListView<logbook.client.managed.proxy.StudentProxy> view, PlaceController placeController) {
        super(placeController, view, StudentProxy.class);
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
        return "Students";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<logbook.client.managed.proxy.StudentProxy>> createRangeRequest(Range range) {
        return requests.studentRequest().findStudentEntries(range.getStart(), range.getLength());
    }
}
