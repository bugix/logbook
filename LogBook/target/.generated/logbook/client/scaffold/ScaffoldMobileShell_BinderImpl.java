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

public class ScaffoldMobileShell_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, logbook.client.scaffold.ScaffoldMobileShell>, logbook.client.scaffold.ScaffoldMobileShell.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("Back")
    SafeHtml html1();
     
    @Template("Edit")
    SafeHtml html2();
     
    @Template("<table cellpadding='0' cellspacing='0' class='{0}'> <tr> <td align='left' class='{1}' valign='middle'> <table cellpadding='0' cellspacing='0' id='{2}'> <tr> <td> <div class='{3}'></div> </td> <td> <span id='{4}'></span> </td> </tr> </table> </td> <td align='center' class='{5}' id='{6}' valign='middle'> All Entities </td> <td align='right' class='{7}' valign='middle'> <span id='{8}'></span> </td> </tr> </table>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final logbook.client.scaffold.ScaffoldMobileShell owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final logbook.client.scaffold.ScaffoldMobileShell owner;


    public Widgets(final logbook.client.scaffold.ScaffoldMobileShell owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3("" + get_style().titlebarLayout() + "", "" + get_style().backButtonCell() + "", get_domId0(), "" + get_style().backButtonImage() + "", get_domId1(), "" + get_style().title() + "", get_domId2(), "" + get_style().editButtonCell() + "", get_domId3());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 3 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenBundle) GWT.create(logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for titleGradient called 0 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.resources.client.ImageResource get_titleGradient() {
      return build_titleGradient();
    }
    private com.google.gwt.resources.client.ImageResource build_titleGradient() {
      // Creation section.
      final com.google.gwt.resources.client.ImageResource titleGradient = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().titleGradient();
      // Setup section.


      return titleGradient;
    }

    /**
     * Getter for backButtonImage called 0 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.resources.client.ImageResource get_backButtonImage() {
      return build_backButtonImage();
    }
    private com.google.gwt.resources.client.ImageResource build_backButtonImage() {
      // Creation section.
      final com.google.gwt.resources.client.ImageResource backButtonImage = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().backButtonImage();
      // Setup section.


      return backButtonImage;
    }

    /**
     * Getter for style called 10 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenCss_style style;
    private logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private logbook.client.scaffold.ScaffoldMobileShell_BinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_f_HTMLPanel2());
      f_FlowPanel1.add(get_body());
      f_FlowPanel1.add(get_loginWidget());


      return f_FlowPanel1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().titlebar() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_backButtonWrapper();
      get_domId1Element().get();
      get_title();
      get_domId3Element().get();

      // Detach section.
      attachRecord0.detach();
      f_HTMLPanel2.addAndReplaceElement(get_backButton(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_editButton(), get_domId3Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for backButtonWrapper called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.dom.client.TableElement get_backButtonWrapper() {
      return build_backButtonWrapper();
    }
    private com.google.gwt.dom.client.TableElement build_backButtonWrapper() {
      // Creation section.
      final com.google.gwt.dom.client.TableElement backButtonWrapper = new com.google.gwt.uibinder.client.LazyDomElement(get_domId0()).get().cast();
      // Setup section.


      owner.backButtonWrapper = backButtonWrapper;

      return backButtonWrapper;
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
     * Getter for backButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_backButton() {
      return build_backButton();
    }
    private com.google.gwt.user.client.ui.Button build_backButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button backButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      backButton.setHTML(template_html1().asString());
      backButton.setStyleName("" + get_style().button() + " " + get_style().backButton() + "");


      owner.backButton = backButton;

      return backButton;
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
     * Getter for title called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.dom.client.TableCellElement get_title() {
      return build_title();
    }
    private com.google.gwt.dom.client.TableCellElement build_title() {
      // Creation section.
      final com.google.gwt.dom.client.TableCellElement title = new com.google.gwt.uibinder.client.LazyDomElement(get_domId2()).get().cast();
      // Setup section.


      owner.title = title;

      return title;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for editButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_editButton() {
      return build_editButton();
    }
    private com.google.gwt.user.client.ui.Button build_editButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editButton.setHTML(template_html2().asString());
      editButton.setStyleName("" + get_style().button() + "");


      owner.editButton = editButton;

      return editButton;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for body called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_body() {
      return build_body();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_body() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel body = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      owner.body = body;

      return body;
    }

    /**
     * Getter for loginWidget called 1 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
