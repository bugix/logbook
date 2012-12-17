package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;

public class SkillAcquiredProxyRenderer extends ProxyRenderer<SkillAcquiredProxy> {

    private static logbook.client.managed.ui.SkillAcquiredProxyRenderer INSTANCE;

    protected SkillAcquiredProxyRenderer() {
        super(new String[] { "id" });
    }

    public static logbook.client.managed.ui.SkillAcquiredProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SkillAcquiredProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SkillAcquiredProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}
