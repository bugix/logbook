package logbook.client.managed.ui;

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

public class MainClassificationDetailsView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, logbook.client.managed.ui.MainClassificationDetailsView>, logbook.client.managed.ui.MainClassificationDetailsView.Binder {
  static MainClassificationDetailsViewBinderImplGenMessages messages = (MainClassificationDetailsViewBinderImplGenMessages) GWT.create(MainClassificationDetailsViewBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("Edit")
    SafeHtml html1();
     
    @Template("Delete")
    SafeHtml html2();
     
    @Template("<div class='{0}'> <h3 class='{1}'> {2} </h3> </div> <table class='{3}' id='boundElementHolder'> <tr id='id'> <td> <span class='{4}'>Id:</span> </td> <td> <span id='{5}'></span> </td> </tr> <tr id='description'> <td> <span class='{6}'>Description:</span> </td> <td> <span id='{7}'></span> </td> </tr> <tr id='version'> <td> <span class='{8}'>Version:</span> </td> <td> <span id='{9}'></span> </td> </tr> </table> <div class='{10}'> <span id='{11}'></span> <span id='{12}'></span> </div>")
    SafeHtml html3(String arg0, String arg1, SafeHtml arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final logbook.client.managed.ui.MainClassificationDetailsView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final logbook.client.managed.ui.MainClassificationDetailsView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDeleteClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEditClicked(event);
      }
    };

    public Widgets(final logbook.client.managed.ui.MainClassificationDetailsView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3("" + get_style().underline() + "", "" + get_style().header() + "", SafeHtmlUtils.fromSafeConstant(messages.message1("<span id='" + get_domId0() + "'>","</span>")), "" + get_style().fields() + "", "" + get_style().label() + "", get_domId1(), "" + get_style().label() + "", get_domId2(), "" + get_style().label() + "", get_domId3(), "" + get_style().bar() + "", get_domId4(), get_domId5());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle) GWT.create(logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 8 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style style;
    private logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private logbook.client.managed.ui.MainClassificationDetailsView_BinderImpl_GenCss_style build_style() {
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord6 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_displayRenderer();
      get_id();
      get_description();
      get_version();
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord6.detach();
      f_HTMLPanel1.addAndReplaceElement(get_edit(), get_domId4Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_delete(), get_domId5Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for displayRenderer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.SpanElement get_displayRenderer() {
      return build_displayRenderer();
    }
    private com.google.gwt.dom.client.SpanElement build_displayRenderer() {
      // Creation section.
      final com.google.gwt.dom.client.SpanElement displayRenderer = new com.google.gwt.uibinder.client.LazyDomElement(get_domId0()).get().cast();
      // Setup section.


      owner.displayRenderer = displayRenderer;

      return displayRenderer;
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
     * Getter for id called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.SpanElement get_id() {
      return build_id();
    }
    private com.google.gwt.dom.client.SpanElement build_id() {
      // Creation section.
      final com.google.gwt.dom.client.SpanElement id = new com.google.gwt.uibinder.client.LazyDomElement(get_domId1()).get().cast();
      // Setup section.


      owner.id = id;

      return id;
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
     * Getter for description called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.SpanElement get_description() {
      return build_description();
    }
    private com.google.gwt.dom.client.SpanElement build_description() {
      // Creation section.
      final com.google.gwt.dom.client.SpanElement description = new com.google.gwt.uibinder.client.LazyDomElement(get_domId2()).get().cast();
      // Setup section.


      owner.description = description;

      return description;
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

    /**
     * Getter for version called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.SpanElement get_version() {
      return build_version();
    }
    private com.google.gwt.dom.client.SpanElement build_version() {
      // Creation section.
      final com.google.gwt.dom.client.SpanElement version = new com.google.gwt.uibinder.client.LazyDomElement(get_domId3()).get().cast();
      // Setup section.


      owner.version = version;

      return version;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for edit called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_edit() {
      return build_edit();
    }
    private com.google.gwt.user.client.ui.Button build_edit() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button edit = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      edit.setHTML(template_html1().asString());
      edit.addStyleName("" + get_style().button() + "");
      edit.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.edit = edit;

      return edit;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId5;
    }

    /**
     * Getter for delete called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_delete() {
      return build_delete();
    }
    private com.google.gwt.user.client.ui.Anchor build_delete() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor delete = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      delete.setHTML(template_html2().asString());
      delete.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.delete = delete;

      return delete;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.


      return domId5Element;
    }
  }
}
