package ch.unibas.medizin.logbook.client.shell;

import ch.unibas.medizin.logbook.client.activity.LoginActivity;
import ch.unibas.medizin.logbook.client.navigation.LogBookNav;
import ch.unibas.medizin.logbook.client.ui.SkillViewImpl;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The applications basic layout.
 */
public class LogBookShell extends Composite {

	private static LogBookShellUiBinder uiBinder = GWT.create(LogBookShellUiBinder.class);

	@UiField
	SimplePanel topPanel;
	
	@UiField
	SimplePanel topPanel4;
	
	@UiField
	DockLayoutPanel masterDockPanel;
	
	@UiField
	Image imgLogBookLogo; 
	
	@UiField
	FocusPanel fpMain;
	
	LogBookConstants constants = GWT.create(LogBookConstants.class);

	@UiField
	SimplePanel logBookNavSimplePanel;

	public SimplePanel getLogBookNavSimplePanel() {
		return logBookNavSimplePanel;
	}

	interface LogBookShellUiBinder extends UiBinder<Widget, LogBookShell> {
	}

	public LogBookShell() {

		Log.debug("in LogBookShell");

		initWidget(uiBinder.createAndBindUi(this));
				
		fpMain.addMouseWheelHandler(new MouseWheelHandler() {
			
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				if(LoginActivity.popupViewImpl!=null)
					LoginActivity.popupViewImpl.hide();
				
				if(SkillViewImpl.mainClassificationSuggestBoxPopup!=null && SkillViewImpl.mainClassificationSuggestBoxPopup.getSuggestWidget()!=null)
					SkillViewImpl.mainClassificationSuggestBoxPopup.getSuggestWidget().hide();
				if(SkillViewImpl.classificationTopicSuggestBoxPopup!=null && SkillViewImpl.classificationTopicSuggestBoxPopup.getSuggestWidget()!=null)
					SkillViewImpl.classificationTopicSuggestBoxPopup.getSuggestWidget().hide();
				if(SkillViewImpl.topicSuggestBoxPoopup!=null && SkillViewImpl.topicSuggestBoxPoopup.getSuggestWidget()!=null)
					SkillViewImpl.topicSuggestBoxPoopup.getSuggestWidget().hide();
				
			}
		});
	}

	public void setNavigation(LogBookNav nav) {
		getLogBookNavSimplePanel().add(nav);
		Log.debug("node value :" +masterDockPanel.getWidget(2).getElement().getParentElement());
		masterDockPanel.getWidget(2).getElement().getParentElement().addClassName("top76");
	}
}
