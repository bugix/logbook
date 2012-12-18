// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.Set;
import logbook.client.managed.proxy.KeywordProxy;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.scaffold.place.ProxyDetailsView;

public abstract class SkillMobileDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<SkillProxy> {

    @UiField
    Element id;

    @UiField
    Element description;

    @UiField
    Element shortcut;

    @UiField
    Element topic;

    @UiField
    Element skillLevel;

    @UiField
    Element skillsAcquired;

    @UiField
    Element keywords;

    @UiField
    Element version;

    SkillProxy proxy;

    public void setValue(SkillProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        description.setInnerText(proxy.getDescription() == null ? "" : String.valueOf(proxy.getDescription()));
        shortcut.setInnerText(proxy.getShortcut() == null ? "" : String.valueOf(proxy.getShortcut()));
        topic.setInnerText(proxy.getTopic() == null ? "" : logbook.client.managed.ui.TopicProxyRenderer.instance().render(proxy.getTopic()));
        skillLevel.setInnerText(proxy.getSkillLevel() == null ? "" : logbook.client.managed.ui.SkillLevelProxyRenderer.instance().render(proxy.getSkillLevel()));
        skillsAcquired.setInnerText(proxy.getSkillsAcquired() == null ? "" : logbook.client.scaffold.place.CollectionRenderer.of(logbook.client.managed.ui.SkillAcquiredProxyRenderer.instance()).render(proxy.getSkillsAcquired()));
        keywords.setInnerText(proxy.getKeywords() == null ? "" : logbook.client.scaffold.place.CollectionRenderer.of(logbook.client.managed.ui.KeywordProxyRenderer.instance()).render(proxy.getKeywords()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
    }
}