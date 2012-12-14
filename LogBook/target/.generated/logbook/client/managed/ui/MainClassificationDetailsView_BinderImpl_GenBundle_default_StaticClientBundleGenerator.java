package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MainClassificationDetailsView_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle {
  private static MainClassificationDetailsView_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new MainClassificationDetailsView_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBBL{margin-top:" + ("0.5em")  + ";margin-right:" + ("1em")  + ";}.GAK-4ALBDL{min-height:" + ("25px")  + ";font-weight:" + ("bold")  + ";}.GAK-4ALBAL{margin-left:" + ("1em")  + ";}.GAK-4ALBPK{margin-right:" + ("1em")  + ";}.GAK-4ALBCL{margin-right:" + ("1em")  + ";color:" + ("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";margin-bottom:" + ("0")  + ";}.GAK-4ALBEL{border-bottom:") + (("2px"+ " " +"solid"+ " " +"#6f7277")  + ";}")) : ((".GAK-4ALBBL{margin-top:" + ("0.5em")  + ";margin-left:" + ("1em")  + ";}.GAK-4ALBDL{min-height:" + ("25px")  + ";font-weight:" + ("bold")  + ";}.GAK-4ALBAL{margin-right:" + ("1em")  + ";}.GAK-4ALBPK{margin-left:" + ("1em")  + ";}.GAK-4ALBCL{margin-left:" + ("1em")  + ";color:" + ("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";margin-bottom:" + ("0")  + ";}.GAK-4ALBEL{border-bottom:") + (("2px"+ " " +"solid"+ " " +"#6f7277")  + ";}"));
      }
      public java.lang.String bar(){
        return "GAK-4ALBPK";
      }
      public java.lang.String button(){
        return "GAK-4ALBAL";
      }
      public java.lang.String fields(){
        return "GAK-4ALBBL";
      }
      public java.lang.String header(){
        return "GAK-4ALBCL";
      }
      public java.lang.String label(){
        return "GAK-4ALBDL";
      }
      public java.lang.String underline(){
        return "GAK-4ALBEL";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
