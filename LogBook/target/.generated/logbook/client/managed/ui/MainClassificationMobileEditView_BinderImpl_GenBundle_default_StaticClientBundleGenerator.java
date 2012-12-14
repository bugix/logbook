package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MainClassificationMobileEditView_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements logbook.client.managed.ui.MainClassificationMobileEditView_BinderImpl_GenBundle {
  private static MainClassificationMobileEditView_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new MainClassificationMobileEditView_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new logbook.client.managed.ui.MainClassificationMobileEditView_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBEM{padding:" + ("10px")  + ";}.GAK-4ALBCM{padding-right:" + ("0.5em")  + ";background-color:" + ("red")  + ";}.GAK-4ALBDM{font-weight:" + ("bold")  + ";}.GAK-4ALBFM{padding-bottom:" + ("10px")  + ";}")) : ((".GAK-4ALBEM{padding:" + ("10px")  + ";}.GAK-4ALBCM{padding-left:" + ("0.5em")  + ";background-color:" + ("red")  + ";}.GAK-4ALBDM{font-weight:" + ("bold")  + ";}.GAK-4ALBFM{padding-bottom:" + ("10px")  + ";}"));
      }
      public java.lang.String error(){
        return "GAK-4ALBCM";
      }
      public java.lang.String label(){
        return "GAK-4ALBDM";
      }
      public java.lang.String outer(){
        return "GAK-4ALBEM";
      }
      public java.lang.String value(){
        return "GAK-4ALBFM";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static logbook.client.managed.ui.MainClassificationMobileEditView_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public logbook.client.managed.ui.MainClassificationMobileEditView_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static logbook.client.managed.ui.MainClassificationMobileEditView_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@logbook.client.managed.ui.MainClassificationMobileEditView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
