package logbook.client.scaffold.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle {
  private static MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void createButtonInitializer() {
    createButton = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "createButton",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 19, 19, false, false
    );
  }
  private static class createButtonInitializer {
    static {
      _instance0.createButtonInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return createButton;
    }
  }
  public com.google.gwt.resources.client.ImageResource createButton() {
    return createButtonInitializer.get();
  }
  private void styleInitializer() {
    style = new logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBGM{height:" + ((MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getHeight() + "px")  + ";width:" + ((MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getSafeUri().asString() + "\") -" + (MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getLeft() + "px -" + (MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getTop() + "px  no-repeat")  + ";border:" + ("0")  + ";margin:" + ("9px"+ " " +"9px"+ " " +"9px"+ " " +"0")  + ";width:" + ("12em")  + ";font-size:" + ("12pt")  + ";cursor:" + ("pointer")  + ";text-align:" + ("right")  + ";padding-right:") + (("22px")  + ";color:" + ("#6a779a")  + ";}.GAK-4ALBHM{border-top:" + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";}")) : ((".GAK-4ALBGM{height:" + ((MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getHeight() + "px")  + ";width:" + ((MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getSafeUri().asString() + "\") -" + (MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getLeft() + "px -" + (MobileProxyListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getTop() + "px  no-repeat")  + ";border:" + ("0")  + ";margin:" + ("9px"+ " " +"0"+ " " +"9px"+ " " +"9px")  + ";width:" + ("12em")  + ";font-size:" + ("12pt")  + ";cursor:" + ("pointer")  + ";text-align:" + ("left")  + ";padding-left:") + (("22px")  + ";color:" + ("#6a779a")  + ";}.GAK-4ALBHM{border-top:" + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";}"));
      }
      public java.lang.String createButton(){
        return "GAK-4ALBGM";
      }
      public java.lang.String list(){
        return "GAK-4ALBHM";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseForStaticFiles() + "9CD64767FC975D4C997C8753923A8922.cache.png";
  private static com.google.gwt.resources.client.ImageResource createButton;
  private static logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      createButton(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("createButton", createButton());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'createButton': return this.@logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle::createButton()();
      case 'style': return this.@logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
