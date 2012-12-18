// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.ui;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import java.util.HashSet;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.scaffold.ScaffoldMobileApp;
import logbook.client.scaffold.ui.MobileProxyListView;

public abstract class SkillLevelMobileListView_Roo_Gwt extends MobileProxyListView<SkillLevelProxy> {

    protected Set<String> paths = new HashSet<String>();

    public SkillLevelMobileListView_Roo_Gwt(String buttonText, SafeHtmlRenderer<logbook.client.managed.proxy.SkillLevelProxy> renderer) {
        super(buttonText, renderer);
    }

    public void init() {
        paths.add("id");
        paths.add("levelNumber");
    }
}