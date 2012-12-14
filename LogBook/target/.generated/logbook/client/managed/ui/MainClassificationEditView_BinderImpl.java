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

public class MainClassificationEditView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, logbook.client.managed.ui.MainClassificationEditView>, logbook.client.managed.ui.MainClassificationEditView.Binder {
  static MainClassificationEditViewBinderImplGenMessages messages = (MainClassificationEditViewBinderImplGenMessages) GWT.create(MainClassificationEditViewBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("Save")
    SafeHtml html1();
     
    @Template("Cancel")
    SafeHtml html2();
     
    @Template("<div class='{0}'> <h3 class='{1}' id='{2}'> {3} </h3> <h3 class='{4}' id='{5}'> {6} </h3> </div> <div class='{7}' id='{8}'></div> <table class='{9}' id='boundElementHolder'> <tr id='description'> <td> <div class='{10}'>Description:</div> </td> <td> <span id='{11}'></span> </td> </tr> </table> <div class='{12}'> <span id='{13}'></span> <span id='{14}'></span> </div>")
    SafeHtml html3(String arg0, String arg1, String arg2, SafeHtml arg3, String arg4, String arg5, SafeHtml arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final logbook.client.managed.ui.MainClassificationEditView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final logbook.client.managed.ui.MainClassificationEditView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSave(event);
      }
    };

    public Widgets(final logbook.client.managed.ui.MainClassificationEditView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
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
      return template.html3("" + get_style().underline() + "", "" + get_style().header() + "", get_domId0(), SafeHtmlUtils.fromSafeConstant(messages.message1()), "" + get_style().header() + "", get_domId1(), SafeHtmlUtils.fromSafeConstant(messages.message2()), "" + get_style().errors() + "", get_domId2(), "" + get_style().fields() + "", "" + get_style().label() + "", get_domId3(), "" + get_style().bar() + "", get_domId4(), get_domId5());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenBundle) GWT.create(logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 9 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenCss_style style;
    private logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private logbook.client.managed.ui.MainClassificationEditView_BinderImpl_GenCss_style build_style() {
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
      UiBinderUtil.TempAttachment attachRecord7 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_editTitle();
      get_createTitle();
      get_errors();
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord7.detach();
      f_HTMLPanel1.addAndReplaceElement(get_description(), get_domId3Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_save(), get_domId4Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_cancel(), get_domId5Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for editTitle called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.HeadingElement get_editTitle() {
      return build_editTitle();
    }
    private com.google.gwt.dom.client.HeadingElement build_editTitle() {
      // Creation section.
      final com.google.gwt.dom.client.HeadingElement editTitle = new com.google.gwt.uibinder.client.LazyDomElement(get_domId0()).get().cast();
      // Setup section.


      owner.editTitle = editTitle;

      return editTitle;
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
     * Getter for createTitle called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.HeadingElement get_createTitle() {
      return build_createTitle();
    }
    private com.google.gwt.dom.client.HeadingElement build_createTitle() {
      // Creation section.
      final com.google.gwt.dom.client.HeadingElement createTitle = new com.google.gwt.uibinder.client.LazyDomElement(get_domId1()).get().cast();
      // Setup section.


      owner.createTitle = createTitle;

      return createTitle;
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
     * Getter for errors called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.dom.client.DivElement get_errors() {
      return build_errors();
    }
    private com.google.gwt.dom.client.DivElement build_errors() {
      // Creation section.
      final com.google.gwt.dom.client.DivElement errors = new com.google.gwt.uibinder.client.LazyDomElement(get_domId2()).get().cast();
      // Setup section.


      owner.errors = errors;

      return errors;
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
     * Getter for description called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextBox get_description() {
      return build_description();
    }
    private com.google.gwt.user.client.ui.TextBox build_description() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox description = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.


      owner.description = description;

      return description;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for save called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_save() {
      return build_save();
    }
    private com.google.gwt.user.client.ui.Button build_save() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button save = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      save.setHTML(template_html1().asString());
      save.addStyleName("" + get_style().button() + "");
      save.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.save = save;

      return save;
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
     * Getter for cancel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_cancel() {
      return build_cancel();
    }
    private com.google.gwt.user.client.ui.Button build_cancel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancel.setHTML(template_html2().asString());
      cancel.addStyleName("" + get_style().button() + "");
      cancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.cancel = cancel;

      return cancel;
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
