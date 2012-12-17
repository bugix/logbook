package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;

public class ClassificationTopicProxyRenderer extends ProxyRenderer<ClassificationTopicProxy> {

    private static logbook.client.managed.ui.ClassificationTopicProxyRenderer INSTANCE;

    protected ClassificationTopicProxyRenderer() {
        super(new String[] { "description" });
    }

    public static logbook.client.managed.ui.ClassificationTopicProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new ClassificationTopicProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(ClassificationTopicProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
