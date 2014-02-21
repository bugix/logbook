package ch.unibas.medizin.logbook.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationLoadingPopupViewImpl extends DialogBox implements
		ApplicationLoadingPopupView {

	private static ApplicationLoadingPopupViewImplUiBinder uiBinder = GWT
			.create(ApplicationLoadingPopupViewImplUiBinder.class);

	interface ApplicationLoadingPopupViewImplUiBinder extends
			UiBinder<Widget, ApplicationLoadingPopupViewImpl> {
	}

	@UiField
	Image loading;

	static private ApplicationLoadingPopupViewImpl applicationLoadingPopupViewImpl;

	private ApplicationLoadingPopupViewImpl() {

		setWidget(uiBinder.createAndBindUi(this));
		loading.setUrl("logbook/gwt/logbook/images/loader.gif");

		setGlassEnabled(true);
		setAnimationEnabled(true);
		setAutoHideEnabled(false);

		loading.setWidth("70px");
		loading.setHeight("70px");
		
		//setPopupPosition(getAbsoluteLeft() / 2, getAbsoluteTop() / 2);
		 center();
		this.getElement().removeClassName("gwt-DialogBox");
		 this.getElement().getStyle().setZIndex(1);

	}

	public static void showApplicationLoadingPopup(boolean show) {

		if (show) {
			if (applicationLoadingPopupViewImpl == null) {
				applicationLoadingPopupViewImpl = new ApplicationLoadingPopupViewImpl();
			}
			if (!applicationLoadingPopupViewImpl.isShowing()) {
				applicationLoadingPopupViewImpl.show();
			}
		} else if (applicationLoadingPopupViewImpl != null) {
			applicationLoadingPopupViewImpl.hide();
		}
	}

}
