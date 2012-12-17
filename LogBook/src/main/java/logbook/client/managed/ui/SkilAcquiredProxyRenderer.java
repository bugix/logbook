package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import logbook.client.managed.proxy.SkilAcquiredProxy;

public class SkilAcquiredProxyRenderer extends ProxyRenderer<SkilAcquiredProxy> {

    private static logbook.client.managed.ui.SkilAcquiredProxyRenderer INSTANCE;

    protected SkilAcquiredProxyRenderer() {
        super(new String[] { "id" });
    }

    public static logbook.client.managed.ui.SkilAcquiredProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SkilAcquiredProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SkilAcquiredProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}
