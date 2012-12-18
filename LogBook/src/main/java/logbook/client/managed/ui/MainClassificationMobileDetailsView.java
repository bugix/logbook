package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.Set;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.scaffold.place.ProxyDetailsView;

public class MainClassificationMobileDetailsView extends MainClassificationMobileDetailsView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static logbook.client.managed.ui.MainClassificationMobileDetailsView instance;

    @UiField
    HasClickHandlers delete;

    private Delegate delegate;

    public MainClassificationMobileDetailsView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static logbook.client.managed.ui.MainClassificationMobileDetailsView instance() {
        if (instance == null) {
            instance = new MainClassificationMobileDetailsView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public MainClassificationProxy getValue() {
        return proxy;
    }

    @UiHandler("delete")
    public void onDeleteClicked(ClickEvent e) {
        delegate.deleteClicked();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, MainClassificationMobileDetailsView> {
    }
}