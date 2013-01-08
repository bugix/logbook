package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.Set;
import logbook.client.managed.proxy.KeywordProxy;
import logbook.client.managed.proxy.SkillProxy;

public class KeywordProxyRenderer extends ProxyRenderer<KeywordProxy> {

    private static logbook.client.managed.ui.KeywordProxyRenderer INSTANCE;

    protected KeywordProxyRenderer() {
        super(new String[] { "name" });
    }

    public static logbook.client.managed.ui.KeywordProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new KeywordProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(KeywordProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
