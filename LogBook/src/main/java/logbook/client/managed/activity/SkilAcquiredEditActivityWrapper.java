package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import logbook.client.managed.proxy.SkilAcquiredProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.ProxyEditView;
import logbook.client.scaffold.place.ProxyListPlace;
import logbook.client.scaffold.place.ProxyPlace;

public class SkilAcquiredEditActivityWrapper extends SkilAcquiredEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<SkilAcquiredProxy> proxyId;

    public SkilAcquiredEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<logbook.client.managed.proxy.SkilAcquiredProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(SkilAcquiredProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New SkilAcquired" : "Edit SkilAcquired";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends logbook.client.scaffold.place.ProxyEditView<logbook.client.managed.proxy.SkilAcquiredProxy, V>> extends ProxyEditView<SkilAcquiredProxy, V> {
    }
}