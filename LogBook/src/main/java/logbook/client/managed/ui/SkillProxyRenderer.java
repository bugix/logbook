package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;

public class SkillProxyRenderer extends ProxyRenderer<SkillProxy> {

    private static logbook.client.managed.ui.SkillProxyRenderer INSTANCE;

    protected SkillProxyRenderer() {
        super(new String[] { "description" });
    }

    public static logbook.client.managed.ui.SkillProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SkillProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SkillProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
