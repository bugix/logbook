package logbook.client.managed.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.Set;
import logbook.client.managed.proxy.AdministratorProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.ProxyDetailsView;
import logbook.client.scaffold.place.ProxyListPlace;
import logbook.client.scaffold.place.ProxyPlace;
import logbook.client.scaffold.place.ProxyPlace.Operation;

public class AdministratorDetailsActivity extends AdministratorDetailsActivity_Roo_Gwt {

    public AdministratorDetailsActivity(EntityProxyId<logbook.client.managed.proxy.AdministratorProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, ProxyDetailsView<logbook.client.managed.proxy.AdministratorProxy> view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(AdministratorProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View Administrator";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((AdministratorProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
