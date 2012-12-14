package logbook.client.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator implements logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle {
  private static ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void gwtLogoInitializer() {
    gwtLogo = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "gwtLogo",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 22, 20, false, false
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
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GAK-4ALBHJ{color:" + ("gray")  + ";}.GAK-4ALBEJ{overflow:" + ("auto")  + ";}.GAK-4ALBDJ{background-color:" + ("#777")  + ";-moz-border-radius-topleft:" + ("10px")  + ";-webkit-border-top-right-radius:" + ("10px")  + ";-moz-border-radius-topright:" + ("10px")  + ";-webkit-border-top-left-radius:" + ("10px")  + ";margin-top:" + ("1.5em")  + ";height:" + ("4em")  + ";}.GAK-4ALBAK{color:" + ("white")  + ";padding:") + (("1em")  + ";position:" + ("absolute")  + ";color:" + ("#def")  + ";}.GAK-4ALBAK h2{margin:" + ("0")  + ";}.GAK-4ALBLJ{position:" + ("absolute")  + ";right:" + ("12%")  + ";left:" + ("12%")  + ";text-align:" + ("center")  + ";background-color:" + ("red")  + ";}.GAK-4ALBNJ{position:" + ("absolute")  + ";right:" + ("75%") ) + (";left:" + ("0")  + ";text-align:" + ("center")  + ";color:" + ("#def")  + ";}.GAK-4ALBBK{position:" + ("absolute")  + ";left:" + ("0")  + ";}.GAK-4ALBFJ{width:" + ("850px")  + ";margin-left:" + ("auto")  + ";margin-right:" + ("auto")  + ";}.GAK-4ALBGJ{position:" + ("relative")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";overflow-y:") + (("auto")  + ";overflow-x:" + ("hidden")  + ";-moz-border-radius-bottomleft:" + ("10px")  + ";-webkit-border-bottom-right-radius:" + ("10px")  + ";-moz-border-radius-bottomright:" + ("10px")  + ";-webkit-border-bottom-left-radius:" + ("10px")  + ";}.GAK-4ALBIJ{position:" + ("absolute")  + ";right:" + ("0")  + ";top:" + ("0")  + ";bottom:" + ("0")  + ";width:" + ("11em") ) + (";}.GAK-4ALBJJ{border-left:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";height:" + ("100%")  + ";outline:" + ("none")  + ";}.GAK-4ALBJJ>div>div{padding-right:" + ("1em")  + ";padding-top:" + ("5px")  + ";padding-bottom:" + ("5px")  + ";}.GAK-4ALBKJ{margin-right:" + ("11em")  + ";}.GAK-4ALBMJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:") + (("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getTop() + "px  no-repeat")  + ";float:" + ("left")  + ";}.GAK-4ALBPJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getTop() + "px  no-repeat")  + ";float:" + ("left")  + ";}.GAK-4ALBOJ{color:" + ("#aaa")  + ";font-size:" + ("0.8em")  + ";width:" + ("160px")  + ";margin-right:" + ("auto") ) + (";margin-left:" + ("auto")  + ";text-align:" + ("left")  + ";}")) : ((".GAK-4ALBHJ{color:" + ("gray")  + ";}.GAK-4ALBEJ{overflow:" + ("auto")  + ";}.GAK-4ALBDJ{background-color:" + ("#777")  + ";-moz-border-radius-topleft:" + ("10px")  + ";-webkit-border-top-left-radius:" + ("10px")  + ";-moz-border-radius-topright:" + ("10px")  + ";-webkit-border-top-right-radius:" + ("10px")  + ";margin-top:" + ("1.5em")  + ";height:" + ("4em")  + ";}.GAK-4ALBAK{color:" + ("white")  + ";padding:") + (("1em")  + ";position:" + ("absolute")  + ";color:" + ("#def")  + ";}.GAK-4ALBAK h2{margin:" + ("0")  + ";}.GAK-4ALBLJ{position:" + ("absolute")  + ";left:" + ("12%")  + ";right:" + ("12%")  + ";text-align:" + ("center")  + ";background-color:" + ("red")  + ";}.GAK-4ALBNJ{position:" + ("absolute")  + ";left:" + ("75%") ) + (";right:" + ("0")  + ";text-align:" + ("center")  + ";color:" + ("#def")  + ";}.GAK-4ALBBK{position:" + ("absolute")  + ";right:" + ("0")  + ";}.GAK-4ALBFJ{width:" + ("850px")  + ";margin-right:" + ("auto")  + ";margin-left:" + ("auto")  + ";}.GAK-4ALBGJ{position:" + ("relative")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";overflow-y:") + (("auto")  + ";overflow-x:" + ("hidden")  + ";-moz-border-radius-bottomleft:" + ("10px")  + ";-webkit-border-bottom-left-radius:" + ("10px")  + ";-moz-border-radius-bottomright:" + ("10px")  + ";-webkit-border-bottom-right-radius:" + ("10px")  + ";}.GAK-4ALBIJ{position:" + ("absolute")  + ";left:" + ("0")  + ";top:" + ("0")  + ";bottom:" + ("0")  + ";width:" + ("11em") ) + (";}.GAK-4ALBJJ{border-right:" + ("1px"+ " " +"solid"+ " " +"#ddf")  + ";height:" + ("100%")  + ";outline:" + ("none")  + ";}.GAK-4ALBJJ>div>div{padding-left:" + ("1em")  + ";padding-top:" + ("5px")  + ";padding-bottom:" + ("5px")  + ";}.GAK-4ALBKJ{margin-left:" + ("11em")  + ";}.GAK-4ALBMJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:") + (("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.gwtLogo()).getTop() + "px  no-repeat")  + ";float:" + ("right")  + ";}.GAK-4ALBPJ{height:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getHeight() + "px")  + ";width:" + ((ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getSafeUri().asString() + "\") -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getLeft() + "px -" + (ScaffoldDesktopShell_BinderImpl_GenBundle_default_InlineClientBundleGenerator.this.rooLogo()).getTop() + "px  no-repeat")  + ";float:" + ("right")  + ";}.GAK-4ALBOJ{color:" + ("#aaa")  + ";font-size:" + ("0.8em")  + ";width:" + ("160px")  + ";margin-left:" + ("auto") ) + (";margin-right:" + ("auto")  + ";text-align:" + ("right")  + ";}"));
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
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAYAAACJfM0wAAADrElEQVR42u2UfUzUdRzHD7m7IOAQEFAx5EHtop0iyQhGc5T8QfiQbqLOp9r6Q+fCjVpbay7WouFCsAfXKsOH9HIaHnQHxwGHDighQEgeXBeg7Dd+kjyV3boOuXv1PYJmu9M/+6vP9t7v4fv9vL6f7+fz/X4Uiv/tPzOgS+iukDwvt8sl352YkLt/GpBrW1vlE5cM8pFPv5C7enpll/O+7Hpg7pxvly+wZ/Afc7ndfFlhIO9QATtfe4Ntu19l34vbSdWuY13a85zf8QqNxWX0t3bw29S9eTfZF1jyjEy7ZhiVJDqqatiwZReZqzPQp2Rhikmhc6GWnoBEitQJNPotolMRQWXESs5kbqDjG4PHXfIC/+lwSNaiUs7qsrgQo6M+KJbPFukoW5KMQxEDigRcQigScfivZFwZx7B/pIArKRdxlaVlMvnLmDfY1tQsXczbiVzwDn+EJwtAPO7ANUyHPYM9KoWRkBUMxK7Blr2J3s0v0Z6TQ31UFPUCahH6YIGa9stGb3Db56elq2+9KXbj4PfXj3ArYhU9T2hpjVpGXVAI1hUJdBccpjk9jaakpxgoeo+urdswC2jjY2o+8ixQ8qEPcPlXkilVi7vFwPjpTzBrgjGKySahaqHBo8V0iCg97zVCZo0Gy+IoLGGhNGiCOK5YQOu5i97gHstVyRjmh+NADo7Kk/yQtvZvgCeiuDiGyk9hiY6mOjgIc9hCqpX+s4s0qFXUiucxVTB9jc3e4JvXrkuVsdFMJ6uxFx+iY0suVSoVVcKxXqfjlv481uWx1CqV1PsracvIoHvvXq6EhPCtAJdGL2Ow/Udv8FDvz1KFTos9UZy8XUnc2JqNMTQUiwccEMhUcxP9+flUzaWmMy+PyZYWvlu6FIP4Pr4qiRHbkDd4ZPiOVPFsKpMJAvxCCLezdJj9VLNV96Ske88e7DYbfYfzaUlOpjM3l979+6hRq0V+Bfi59fw6Nu4Nnpq6J32dncvgYgFer+Z2ejw1qgDqhFOdwm82j9cFbLCwkLaNG6kID6dU/DuqieTU9t301TYgLqvk8+Zd0xvQR4ZjX61gNDOeWnUgVjF0Za6IeqETnjMbpOHjtemY3z+G1G9j2nl//kr7BoumgundEmoilYymLcEa+Phs/k56qq4UW37yaS4dzOeGqQGHw4kPkx7ahBxOF5cP5KPX+M1GVyKqfWbHfr4/e4HRwWFm3DzK5Ee2zYk7Y/K5lw/KxrcL5eGem7LTOfNge3yY/tU2/wLpfvakBuY5hwAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACYAAAAUCAYAAADhj08IAAAFJklEQVR42r2Wi1NUdRTH/Sea8VWDgKCyZOMjHwM6OWXhYEWmmaE5USGKBIgiQiSSCoZCIWBQCPFQkqcsKPIwESUkdUVYQBAW3Mdll91l2fcud7+de2E0tSnLWe/O2Xt/5/7uvZ/7/Z1z7pkGoJNMScb8k9kmbIzePM44HCzzb3Of0ziWzmn0p8IzbPdkXYjOC8Yg04cXsKk4MMWzzLx4qxKC0JcQlP4BeqSdzgZTPDNYRs0xLIuahcURr8D/0HJk0lii7AfrmCBjeXvhYFa7BXtyQ+CfMBOB33lhUYQHlka6wC9hCT774X3sPLWFzgfhSGkMKtvOgNHKXgzYuGkMO7MC8XrkbMT/Mg+fnliAZXu9sTRqAZbucceSSDeCdcHCr17Ga+GzEHDEFy3iRueDaQ0aBGdu4h/8bqIAaWUeOFzsic3JXnj7oADvkK1LEMCP9qtjvDF/10ysT1yBfkWPsxXTIfTHQCyJmA2f/a9ibbwAiUWeELa4oa7VDTXX3FBNx5XNbiiom4udGfPhFTodufWZzg/+xJJ9tEwz8EasAKtiBFgZ7Y0NR7yQUOiJkgZ3tIrmoL3DFW13yESuCDk5CzEFu2Cf0DkX7HLHRSzf6wqfaA+sifXmAX0JkIs1n/0ChJBKtaRc621XNLTNQdGlGShv2QWJLAVWm8x5YNx2rPxrLAybjpX73AnMmwAFvPkS2KIIb6SWekIkdkXZZRd+iSWyfbjbtx39wwnOBbPYzMhvysaGo2uwYu9cqmuupKI7FkfOpeV1QVHdDAivTsfBggXofSCEg9XAZh+ByXLv+cBsdg3JroLDYefHE6xhaswVT8eU2cFoulB/KwdVNyqRU5eCo6VxyGs4gN7B7ahqeRNBafNwvbuJvwfrAF98uVrIvxztTVbjE3XSSj7T34PpjZ2Qq4ohUxZAp28n+wMPmGwMSJMwMloBi1WOEXUFpCPZUI/VQm+4AIOpgeaVQ609DYvlLgE4IFdmQtSzCe3iMLqmFyUt+Th0NgpZF1Jwe+AGYgtDEZa9FU0dtTyBePgOovN3ICxnKy6Jqp8Gk8hSoRj9FSxrwbihA+KBMAKpgtkyTIA/QSL/Hr2SaGjHW6E3ddH5cNwbiqPjHugMN+mF8jEsz4BCdY6ENUGpLsSg9ACVmS147/AqlFzNQ+CJdUipOIjTjRn45Lgf6kVChGRtRnJZLHIb0hFwdDV+721+HIxTRDpCN1ecIkWawKjPUaqPTdYxgwhd/V+Qr5wfmwi2ZzAKSk3t1JIbSalC3meyDE0umXUYKnURwnM+xvkbZfyXICg9gC/W3JZUFoePjr2F3aSeRj/K++KLw5FWffgRmIM+xFabkmJMC4NRjPvDiaRGLMb0bfRQC6lwFn1D8aTCeT7OjOY+dN/fzSs6GZtaUruEsi8RKm0dH5Oj2lpS8FvsyNqE6vYK/oO/OWUtJU8WdSpV2Ja2HmebTyP45EbkNWbiws1KbExag8Y7wr8qxt2ojgBKSIUaMiHFVjIG5al8nElHfqYlE0Oju0pYLKmhIGUzadzCg3FFVK27QjHXTfNzCLiSIL+BlDmOdGEymrsmE+FKZz0+P/khtqWuR+m1At53vec3fMn7/HGmOZdeyvEQ7GGjyC2nzcal9yAtWwXMVikdS6aylCUo+9RMwmOt5Lc9HHM/89R1clURD84lkM3OkuqPWiKDRQ+dceyxrOSylGsUnmwUn2qtKWYYs01KbbT9P7XFE6yJocRhRscaGKP5Pvkc/7u1/hMgZHtsbmacRQAAAABJRU5ErkJggg==";
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
