package logbook.client.managed.ui;

public class MainClassificationMobileEditView_RequestFactoryEditorDelegate extends com.google.web.bindery.requestfactory.gwt.client.impl.RequestFactoryEditorDelegate {
  private logbook.client.managed.ui.MainClassificationMobileEditView editor;
  @Override protected logbook.client.managed.ui.MainClassificationMobileEditView getEditor() {return editor;}
  protected void setEditor(com.google.gwt.editor.client.Editor editor) {this.editor=(logbook.client.managed.ui.MainClassificationMobileEditView)editor;}
  private logbook.client.managed.proxy.MainClassificationProxy object;
  @Override public logbook.client.managed.proxy.MainClassificationProxy getObject() {return object;}
  @Override protected void setObject(Object object) {this.object=(logbook.client.managed.proxy.MainClassificationProxy)object;}
  com.google.web.bindery.requestfactory.gwt.client.impl.RequestFactoryEditorDelegate descriptionDelegate;
  @Override protected void initializeSubDelegates() {
    if (editor.description.asEditor() != null) {
      descriptionDelegate = new com.google.gwt.editor.ui.client.adapters.ValueBoxEditor_java_lang_String_RequestFactoryEditorDelegate();
      addSubDelegate(descriptionDelegate, appendPath("description"), editor.description.asEditor());
    }
  }
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
    if (descriptionDelegate != null) 
    {
      logbook.client.managed.ui.MainClassificationMobileEditView_description_Context ctx = new logbook.client.managed.ui.MainClassificationMobileEditView_description_Context(getObject(), editor.description.asEditor(), appendPath("description"));
      ctx.setEditorDelegate(descriptionDelegate);
      ctx.traverse(visitor, descriptionDelegate);
    }
  }
}
