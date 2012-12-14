package com.google.gwt.user.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class NotificationMole_BinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle {
  private static NotificationMole_BinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new NotificationMole_BinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBMK{position:" + ("absolute")  + ";height:" + ("0")  + ";text-align:" + ("center")  + ";width:" + ("100%")  + ";}.GAK-4ALBLK{margin-right:" + ("auto")  + ";margin-left:" + ("auto")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#96a2b5")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#96a2b5")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#96a2b5")  + ";background-color:" + ("#e5edf9")  + ";padding:") + (("5px")  + ";overflow:" + ("hidden")  + ";display:" + ("inline-block")  + ";}.GAK-4ALBNK{font-family:" + ("Helvetica")  + ";font-size:" + ("1em")  + ";}")) : ((".GAK-4ALBMK{position:" + ("absolute")  + ";height:" + ("0")  + ";text-align:" + ("center")  + ";width:" + ("100%")  + ";}.GAK-4ALBLK{margin-left:" + ("auto")  + ";margin-right:" + ("auto")  + ";border-left:" + ("1px"+ " " +"solid"+ " " +"#96a2b5")  + ";border-right:" + ("1px"+ " " +"solid"+ " " +"#96a2b5")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#96a2b5")  + ";background-color:" + ("#e5edf9")  + ";padding:") + (("5px")  + ";overflow:" + ("hidden")  + ";display:" + ("inline-block")  + ";}.GAK-4ALBNK{font-family:" + ("Helvetica")  + ";font-size:" + ("1em")  + ";}"));
      }
      public java.lang.String centered(){
        return "GAK-4ALBLK";
      }
      public java.lang.String container(){
        return "GAK-4ALBMK";
      }
      public java.lang.String notificationText(){
        return "GAK-4ALBNK";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
