// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

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
import java.util.Set;
import logbook.client.managed.activity.MainClassificationEditActivityWrapper.View;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.ClassificationTopicSetEditor;
import logbook.client.scaffold.activity.IsScaffoldMobileActivity;
import logbook.client.scaffold.place.ProxyEditView;
import logbook.client.scaffold.place.ProxyListPlace;
import logbook.client.scaffold.place.ProxyPlace;

public abstract class MainClassificationEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setClassificationTopicsPickerValues(Collections.<ClassificationTopicProxy>emptyList());
        requests.classificationTopicRequest().findClassificationTopicEntries(0, 50).with(logbook.client.managed.ui.ClassificationTopicProxyRenderer.instance().getPaths()).fire(new Receiver<List<ClassificationTopicProxy>>() {

            public void onSuccess(List<ClassificationTopicProxy> response) {
                List<ClassificationTopicProxy> values = new ArrayList<ClassificationTopicProxy>();
                values.add(null);
                values.addAll(response);
                view.setClassificationTopicsPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }
}