package ch.unibas.medizin.logbook.client.shell;

import ch.unibas.medizin.logbook.client.navigation.LogBookAdminNav;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
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

	private static LogBookAdminShellUiBinder uiBinder = GWT.create(LogBookAdminShellUiBinder.class);

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
	}

	public void setNavigation(LogBookAdminNav nav) {
		getLogBookNavSimplePanel().add(nav);
		Log.debug("node value :" +masterDockPanel.getWidget(2).getElement().getParentElement());
		masterDockPanel.getWidget(2).getElement().getParentElement().addClassName("top76");
	}
}
