package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.Set;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;

public class SkillLevelProxyRenderer extends ProxyRenderer<SkillLevelProxy> {

    private static logbook.client.managed.ui.SkillLevelProxyRenderer INSTANCE;

    protected SkillLevelProxyRenderer() {
        super(new String[] { "id" });
    }

    public static logbook.client.managed.ui.SkillLevelProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SkillLevelProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SkillLevelProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}
