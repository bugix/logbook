package ch.unibas.medizin.logbook.client.shell;

import ch.unibas.medizin.logbook.client.navigation.LogBookAdminNav;
import ch.unibas.medizin.logbook.client.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The applications basic layout.
 */
public class LogBookAdminShell extends Composite {

	private static LogBookAdminShellUiBinder uiBinder = GWT
			.create(LogBookAdminShellUiBinder.class);

	@UiField
	SimplePanel topPanel;
	
	@UiField
	DockLayoutPanel masterDockPanel;
	
	LogBookConstants constants = GWT.create(LogBookConstants.class);

	@UiField
	SimplePanel logBookNavSimplePanel;

	public SimplePanel getLogBookNavSimplePanel() {
		return logBookNavSimplePanel;
	}

	interface LogBookAdminShellUiBinder extends UiBinder<Widget, LogBookAdminShell> {
	}

	public LogBookAdminShell() {
		initWidget(uiBinder.createAndBindUi(this));
		
		init();
	}
	
	final private HandlerManager handlerManager = new HandlerManager(this);
	
	private void init() {
		StyleInjector.inject(".gwt-SplitLayoutPanel-HDragger {   background-color: #FFFFFF ; cursor: col-resize; border-left: 1px solid #EEEEEE; }");
		StyleInjector.inject(".gwt-Button {   margin: 0; " +
		  "padding: 3px 5px; " +
		  "text-decoration: none; " +
		  "font-size: small; " +
		  "cursor: pointer; " +
		  "cursor: hand; " +
		  "border: 1px outset #ccc; }");
		
		String radiusTop = "-moz-border-radius-topleft:5px;" +
		"-webkit-border-radius-topleft:5px;" +
		"-khtml-border-radius-topleft:5px;" +
		"border-radius-topleft:5px;"+
		"-moz-border-radius-topright:5px;" +
		"-webkit-border-radius-topright:5px;" +
		"-khtml-border-radius-topright:5px;" +
		"border-radius-topright:5px;";
		
		String radiusBottom = "-moz-border-radius-bottomleft:5px;" +
		"-webkit-border-radius-bottomleft:5px;" +
		"-khtml-border-radius-bottomleft:5px;" +
		"border-radius-bottomleft:5px;"+
		"-moz-border-radius-bottomright:5px;" +
		"-webkit-border-radius-bottomright:5px;" +
		"-khtml-border-radius-bottomright:5px;" +
		"border-radius-bottomright:5px;";
		
		StyleInjector.inject(".gwt-TabBar .gwt-TabBarItem {   background-color: #BA9DD1 ;  "+radiusTop+"}");
		StyleInjector.inject(".gwt-TabBar .gwt-TabBarItem-selected {   background-color: #E6D8F2 ; z-index: 99;  "+radiusTop+"}");

		StyleInjector.injectAtEnd(
		
		".gwt-DatePicker {"+
		"	  border: 1px solid #A2BBDD;"+
		"	  cursor: default;"+
		"	}"+
		"	.gwt-DatePicker td,"+
		"	.datePickerMonthSelector td:focus {"+
		"	  outline: none"+
		"	}"+
		"	.datePickerDays {"+
		"	  width: 100%;"+
		"	  background: white;"+
		"	}"+
		"	.datePickerDay,"+
		"	.datePickerWeekdayLabel,"+
		"	.datePickerWeekendLabel {"+
		"	  font-size: 90%;"+
		"	  text-align: center;"+
		"	  padding: 4px; border: 1px solid #d3d3d3/*{borderColorDefault}*/; background: #e6e6e6/*{bgColorDefault}*/ url(css/smoothness/images/ui-bg_glass_75_e6e6e6_1x400.png)/*{bgImgUrlDefault}*/ 50%/*{bgDefaultXPos}*/ 50%/*{bgDefaultYPos}*/ repeat-x/*{bgDefaultRepeat}*/; font-weight: normal/*{fwDefault}*/; color: #555555/*{fcDefault}*/; "+
		"	  outline: none;"+
		"	}"+
		"	.datePickerWeekdayLabel,"+
		"	.datePickerWeekendLabel {"+
		"	 background: #e6e6e6/*{bgColorDefault}*/ url(css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png)/*{bgImgUrlDefault}*/ 50%/*{bgDefaultXPos}*/ 50%/*{bgDefaultYPos}*/ repeat-x/*{bgDefaultRepeat}*/;"+
		"	  padding: 4px;"+
		"	  font-weight: bold;"+
		"	  cursor: default;"+
		"	}"+
		"	.datePickerDay {"+
		"	  padding: 4px;"+
		"	  cursor: hand;"+
		"	  cursor: pointer;"+
		"	}"+
		"	.datePickerDayIsToday {"+
		"	  border: 1px solid #8EA80D;"+
		"	  padding: 3px;"+
		"	  color: #8EA80D"+
		"	}"+
		"	.datePickerDayIsWeekend {"+
		"	  background: #EEEEEE;"+
		"	}"+
		"	.datePickerDayIsFiller {"+
		"	  color: #888888;"+
		"	}"+
		"	.datePickerDayIsValue {"+
		"	  background: #aaccee;"+
		"	}"+
		"	.datePickerDayIsDisabled {"+
		"	  color: #AAAAAA;"+
		"	  font-style: italic;"+
		"	}"+
		"	.datePickerDayIsHighlighted {"+
		"	  background: #F0E68C;"+
		"	}"+
		"	.datePickerDayIsValueAndHighlighted {"+
		"	  background: #bbddd9;"+
		"	}"+
		"	.datePickerMonthSelector {"+
		"	  width: 100%; border: 1px solid #aaaaaa/*{borderColorHeader}*/; background: #cccccc/*{bgColorHeader}*/ url(css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png)/*{bgImgUrlHeader}*/ 50%/*{bgHeaderXPos}*/ 50%/*{bgHeaderYPos}*/ repeat-x/*{bgHeaderRepeat}*/; color: #222222/*{fcHeader}*/; font-weight: bold;"+
		"	}"+
		"	td.datePickerMonth {"+
		"	  text-align: center;"+
		"	  vertical-align: center;"+
		"	  white-space: nowrap;"+
		"	  font-size: 100%;"+
		"	  font-weight: bold;"+
		"	  color:  #555555;  "+
		"	}"+
		"	.datePickerPreviousButton,"+
		"	.datePickerNextButton {"+
		"	  font-size: 120%;"+
		"	  line-height: 1em;"+
		"	  color:  #555555;"+
		"	  cursor: hand;"+
		"	  cursor: pointer;"+
		"	  padding: 0px 4px;"+
		"	} " );

		  
		StyleInjector.injectAtEnd(
		"	.gwt-DisclosurePanel {" +
		"	padding: 5px;"+
		"	  width: 100%;"+
		"	}"+
		"	.gwt-DisclosurePanel-open .header{"+
		"	  border-bottom: 0px solid #999999;"+
		"	}"+
		"	.gwt-DisclosurePanel-closed .header{"+
			radiusBottom +
		"	  border-bottom: 1px solid #999999;"+
		"	}"+
		"	.gwt-DisclosurePanel .header{" +
		"	  border-left: 1px solid #999999;"+
		"	  border-top: 1px solid #999999;"+
		"	  border-right: 1px solid #999999;"+
		"	  width: 100%;"+ radiusTop +
		"	  padding: 0px;"+
		"	  margin: 0px;"+
		"	  background: #cccccc/*{bgColorHeader}*/ url(css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png)/*{bgImgUrlHeader}*/ 50%/*{bgHeaderXPos}*/ 50%/*{bgHeaderYPos}*/ repeat-x/*{bgHeaderRepeat}*/;"+
		"	}"+
		"	.gwt-DisclosurePanel .header a,"+
		"	.gwt-DisclosurePanel .header td {"+
		"	  text-decoration: none;  " +
		
		"	  color: black; "+
		"	  cursor: pointer;"+
		"	  cursor: hand;"+
		"	}"+
		
		"	.gwt-DisclosurePanel .gwt-Anchor {"+
		"	  display: block;"+	
		"	  border-left: 0px solid #CCCCCC;"+
		"	  border-top: 1px solid #CCCCCC;"+
		"	  border-bottom: 0px solid #CCCCCC;"+
		"	  border-right: 1px solid #999999;"+
		"	  padding: 5px;"+		
		"	  margin-right: -1px;"+	
		"	  cursor: pointer;"+
		"	  cursor: hand;"+
		"	  color: black;"+
		"	  background: #e6e6e6 url(css/smoothness/images/ui-bg_glass_75_dadada_1x400.png) 50% 50% repeat-x;"+
		"	}"+
		"	.gwt-DisclosurePanel .gwt-Anchor:hover {"+
		"	  display: block;"+		
		"	  background: #f9f9f9 url(css/smoothness/images/ui-bg_glass_95_fef1ec_1x400.png) 50% 50% repeat-x;"+
		"	}"+
		
		"	.gwt-DisclosurePanel .gwt-AnchorSelected {"+
		"	  display: block;"+
		"	  border-top: 1px solid #FF0000;"+
		"	  border-bottom: 1px solid #FF0000;"+		
		"	  background: #f9f9f9 url(css/smoothness/images/ui-bg_glass_95_fef1ec_1x400.png) 50% 50% repeat-x;"+
		"	}"+
		"	.gwt-DisclosurePanel .content {"+
		"	  border-left: 1px solid #999999;"+
		"	  border-right: 1px solid #999999;"+
		"	  border-bottom: 1px solid #999999;"+
		"	  width: 100%;"+ 
		"	  margin: 0px;"+
		"	  padding: 0px;"+
		"	}" );
	}

	public void setNavigation(LogBookAdminNav nav) {
		getLogBookNavSimplePanel().add(nav);
		Log.debug("node value :" +masterDockPanel.getWidget(2).getElement().getParentElement());
		masterDockPanel.getWidget(2).getElement().getParentElement().addClassName("top76");
		
	}
}
