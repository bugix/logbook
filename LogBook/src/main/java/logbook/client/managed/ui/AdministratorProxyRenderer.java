package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import logbook.client.managed.proxy.AdministratorProxy;

public class AdministratorProxyRenderer extends ProxyRenderer<AdministratorProxy> {

    private static logbook.client.managed.ui.AdministratorProxyRenderer INSTANCE;

    protected AdministratorProxyRenderer() {
        super(new String[] { "email" });
    }

    public static logbook.client.managed.ui.AdministratorProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new AdministratorProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(AdministratorProxy object) {
        if (object == null) {
            return "";
        }
        return object.getEmail() + " (" + object.getEmail() + ")";
    }
}
