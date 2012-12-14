package logbook.client.scaffold.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class LoginWidget_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements logbook.client.scaffold.ui.LoginWidget_BinderImpl_GenBundle {
  private static LoginWidget_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new LoginWidget_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new logbook.client.scaffold.ui.LoginWidget_BinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return (".GAK-4ALBOK{color:" + ("inherit")  + ";text-decoration:" + ("inherit")  + ";}");
      }
      public java.lang.String link(){
        return "GAK-4ALBOK";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static logbook.client.scaffold.ui.LoginWidget_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public logbook.client.scaffold.ui.LoginWidget_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static logbook.client.scaffold.ui.LoginWidget_BinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@logbook.client.scaffold.ui.LoginWidget_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
