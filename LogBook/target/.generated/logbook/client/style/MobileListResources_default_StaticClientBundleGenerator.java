package logbook.client.style;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MobileListResources_default_StaticClientBundleGenerator implements logbook.client.style.MobileListResources {
  private static MobileListResources_default_StaticClientBundleGenerator _instance0 = new MobileListResources_default_StaticClientBundleGenerator();
  private void cellListSelectedBackgroundInitializer() {
    cellListSelectedBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellListSelectedBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_Horizontal_rtl : bundledImage_Horizontal),
      0, 0, 82, 26, false, false
    );
  }
  private static class cellListSelectedBackgroundInitializer {
    static {
      _instance0.cellListSelectedBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellListSelectedBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellListSelectedBackground() {
    return cellListSelectedBackgroundInitializer.get();
  }
  private void cellListStyleInitializer() {
    cellListStyle = new logbook.client.style.MobileListResources.MobileStyle() {
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
        return "cellListStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBMI,.GAK-4ALBOI{cursor:" + ("pointer")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";padding:" + ("10px")  + ";font-weight:" + ("bold")  + ";font-size:" + ("12pt")  + ";}.GAK-4ALBCJ{padding-top:" + ("2px")  + ";color:" + ("#888")  + ";font-size:" + ("10pt")  + ";width:" + ("70%")  + ";overflow:" + ("hidden")  + ";min-height:") + (("10pt")  + ";}.GAK-4ALBBJ{padding-top:" + ("2px")  + ";text-align:" + ("left")  + ";color:" + ("#888")  + ";font-size:" + ("10pt")  + ";overflow:" + ("hidden")  + ";position:" + ("absolute")  + ";top:" + ("0")  + ";left:" + ("10px")  + ";}.gwt-TextBox,.gwt-DateBox{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";padding:" + ("1px") ) + (";}")) : ((".GAK-4ALBMI,.GAK-4ALBOI{cursor:" + ("pointer")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";padding:" + ("10px")  + ";font-weight:" + ("bold")  + ";font-size:" + ("12pt")  + ";}.GAK-4ALBCJ{padding-top:" + ("2px")  + ";color:" + ("#888")  + ";font-size:" + ("10pt")  + ";width:" + ("70%")  + ";overflow:" + ("hidden")  + ";min-height:") + (("10pt")  + ";}.GAK-4ALBBJ{padding-top:" + ("2px")  + ";text-align:" + ("right")  + ";color:" + ("#888")  + ";font-size:" + ("10pt")  + ";overflow:" + ("hidden")  + ";position:" + ("absolute")  + ";top:" + ("0")  + ";right:" + ("10px")  + ";}.gwt-TextBox,.gwt-DateBox{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";padding:" + ("1px") ) + (";}"));
      }
      public java.lang.String cellListEvenItem(){
        return "GAK-4ALBMI";
      }
      public java.lang.String cellListKeyboardSelectedItem(){
        return "GAK-4ALBNI";
      }
      public java.lang.String cellListOddItem(){
        return "GAK-4ALBOI";
      }
      public java.lang.String cellListSelectedItem(){
        return "GAK-4ALBPI";
      }
      public java.lang.String cellListWidget(){
        return "GAK-4ALBAJ";
      }
      public java.lang.String dateProp(){
        return "GAK-4ALBBJ";
      }
      public java.lang.String secondaryProp(){
        return "GAK-4ALBCJ";
      }
    }
    ;
  }
  private static class cellListStyleInitializer {
    static {
      _instance0.cellListStyleInitializer();
    }
    static logbook.client.style.MobileListResources.MobileStyle get() {
      return cellListStyle;
    }
  }
  public logbook.client.style.MobileListResources.MobileStyle cellListStyle() {
    return cellListStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_Horizontal = GWT.getModuleBaseForStaticFiles() + "CD15EC0BBF9CD57F9198FD5C1C37122E.cache.png";
  private static final java.lang.String bundledImage_Horizontal_rtl = GWT.getModuleBaseForStaticFiles() + "9760B036C3B6E12FF6DEEDC917855221.cache.png";
  private static com.google.gwt.resources.client.ImageResource cellListSelectedBackground;
  private static logbook.client.style.MobileListResources.MobileStyle cellListStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      cellListSelectedBackground(), 
      cellListStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("cellListSelectedBackground", cellListSelectedBackground());
        resourceMap.put("cellListStyle", cellListStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'cellListSelectedBackground': return this.@com.google.gwt.user.cellview.client.CellList.Resources::cellListSelectedBackground()();
      case 'cellListStyle': return this.@logbook.client.style.MobileListResources::cellListStyle()();
    }
    return null;
  }-*/;
}
