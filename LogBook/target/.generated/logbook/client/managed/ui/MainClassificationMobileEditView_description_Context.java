package logbook.client.managed.ui;

public class MainClassificationMobileEditView_description_Context extends com.google.gwt.editor.client.impl.AbstractEditorContext<java.lang.String> {
  private final logbook.client.managed.proxy.MainClassificationProxy parent;
  public MainClassificationMobileEditView_description_Context(logbook.client.managed.proxy.MainClassificationProxy parent, com.google.gwt.editor.client.Editor<java.lang.String> editor, String path) {
    super(editor,path);
    this.parent = parent;
  }
  @Override public boolean canSetInModel() {
    return parent != null && true && true;
  }
  @Override public java.lang.String checkAssignment(Object value) {
    return (java.lang.String) value;
  }
  @Override public Class getEditedType() { return java.lang.String.class; }
  @Override public java.lang.String getFromModel() {
    return (parent != null && true) ? parent.getDescription() : null;
  }
  @Override public void setInModel(java.lang.String data) {
    parent.setDescription(data);
  }
}
