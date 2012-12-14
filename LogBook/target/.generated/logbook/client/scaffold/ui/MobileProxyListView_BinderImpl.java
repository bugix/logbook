package logbook.client.scaffold.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MobileProxyListView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, logbook.client.scaffold.ui.MobileProxyListView<?>>, logbook.client.scaffold.ui.MobileProxyListView.Binder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final logbook.client.scaffold.ui.MobileProxyListView<?> owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final logbook.client.scaffold.ui.MobileProxyListView<?> owner;


    public Widgets(final logbook.client.scaffold.ui.MobileProxyListView<?> owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_list();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle) GWT.create(logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenBundle.class);
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
     * Getter for style called 2 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style style;
    private logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style get_style() {
      return style;
    }
    private logbook.client.scaffold.ui.MobileProxyListView_BinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_newButton());
      f_FlowPanel1.add(get_f_SimplePager2());
      f_FlowPanel1.add(get_list());


      return f_FlowPanel1;
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
      newButton.setStyleName("" + get_style().createButton() + "");


      owner.newButton = newButton;

      return newButton;
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
      f_SimplePager2.setDisplay(get_list());


      return f_SimplePager2;
    }

    /**
     * Getter for list called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.cellview.client.CellList list;
    private com.google.gwt.user.cellview.client.CellList get_list() {
      return list;
    }
    private com.google.gwt.user.cellview.client.CellList build_list() {
      // Creation section.
      list = owner.list;
      assert list != null : "UiField list with 'provided = true' was null";
      // Setup section.
      list.addStyleName("" + get_style().list() + "");
      list.setPageSize(8);


      return list;
    }
  }
}
