package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import logbook.client.managed.proxy.TopicProxy;

public class TopicProxyRenderer extends ProxyRenderer<TopicProxy> {

    private static logbook.client.managed.ui.TopicProxyRenderer INSTANCE;

    protected TopicProxyRenderer() {
        super(new String[] { "id" });
    }

    public static logbook.client.managed.ui.TopicProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TopicProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TopicProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}
