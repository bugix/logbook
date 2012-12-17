package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.request.StudentRequest;
import logbook.client.managed.ui.StudentDetailsView;
import logbook.client.managed.ui.StudentEditView;
import logbook.client.managed.ui.StudentListView;
import logbook.client.managed.ui.StudentMobileDetailsView;
import logbook.client.managed.ui.StudentMobileEditView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.CreateAndEditProxy;
import logbook.client.scaffold.place.FindAndEditProxy;
import logbook.client.scaffold.place.ProxyPlace;
import logbook.shared.Gender;
import logbook.shared.StudentStatus;
import logbook.shared.StudyYears;

public class StudentActivitiesMapper extends StudentActivitiesMapper_Roo_Gwt {

    public StudentActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new StudentDetailsActivity((EntityProxyId<StudentProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? StudentMobileDetailsView.instance() : StudentDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
