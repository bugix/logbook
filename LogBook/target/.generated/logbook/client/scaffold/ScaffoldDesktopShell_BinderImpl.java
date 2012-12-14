package logbook.client.scaffold;

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
import com.google.gwt.user.client.ui.Widget;

public class ScaffoldDesktopShell_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, logbook.client.scaffold.ScaffoldDesktopShell>, logbook.client.scaffold.ScaffoldDesktopShell.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div class='{0}'> <div class='{1}' id='{2}'></div> <span class='{3}'> <h2>Data Browser</h2> </span> <span id='{4}'></span> </div>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<div class='{0}'> <span>Powered by:</span> <a href='http://code.google.com/webtoolkit/'> <div class='{1}'></div> </a> <a href='http://www.springsource.org/roo/'> <div class='{2}'></div> </a> </div>")
    SafeHtml html2(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final logbook.client.scaffold.ScaffoldDesktopShell owner) {


    return new Widgets(owner).get_f_DockLayoutPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final logbook.client.scaffold.ScaffoldDesktopShell owner;


    public Widgets(final logbook.client.scaffold.ScaffoldDesktopShell owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1("" + get_style().banner() + "", "" + get_style().error() + "", get_domId0(), "" + get_style().title() + "", get_domId1());
    }
    SafeHtml template_html2() {
      return template.html2("" + get_style().logos() + "", "" + get_style().gwtLogo() + "", "" + get_style().rooLogo() + "");
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 3 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle) GWT.create(logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for gwtLogo called 0 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.resources.client.ImageResource get_gwtLogo() {
      return build_gwtLogo();
    }
    private com.google.gwt.resources.client.ImageResource build_gwtLogo() {
      // Creation section.
      final com.google.gwt.resources.client.ImageResource gwtLogo = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().gwtLogo();
      // Setup section.


      return gwtLogo;
    }

    /**
     * Getter for rooLogo called 0 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.resources.client.ImageResource get_rooLogo() {
      return build_rooLogo();
    }
    private com.google.gwt.resources.client.ImageResource build_rooLogo() {
      // Creation section.
      final com.google.gwt.resources.client.ImageResource rooLogo = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().rooLogo();
      // Setup section.


      return rooLogo;
    }

    /**
     * Getter for style called 14 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style style;
    private logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private logbook.client.scaffold.ScaffoldDesktopShell_BinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_DockLayoutPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.DockLayoutPanel get_f_DockLayoutPanel1() {
      return build_f_DockLayoutPanel1();
    }
    private com.google.gwt.user.client.ui.DockLayoutPanel build_f_DockLayoutPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.EM);
      // Setup section.
      f_DockLayoutPanel1.addNorth(get_f_HTMLPanel2(), 6);
      f_DockLayoutPanel1.addSouth(get_f_HTML3(), 2);
      f_DockLayoutPanel1.add(get_f_FlowPanel4());


      return f_DockLayoutPanel1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().centered() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_error();
      get_domId1Element().get();

      // Detach section.
      attachRecord1.detach();
      f_HTMLPanel2.addAndReplaceElement(get_loginWidget(), get_domId1Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for error called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.dom.client.DivElement get_error() {
      return build_error();
    }
    private com.google.gwt.dom.client.DivElement build_error() {
      // Creation section.
      final com.google.gwt.dom.client.DivElement error = new com.google.gwt.uibinder.client.LazyDomElement(get_domId0()).get().cast();
      // Setup section.


      owner.error = error;

      return error;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for loginWidget called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private logbook.client.scaffold.ui.LoginWidget get_loginWidget() {
      return build_loginWidget();
    }
    private logbook.client.scaffold.ui.LoginWidget build_loginWidget() {
      // Creation section.
      final logbook.client.scaffold.ui.LoginWidget loginWidget = (logbook.client.scaffold.ui.LoginWidget) GWT.create(logbook.client.scaffold.ui.LoginWidget.class);
      // Setup section.
      loginWidget.setStyleName("" + get_style().login() + "");


      owner.loginWidget = loginWidget;

      return loginWidget;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for f_HTML3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_f_HTML3() {
      return build_f_HTML3();
    }
    private com.google.gwt.user.client.ui.HTML build_f_HTML3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML f_HTML3 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      f_HTML3.setHTML(template_html2().asString());


      return f_HTML3;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_f_SimplePanel5());
      f_FlowPanel4.add(get_f_FlowPanel6());
      f_FlowPanel4.add(get_details());
      f_FlowPanel4.setStyleName("" + get_style().content() + " " + get_style().centered() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for f_SimplePanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel5() {
      return build_f_SimplePanel5();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel5 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      f_SimplePanel5.add(get_placesBox());
      f_SimplePanel5.setStyleName("" + get_style().entities() + "");


      return f_SimplePanel5;
    }

    /**
     * Getter for placesBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.ValuePicker get_placesBox() {
      return build_placesBox();
    }
    private com.google.gwt.user.client.ui.ValuePicker build_placesBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.ValuePicker placesBox = owner.placesBox;
      assert placesBox != null : "UiField placesBox with 'provided = true' was null";
      // Setup section.
      placesBox.setStyleName("" + get_style().entitiesList() + "");
      placesBox.setWidth("100%");
      placesBox.setPageSize(100);


      return placesBox;
    }

    /**
     * Getter for f_FlowPanel6 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel6() {
      return build_f_FlowPanel6();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel6 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel6.add(get_mole());
      f_FlowPanel6.add(get_master());


      return f_FlowPanel6;
    }

    /**
     * Getter for mole called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.NotificationMole get_mole() {
      return build_mole();
    }
    private com.google.gwt.user.client.ui.NotificationMole build_mole() {
      // Creation section.
      final com.google.gwt.user.client.ui.NotificationMole mole = (com.google.gwt.user.client.ui.NotificationMole) GWT.create(com.google.gwt.user.client.ui.NotificationMole.class);
      // Setup section.
      mole.setMessage("loading...");
      mole.setAnimationDuration(0);


      owner.mole = mole;

      return mole;
    }

    /**
     * Getter for master called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_master() {
      return build_master();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_master() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel master = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      master.setStyleName("" + get_style().entityDetails() + "");


      owner.master = master;

      return master;
    }

    /**
     * Getter for details called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_details() {
      return build_details();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_details() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel details = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      details.setStyleName("" + get_style().entityDetails() + "");


      owner.details = details;

      return details;
    }
  }
}
