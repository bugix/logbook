package com.google.gwt.user.cellview.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CellTable_Resources_default_StaticClientBundleGenerator implements com.google.gwt.user.cellview.client.CellTable.Resources {
  private static CellTable_Resources_default_StaticClientBundleGenerator _instance0 = new CellTable_Resources_default_StaticClientBundleGenerator();
  private void cellTableFooterBackgroundInitializer() {
    cellTableFooterBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTableFooterBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_Horizontal_rtl : bundledImage_Horizontal),
      0, 0, 82, 23, false, false
    );
  }
  private static class cellTableFooterBackgroundInitializer {
    static {
      _instance0.cellTableFooterBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTableFooterBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTableFooterBackground() {
    return cellTableFooterBackgroundInitializer.get();
  }
  private void cellTableHeaderBackgroundInitializer() {
    cellTableHeaderBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTableHeaderBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_Horizontal_rtl : bundledImage_Horizontal),
      0, 0, 82, 23, false, false
    );
  }
  private static class cellTableHeaderBackgroundInitializer {
    static {
      _instance0.cellTableHeaderBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTableHeaderBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTableHeaderBackground() {
    return cellTableHeaderBackgroundInitializer.get();
  }
  private void cellTableLoadingInitializer() {
    cellTableLoading = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTableLoading",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl : externalImage),
      0, 0, 43, 11, true, false
    );
  }
  private static class cellTableLoadingInitializer {
    static {
      _instance0.cellTableLoadingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTableLoading;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTableLoading() {
    return cellTableLoadingInitializer.get();
  }
  private void cellTableSelectedBackgroundInitializer() {
    cellTableSelectedBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTableSelectedBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_Horizontal_rtl : bundledImage_Horizontal),
      0, 23, 82, 26, false, false
    );
  }
  private static class cellTableSelectedBackgroundInitializer {
    static {
      _instance0.cellTableSelectedBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTableSelectedBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTableSelectedBackground() {
    return cellTableSelectedBackgroundInitializer.get();
  }
  private void cellTableSortAscendingInitializer() {
    cellTableSortAscending = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTableSortAscending",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_None_rtl : bundledImage_None),
      11, 0, 11, 7, false, false
    );
  }
  private static class cellTableSortAscendingInitializer {
    static {
      _instance0.cellTableSortAscendingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTableSortAscending;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTableSortAscending() {
    return cellTableSortAscendingInitializer.get();
  }
  private void cellTableSortDescendingInitializer() {
    cellTableSortDescending = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTableSortDescending",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_None_rtl : bundledImage_None),
      0, 0, 11, 7, false, false
    );
  }
  private static class cellTableSortDescendingInitializer {
    static {
      _instance0.cellTableSortDescendingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTableSortDescending;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTableSortDescending() {
    return cellTableSortDescendingInitializer.get();
  }
  private void cellTableStyleInitializer() {
    cellTableStyle = new com.google.gwt.user.cellview.client.CellTable.Style() {
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
        return "cellTableStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBED{border-top:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("right")  + ";color:" + ("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";}.GAK-4ALBFD{border-bottom:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("right")  + ";color:" + ("#4b4a4a")  + ";text-shadow:") + (("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";}.GAK-4ALBOC{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";}.GAK-4ALBDE{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";}.GAK-4ALBDE:hover{color:" + ("#6c6b6b")  + ";}.GAK-4ALBPC{background:" + ("#fff")  + ";}.GAK-4ALBAD{border:" + ("2px"+ " " +"solid"+ " " +"#fff")  + ";}.GAK-4ALBPD{background:" + ("#f3f7fb")  + ";}.GAK-4ALBAE{border:" + ("2px"+ " " +"solid"+ " " +"#f3f7fb") ) + (";}.GAK-4ALBGD{background:" + ("#eee")  + ";}.GAK-4ALBHD{border:" + ("2px"+ " " +"solid"+ " " +"#eee")  + ";}.GAK-4ALBJD{background:" + ("#ffc")  + ";}.GAK-4ALBKD{border:" + ("2px"+ " " +"solid"+ " " +"#ffc")  + ";}.GAK-4ALBBE{background:" + ("#628cd5")  + ";color:" + ("white")  + ";height:" + ("auto")  + ";overflow:" + ("auto")  + ";}.GAK-4ALBCE{border:" + ("2px"+ " " +"solid"+ " " +"#628cd5")  + ";}.GAK-4ALBID{border:" + ("2px"+ " " +"solid"+ " " +"#d7dde8")  + ";}.GAK-4ALBOD{margin:") + (("30px")  + ";}")) : ((".GAK-4ALBED{border-top:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("left")  + ";color:" + ("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";}.GAK-4ALBFD{border-bottom:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("left")  + ";color:" + ("#4b4a4a")  + ";text-shadow:") + (("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";}.GAK-4ALBOC{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";}.GAK-4ALBDE{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";}.GAK-4ALBDE:hover{color:" + ("#6c6b6b")  + ";}.GAK-4ALBPC{background:" + ("#fff")  + ";}.GAK-4ALBAD{border:" + ("2px"+ " " +"solid"+ " " +"#fff")  + ";}.GAK-4ALBPD{background:" + ("#f3f7fb")  + ";}.GAK-4ALBAE{border:" + ("2px"+ " " +"solid"+ " " +"#f3f7fb") ) + (";}.GAK-4ALBGD{background:" + ("#eee")  + ";}.GAK-4ALBHD{border:" + ("2px"+ " " +"solid"+ " " +"#eee")  + ";}.GAK-4ALBJD{background:" + ("#ffc")  + ";}.GAK-4ALBKD{border:" + ("2px"+ " " +"solid"+ " " +"#ffc")  + ";}.GAK-4ALBBE{background:" + ("#628cd5")  + ";color:" + ("white")  + ";height:" + ("auto")  + ";overflow:" + ("auto")  + ";}.GAK-4ALBCE{border:" + ("2px"+ " " +"solid"+ " " +"#628cd5")  + ";}.GAK-4ALBID{border:" + ("2px"+ " " +"solid"+ " " +"#d7dde8")  + ";}.GAK-4ALBOD{margin:") + (("30px")  + ";}"));
      }
      public java.lang.String cellTableCell(){
        return "GAK-4ALBOC";
      }
      public java.lang.String cellTableEvenRow(){
        return "GAK-4ALBPC";
      }
      public java.lang.String cellTableEvenRowCell(){
        return "GAK-4ALBAD";
      }
      public java.lang.String cellTableFirstColumn(){
        return "GAK-4ALBBD";
      }
      public java.lang.String cellTableFirstColumnFooter(){
        return "GAK-4ALBCD";
      }
      public java.lang.String cellTableFirstColumnHeader(){
        return "GAK-4ALBDD";
      }
      public java.lang.String cellTableFooter(){
        return "GAK-4ALBED";
      }
      public java.lang.String cellTableHeader(){
        return "GAK-4ALBFD";
      }
      public java.lang.String cellTableHoveredRow(){
        return "GAK-4ALBGD";
      }
      public java.lang.String cellTableHoveredRowCell(){
        return "GAK-4ALBHD";
      }
      public java.lang.String cellTableKeyboardSelectedCell(){
        return "GAK-4ALBID";
      }
      public java.lang.String cellTableKeyboardSelectedRow(){
        return "GAK-4ALBJD";
      }
      public java.lang.String cellTableKeyboardSelectedRowCell(){
        return "GAK-4ALBKD";
      }
      public java.lang.String cellTableLastColumn(){
        return "GAK-4ALBLD";
      }
      public java.lang.String cellTableLastColumnFooter(){
        return "GAK-4ALBMD";
      }
      public java.lang.String cellTableLastColumnHeader(){
        return "GAK-4ALBND";
      }
      public java.lang.String cellTableLoading(){
        return "GAK-4ALBOD";
      }
      public java.lang.String cellTableOddRow(){
        return "GAK-4ALBPD";
      }
      public java.lang.String cellTableOddRowCell(){
        return "GAK-4ALBAE";
      }
      public java.lang.String cellTableSelectedRow(){
        return "GAK-4ALBBE";
      }
      public java.lang.String cellTableSelectedRowCell(){
        return "GAK-4ALBCE";
      }
      public java.lang.String cellTableSortableHeader(){
        return "GAK-4ALBDE";
      }
      public java.lang.String cellTableSortedHeaderAscending(){
        return "GAK-4ALBEE";
      }
      public java.lang.String cellTableSortedHeaderDescending(){
        return "GAK-4ALBFE";
      }
      public java.lang.String cellTableWidget(){
        return "GAK-4ALBGE";
      }
    }
    ;
  }
  private static class cellTableStyleInitializer {
    static {
      _instance0.cellTableStyleInitializer();
    }
    static com.google.gwt.user.cellview.client.CellTable.Style get() {
      return cellTableStyle;
    }
  }
  public com.google.gwt.user.cellview.client.CellTable.Style cellTableStyle() {
    return cellTableStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_Horizontal = GWT.getModuleBaseForStaticFiles() + "223E04DC70F69BC559571D1C0E0667E5.cache.png";
  private static final java.lang.String bundledImage_Horizontal_rtl = GWT.getModuleBaseForStaticFiles() + "0326AF455425F6065C00E0361659A798.cache.png";
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseForStaticFiles() + "AB196D9D7834625802449A82C5811B43.cache.png";
  private static final java.lang.String bundledImage_None_rtl = GWT.getModuleBaseForStaticFiles() + "3E13412DD77AE068AAF96B6978824A75.cache.png";
  private static final java.lang.String externalImage = GWT.getModuleBaseForStaticFiles() + "0F89659FF3F324AE4116F700257E32BD.cache.gif";
  private static final java.lang.String externalImage_rtl = GWT.getModuleBaseForStaticFiles() + "13D2931874E71D07F248A0CDF051CC85.cache.png";
  private static com.google.gwt.resources.client.ImageResource cellTableFooterBackground;
  private static com.google.gwt.resources.client.ImageResource cellTableHeaderBackground;
  private static com.google.gwt.resources.client.ImageResource cellTableLoading;
  private static com.google.gwt.resources.client.ImageResource cellTableSelectedBackground;
  private static com.google.gwt.resources.client.ImageResource cellTableSortAscending;
  private static com.google.gwt.resources.client.ImageResource cellTableSortDescending;
  private static com.google.gwt.user.cellview.client.CellTable.Style cellTableStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      cellTableFooterBackground(), 
      cellTableHeaderBackground(), 
      cellTableLoading(), 
      cellTableSelectedBackground(), 
      cellTableSortAscending(), 
      cellTableSortDescending(), 
      cellTableStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("cellTableFooterBackground", cellTableFooterBackground());
        resourceMap.put("cellTableHeaderBackground", cellTableHeaderBackground());
        resourceMap.put("cellTableLoading", cellTableLoading());
        resourceMap.put("cellTableSelectedBackground", cellTableSelectedBackground());
        resourceMap.put("cellTableSortAscending", cellTableSortAscending());
        resourceMap.put("cellTableSortDescending", cellTableSortDescending());
        resourceMap.put("cellTableStyle", cellTableStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'cellTableFooterBackground': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableFooterBackground()();
      case 'cellTableHeaderBackground': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableHeaderBackground()();
      case 'cellTableLoading': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableLoading()();
      case 'cellTableSelectedBackground': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableSelectedBackground()();
      case 'cellTableSortAscending': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableSortAscending()();
      case 'cellTableSortDescending': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableSortDescending()();
      case 'cellTableStyle': return this.@com.google.gwt.user.cellview.client.CellTable.Resources::cellTableStyle()();
    }
    return null;
  }-*/;
}
