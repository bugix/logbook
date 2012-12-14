package logbook.client.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator implements logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle {
  private static ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator _instance0 = new ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator();
  private void gwtLogoInitializer() {
    gwtLogo = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "gwtLogo",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      38, 0, 22, 20, false, false
    );
  }
  private static class gwtLogoInitializer {
    static {
      _instance0.gwtLogoInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return gwtLogo;
    }
  }
  public com.google.gwt.resources.client.ImageResource gwtLogo() {
    return gwtLogoInitializer.get();
  }
  private void rooLogoInitializer() {
    rooLogo = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "rooLogo",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(bundledImage_None),
      0, 0, 38, 20, false, false
    );
  }
  private static class rooLogoInitializer {
    static {
      _instance0.rooLogoInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return rooLogo;
    }
  }
  public com.google.gwt.resources.client.ImageResource rooLogo() {
    return rooLogoInitializer.get();
  }
  private void styleInitializer() {
    style = new logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBHJ{color:" + ("gray")  + ";}.GAK-4ALBEJ{overflow:" + ("auto")  + ";}.GAK-4ALBDJ{background-color:" + ("#777")  + ";-moz-border-radius-topleft:" + ("10px")  + ";-webkit-border-top-right-radius:" + ("10px")  + ";-moz-border-radius-topright:" + ("10px")  + ";-webkit-border-top-left-radius:" + ("10px")  + ";margin-top:" + ("1.5em")  + ";height:" + ("4em")  + ";}.GAK-4ALBAK{color:" + ("white")  + ";padding:") + (("1em")  + ";position:" + ("absolute")  + ";color:" + ("#def")  + ";}.GAK-4ALBAK h2{margin:" + ("0")  + ";}.GAK-4ALBLJ{position:" + ("absolute")  + ";right:" + ("12%")  + ";left:" + ("12%")  + ";text-align:" + ("center")  + ";background-color:" + ("red")  + ";}.GAK-4ALBNJ{position:" + ("absolute")  + ";right:" + ("75%") ) + (";left:" + ("0")  + ";text-align:" + ("center")  + ";color:" + ("#def")  + ";}.GAK-4ALBBK{position:" + ("absolute")  + ";left:" + ("0")  + ";}.GAK-4ALBFJ{width:" + ("850px")  + ";margin-left:" + ("auto")  + ";margin-right:" + ("auto")  + ";}.GAK-4ALBGJ{position:" + ("relative")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";overflow-y:") + (("auto")  + ";overflow-x:" + ("hidden")  + ";-moz-border-radius-bottomleft:" + ("10px")  + ";-webkit-border-bottom-right-radius:" + ("10px")  + ";-moz-border-radius-bottomright:" + ("10px")  + ";-webkit-border-bottom-left-radius:" + ("10px")  + ";}.GAK-4ALBIJ{position:" + ("absolute")  + ";right:" + ("0")  + ";top:" + ("0")  + ";bottom:" + ("0")  + ";width:" + ("11em") ) + (";}.GAK-4ALBJJ{border-left:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";height:" + ("100%")  + ";outline:" + ("none")  + ";}.GAK-4ALBJJ>div>div{padding-right:" + ("1em")  + ";padding-top:" + ("5px")  + ";padding-bottom:" + ("5px")  + ";}.GAK-4ALBKJ{margin-right:" + ("11em")  + ";}.GAK-4ALBMJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:") + (("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getTop() + "px  no-repeat")  + ";float:" + ("left")  + ";}.GAK-4ALBPJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getTop() + "px  no-repeat")  + ";float:" + ("left")  + ";}.GAK-4ALBOJ{color:" + ("#aaa")  + ";font-size:" + ("0.8em")  + ";width:" + ("160px")  + ";margin-right:" + ("auto") ) + (";margin-left:" + ("auto")  + ";text-align:" + ("left")  + ";}")) : ((".GAK-4ALBHJ{color:" + ("gray")  + ";}.GAK-4ALBEJ{overflow:" + ("auto")  + ";}.GAK-4ALBDJ{background-color:" + ("#777")  + ";-moz-border-radius-topleft:" + ("10px")  + ";-webkit-border-top-left-radius:" + ("10px")  + ";-moz-border-radius-topright:" + ("10px")  + ";-webkit-border-top-right-radius:" + ("10px")  + ";margin-top:" + ("1.5em")  + ";height:" + ("4em")  + ";}.GAK-4ALBAK{color:" + ("white")  + ";padding:") + (("1em")  + ";position:" + ("absolute")  + ";color:" + ("#def")  + ";}.GAK-4ALBAK h2{margin:" + ("0")  + ";}.GAK-4ALBLJ{position:" + ("absolute")  + ";left:" + ("12%")  + ";right:" + ("12%")  + ";text-align:" + ("center")  + ";background-color:" + ("red")  + ";}.GAK-4ALBNJ{position:" + ("absolute")  + ";left:" + ("75%") ) + (";right:" + ("0")  + ";text-align:" + ("center")  + ";color:" + ("#def")  + ";}.GAK-4ALBBK{position:" + ("absolute")  + ";right:" + ("0")  + ";}.GAK-4ALBFJ{width:" + ("850px")  + ";margin-right:" + ("auto")  + ";margin-left:" + ("auto")  + ";}.GAK-4ALBGJ{position:" + ("relative")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";overflow-y:") + (("auto")  + ";overflow-x:" + ("hidden")  + ";-moz-border-radius-bottomleft:" + ("10px")  + ";-webkit-border-bottom-left-radius:" + ("10px")  + ";-moz-border-radius-bottomright:" + ("10px")  + ";-webkit-border-bottom-right-radius:" + ("10px")  + ";}.GAK-4ALBIJ{position:" + ("absolute")  + ";left:" + ("0")  + ";top:" + ("0")  + ";bottom:" + ("0")  + ";width:" + ("11em") ) + (";}.GAK-4ALBJJ{border-right:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";height:" + ("100%")  + ";outline:" + ("none")  + ";}.GAK-4ALBJJ>div>div{padding-left:" + ("1em")  + ";padding-top:" + ("5px")  + ";padding-bottom:" + ("5px")  + ";}.GAK-4ALBKJ{margin-left:" + ("11em")  + ";}.GAK-4ALBMJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:") + (("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.gwtLogo()).getTop() + "px  no-repeat")  + ";float:" + ("right")  + ";}.GAK-4ALBPJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_StaticClientBundleGenerator.this.rooLogo()).getTop() + "px  no-repeat")  + ";float:" + ("right")  + ";}.GAK-4ALBOJ{color:" + ("#aaa")  + ";font-size:" + ("0.8em")  + ";width:" + ("160px")  + ";margin-left:" + ("auto") ) + (";margin-right:" + ("auto")  + ";text-align:" + ("right")  + ";}"));
      }
      public java.lang.String banner(){
        return "GAK-4ALBDJ";
      }
      public java.lang.String body(){
        return "GAK-4ALBEJ";
      }
      public java.lang.String centered(){
        return "GAK-4ALBFJ";
      }
      public java.lang.String content(){
        return "GAK-4ALBGJ";
      }
      public java.lang.String disabled(){
        return "GAK-4ALBHJ";
      }
      public java.lang.String entities(){
        return "GAK-4ALBIJ";
      }
      public java.lang.String entitiesList(){
        return "GAK-4ALBJJ";
      }
      public java.lang.String entityDetails(){
        return "GAK-4ALBKJ";
      }
      public java.lang.String error(){
        return "GAK-4ALBLJ";
      }
      public java.lang.String gwtLogo(){
        return "GAK-4ALBMJ";
      }
      public java.lang.String login(){
        return "GAK-4ALBNJ";
      }
      public java.lang.String logos(){
        return "GAK-4ALBOJ";
      }
      public java.lang.String rooLogo(){
        return "GAK-4ALBPJ";
      }
      public java.lang.String title(){
        return "GAK-4ALBAK";
      }
      public java.lang.String users(){
        return "GAK-4ALBBK";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseForStaticFiles() + "FF1AF23C6C21FE5AB5CC0016DE2BF803.cache.png";
  private static com.google.gwt.resources.client.ImageResource gwtLogo;
  private static com.google.gwt.resources.client.ImageResource rooLogo;
  private static logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      gwtLogo(), 
      rooLogo(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("gwtLogo", gwtLogo());
        resourceMap.put("rooLogo", rooLogo());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'gwtLogo': return this.@logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle::gwtLogo()();
      case 'rooLogo': return this.@logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle::rooLogo()();
      case 'style': return this.@logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
