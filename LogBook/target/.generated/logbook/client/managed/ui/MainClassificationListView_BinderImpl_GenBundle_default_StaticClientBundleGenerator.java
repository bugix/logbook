package logbook.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle {
  private static MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
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
    style = new logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBML{position:" + ("absolute")  + ";right:" + ("0")  + ";left:" + ("0")  + ";top:" + ("3px")  + ";height:" + ("2em")  + ";margin-right:" + ("15px")  + ";}.GAK-4ALBNL{height:" + ((MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getHeight() + "px")  + ";width:" + ((MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getSafeUri().asString() + "\") -" + (MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getLeft() + "px -" + (MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getTop() + "px  no-repeat")  + ";border:") + (("0")  + ";margin-top:" + ("5px")  + ";width:" + ("12em")  + ";font-size:" + ("1em")  + ";cursor:" + ("pointer")  + ";text-align:" + ("right")  + ";padding-right:" + ("22px")  + ";}.GAK-4ALBML table{position:" + ("absolute")  + ";left:" + ("0")  + ";top:" + ("0")  + ";}.GAK-4ALBML button{display:" + ("inline") ) + (";}.GAK-4ALBOL{position:" + ("relative")  + ";}.GAK-4ALBOL>table{table-layout:" + ("fixed")  + ";}.GAK-4ALBOL>table td{text-overflow:" + ("ellipsis")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";cursor:" + ("pointer")  + ";}")) : ((".GAK-4ALBML{position:" + ("absolute")  + ";left:" + ("0")  + ";right:" + ("0")  + ";top:" + ("3px")  + ";height:" + ("2em")  + ";margin-left:" + ("15px")  + ";}.GAK-4ALBNL{height:" + ((MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getHeight() + "px")  + ";width:" + ((MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getSafeUri().asString() + "\") -" + (MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getLeft() + "px -" + (MainClassificationListView_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.createButton()).getTop() + "px  no-repeat")  + ";border:") + (("0")  + ";margin-top:" + ("5px")  + ";width:" + ("12em")  + ";font-size:" + ("1em")  + ";cursor:" + ("pointer")  + ";text-align:" + ("left")  + ";padding-left:" + ("22px")  + ";}.GAK-4ALBML table{position:" + ("absolute")  + ";right:" + ("0")  + ";top:" + ("0")  + ";}.GAK-4ALBML button{display:" + ("inline") ) + (";}.GAK-4ALBOL{position:" + ("relative")  + ";}.GAK-4ALBOL>table{table-layout:" + ("fixed")  + ";}.GAK-4ALBOL>table td{text-overflow:" + ("ellipsis")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";cursor:" + ("pointer")  + ";}"));
      }
      public java.lang.String controls(){
        return "GAK-4ALBML";
      }
      public java.lang.String createButton(){
        return "GAK-4ALBNL";
      }
      public java.lang.String listView(){
        return "GAK-4ALBOL";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseForStaticFiles() + "9CD64767FC975D4C997C8753923A8922.cache.png";
  private static com.google.gwt.resources.client.ImageResource createButton;
  private static logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style style;
  
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
      case 'createButton': return this.@logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle::createButton()();
      case 'style': return this.@logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
