package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.List;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;

public class TopicProxyRenderer extends ProxyRenderer<TopicProxy> {

    private static logbook.client.managed.ui.TopicProxyRenderer INSTANCE;

    protected TopicProxyRenderer() {
        super(new String[] { "topicDescription" });
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
        return object.getTopicDescription() + " (" + object.getTopicDescription() + ")";
    }
}
