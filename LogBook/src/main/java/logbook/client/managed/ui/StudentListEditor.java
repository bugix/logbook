package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.ui.StudentListEditor.NameLabel;
import logbook.client.scaffold.ui.CollectionRenderer;
import logbook.shared.Gender;
import logbook.shared.StudentStatus;
import logbook.shared.StudyYears;

public class StudentListEditor extends StudentListEditor_Roo_Gwt {

    @UiField
    FlowPanel container;

    @UiField(provided = true)
    @Ignore
    ValueListBox<StudentProxy> picker = new ValueListBox<StudentProxy>(logbook.client.managed.ui.StudentProxyRenderer.instance(), new com.google.web.bindery.requestfactory.gwt.ui.client.EntityProxyKeyProvider<StudentProxy>());

    @UiField
    Button add;

    @UiField
    HTMLPanel editorPanel;

    @UiField
    Button clickToEdit;

    @UiField
    HTMLPanel viewPanel;

    @UiField
    Label viewLabel;

    @UiField
    Style style;

    boolean editing = false;

    private List<StudentProxy> values;

    private final List<StudentProxy> displayedList;

    public StudentListEditor() {
        initWidget(GWT.<Binder>create(Binder.class).createAndBindUi(this));
        Driver driver = GWT.<Driver>create(Driver.class);
        ListEditor<StudentProxy, NameLabel> listEditor = ListEditor.of(new NameLabelSource());
        driver.initialize(listEditor);
        driver.display(new ArrayList<StudentProxy>());
        displayedList = listEditor.getList();
        editing = false;
    }

    @UiHandler("add")
    public void addClicked(ClickEvent e) {
        if (picker.getValue() == null) {
            return;
        }
        for (StudentProxy proxy : displayedList) {
            if (proxy.getStudentId().equals(picker.getValue().getStudentId())) {
                return;
            }
        }
        displayedList.add(picker.getValue());
        viewLabel.setText(makeFlatList(displayedList));
    }

    @UiHandler("clickToEdit")
    public void clickToEditClicked(ClickEvent e) {
        toggleEditorMode();
    }

    @Override
    public void flush() {
    }

    @Override
    public List<logbook.client.managed.proxy.StudentProxy> getValue() {
        if (values == null && displayedList.size() == 0) {
            return null;
        }
        return new ArrayList<StudentProxy>(displayedList);
    }

    public void onLoad() {
        makeEditable(false);
    }

    @Override
    public void onPropertyChange(String... strings) {
    }

    public void setAcceptableValues(Collection<logbook.client.managed.proxy.StudentProxy> proxies) {
        picker.setAcceptableValues(proxies);
    }

    @Override
    public void setDelegate(EditorDelegate<java.util.List<logbook.client.managed.proxy.StudentProxy>> editorDelegate) {
    }

    @Override
    public void setValue(List<logbook.client.managed.proxy.StudentProxy> values) {
        this.values = values;
        makeEditable(editing = false);
        if (displayedList != null) {
            displayedList.clear();
            if (values != null) {
                for (StudentProxy e : values) {
                    displayedList.add(e);
                }
            }
        }
        viewLabel.setText(makeFlatList(values));
    }

    private void makeEditable(boolean editable) {
        if (editable) {
            editorPanel.setStylePrimaryName(style.editorPanelVisible());
            viewPanel.setStylePrimaryName(style.viewPanelHidden());
            clickToEdit.setText("Done");
        } else {
            editorPanel.setStylePrimaryName(style.editorPanelHidden());
            viewPanel.setStylePrimaryName(style.viewPanelVisible());
            clickToEdit.setText("Edit");
        }
    }

    private String makeFlatList(Collection<logbook.client.managed.proxy.StudentProxy> values) {
        return CollectionRenderer.of(logbook.client.managed.ui.StudentProxyRenderer.instance()).render(values);
    }

    private void toggleEditorMode() {
        editing = !editing;
        makeEditable(editing);
    }

    interface Binder extends UiBinder<Widget, StudentListEditor> {
    }

    interface Driver extends RequestFactoryEditorDriver<List<StudentProxy>, ListEditor<StudentProxy, NameLabel>> {
    }

    class NameLabel extends Composite implements LeafValueEditor<StudentProxy> {

        final Label studentIdEditor = new Label();

        private StudentProxy proxy = null;

        public NameLabel() {
            this(null);
        }

        public NameLabel(EventBus eventBus) {
            initWidget(studentIdEditor);
        }

        public void setValue(StudentProxy proxy) {
            this.proxy = proxy;
            studentIdEditor.setText(logbook.client.managed.ui.StudentProxyRenderer.instance().render(proxy));
        }

        @Override
        public StudentProxy getValue() {
            return proxy;
        }
    }

    interface Style extends CssResource {

        String editorPanelHidden();

        String editorPanelVisible();

        String viewPanelHidden();

        String viewPanelVisible();
    }

    private class NameLabelSource extends EditorSource<NameLabel> {

        @Override
        public NameLabel create(int index) {
            NameLabel label = new NameLabel();
            container.insert(label, index);
            return label;
        }

        @Override
        public void dispose(NameLabel subEditor) {
            subEditor.removeFromParent();
        }

        @Override
        public void setIndex(NameLabel editor, int index) {
            container.insert(editor, index);
        }
    }
}
