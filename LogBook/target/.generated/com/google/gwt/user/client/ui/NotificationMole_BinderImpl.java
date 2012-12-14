package com.google.gwt.user.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class NotificationMole_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.google.gwt.user.client.ui.NotificationMole>, com.google.gwt.user.client.ui.NotificationMole.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div class='{0}' id='{1}' style='display:none'> <div id='{2}'> <span class='{3}' id='{4}'></span> </div> </div>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.google.gwt.user.client.ui.NotificationMole owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.google.gwt.user.client.ui.NotificationMole owner;


    public Widgets(final com.google.gwt.user.client.ui.NotificationMole owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1("" + get_style().centered() + "", get_domId0(), get_domId1(), "" + get_style().notificationText() + "", get_domId2());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle) GWT.create(com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style style;
    private com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private com.google.gwt.user.client.ui.NotificationMole_BinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_style().container() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_borderElement();
      get_heightMeasure();
      get_notificationText();

      // Detach section.
      attachRecord3.detach();

      return f_HTMLPanel1;
    }

    /**
     * Getter for borderElement called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.DivElement get_borderElement() {
      return build_borderElement();
    }
    private com.google.gwt.dom.client.DivElement build_borderElement() {
      // Creation section.
      final com.google.gwt.dom.client.DivElement borderElement = new com.google.gwt.uibinder.client.LazyDomElement(get_domId0()).get().cast();
      // Setup section.


      owner.borderElement = borderElement;

      return borderElement;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for heightMeasure called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.DivElement get_heightMeasure() {
      return build_heightMeasure();
    }
    private com.google.gwt.dom.client.DivElement build_heightMeasure() {
      // Creation section.
      final com.google.gwt.dom.client.DivElement heightMeasure = new com.google.gwt.uibinder.client.LazyDomElement(get_domId1()).get().cast();
      // Setup section.


      owner.heightMeasure = heightMeasure;

      return heightMeasure;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for notificationText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.SpanElement get_notificationText() {
      return build_notificationText();
    }
    private com.google.gwt.dom.client.SpanElement build_notificationText() {
      // Creation section.
      final com.google.gwt.dom.client.SpanElement notificationText = new com.google.gwt.uibinder.client.LazyDomElement(get_domId2()).get().cast();
      // Setup section.


      owner.notificationText = notificationText;

      return notificationText;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }
  }
}
