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

public class MainClassificationListView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, logbook.client.managed.ui.MainClassificationListView>, logbook.client.managed.ui.MainClassificationListView.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("Create MainClassification")
    SafeHtml html1();
     
    @Template("<div style='height:3em;'></div> <span id='{0}'></span> <div class='{1}'> <span id='{2}'></span> <span id='{3}'></span> </div>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final logbook.client.managed.ui.MainClassificationListView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final logbook.client.managed.ui.MainClassificationListView owner;


    public Widgets(final logbook.client.managed.ui.MainClassificationListView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_table();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0(), "" + get_style().controls() + "", get_domId1(), get_domId2());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle) GWT.create(logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for createButton called 0 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.resources.client.ImageResource get_createButton() {
      return build_createButton();
    }
    private com.google.gwt.resources.client.ImageResource build_createButton() {
      // Creation section.
      final com.google.gwt.resources.client.ImageResource createButton = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().createButton();
      // Setup section.


      return createButton;
    }

    /**
     * Getter for style called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style style;
    private logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private logbook.client.managed.ui.MainClassificationListView_BinderImpl_GenCss_style build_style() {
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_style().listView() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();

      // Detach section.
      attachRecord4.detach();
      f_HTMLPanel1.addAndReplaceElement(get_table(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_newButton(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_SimplePager2(), get_domId2Element().get());

      return f_HTMLPanel1;
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
     * Getter for table called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.cellview.client.CellTable table;
    private com.google.gwt.user.cellview.client.CellTable get_table() {
      return table;
    }
    private com.google.gwt.user.cellview.client.CellTable build_table() {
      // Creation section.
      table = (com.google.gwt.user.cellview.client.CellTable) GWT.create(com.google.gwt.user.cellview.client.CellTable.class);
      // Setup section.
      table.setWidth("100%");
      table.setPageSize(8);


      owner.table = table;

      return table;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
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
     * Getter for newButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_newButton() {
      return build_newButton();
    }
    private com.google.gwt.user.client.ui.Button build_newButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button newButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      newButton.setHTML(template_html1().asString());
      newButton.setStyleName("" + get_style().createButton() + "");


      owner.newButton = newButton;

      return newButton;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for f_SimplePager2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.cellview.client.SimplePager get_f_SimplePager2() {
      return build_f_SimplePager2();
    }
    private com.google.gwt.user.cellview.client.SimplePager build_f_SimplePager2() {
      // Creation section.
      final com.google.gwt.user.cellview.client.SimplePager f_SimplePager2 = new com.google.gwt.user.cellview.client.SimplePager(com.google.gwt.user.cellview.client.SimplePager.TextLocation.RIGHT);
      // Setup section.
      f_SimplePager2.setDisplay(get_table());


      return f_SimplePager2;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }
  }
}
