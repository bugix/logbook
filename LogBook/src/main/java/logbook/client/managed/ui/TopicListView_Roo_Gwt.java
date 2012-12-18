// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import java.util.HashSet;
import java.util.Set;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.scaffold.place.AbstractProxyListView;

public abstract class TopicListView_Roo_Gwt extends AbstractProxyListView<TopicProxy> {

    @UiField
    CellTable<TopicProxy> table;

    protected Set<String> paths = new HashSet<String>();

    public void init() {
        paths.add("id");
        table.addColumn(new TextColumn<TopicProxy>() {

            Renderer<java.lang.Long> renderer = new AbstractRenderer<java.lang.Long>() {

                public String render(java.lang.Long obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TopicProxy object) {
                return renderer.render(object.getId());
            }
        }, "Id");
        paths.add("topicDescription");
        table.addColumn(new TextColumn<TopicProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TopicProxy object) {
                return renderer.render(object.getTopicDescription());
            }
        }, "Topic Description");
        paths.add("skills");
        table.addColumn(new TextColumn<TopicProxy>() {

            Renderer<java.util.Set> renderer = logbook.client.scaffold.place.CollectionRenderer.of(logbook.client.managed.ui.SkillProxyRenderer.instance());

            @Override
            public String getValue(TopicProxy object) {
                return renderer.render(object.getSkills());
            }
        }, "Skills");
        paths.add("classificationTopic");
        table.addColumn(new TextColumn<TopicProxy>() {

            Renderer<logbook.client.managed.proxy.ClassificationTopicProxy> renderer = logbook.client.managed.ui.ClassificationTopicProxyRenderer.instance();

            @Override
            public String getValue(TopicProxy object) {
                return renderer.render(object.getClassificationTopic());
            }
        }, "Classification Topic");
        paths.add("version");
        table.addColumn(new TextColumn<TopicProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TopicProxy object) {
                return renderer.render(object.getVersion());
            }
        }, "Version");
    }
}