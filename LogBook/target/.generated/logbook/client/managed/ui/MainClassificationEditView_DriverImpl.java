package logbook.client.managed.ui;

public class MainClassificationEditView_DriverImpl extends com.google.web.bindery.requestfactory.gwt.client.impl.AbstractRequestFactoryEditorDriver<logbook.client.managed.proxy.MainClassificationProxy, logbook.client.managed.ui.MainClassificationEditView> implements logbook.client.managed.ui.MainClassificationEditView.Driver {
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
    com.google.gwt.editor.client.impl.RootEditorContext ctx = new com.google.gwt.editor.client.impl.RootEditorContext(getDelegate(), logbook.client.managed.proxy.MainClassificationProxy.class, getObject());
    ctx.traverse(visitor, getDelegate());
  }
  @Override protected com.google.web.bindery.requestfactory.gwt.client.impl.RequestFactoryEditorDelegate createDelegate() {
    return new logbook.client.managed.ui.MainClassificationEditView_RequestFactoryEditorDelegate();
  }
}
