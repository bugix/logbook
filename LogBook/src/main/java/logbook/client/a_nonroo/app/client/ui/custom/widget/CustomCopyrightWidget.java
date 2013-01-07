package logbook.client.a_nonroo.app.client.ui.custom.widget;

import logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CustomCopyrightWidget extends Composite {

	private static CustomCopyrightWidgetUiBinder uiBinder = GWT
			.create(CustomCopyrightWidgetUiBinder.class);

	interface CustomCopyrightWidgetUiBinder extends
			UiBinder<Widget, CustomCopyrightWidget> {
	}
	
	LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	@UiField
	Label lblPoweredBy;
	
	@UiField
	Label lblPoweredByName;
	
	@UiField
	Label lblLine;
	
	@UiField
	Label lblContact;
	
	public CustomCopyrightWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		lblPoweredBy.setText(constants.poweredBy());
		lblPoweredByName.setText(constants.LernzentrumMedizin());
		lblLine.setText(constants.copyrightSeperator());
		lblContact.setText(constants.contact());
	}
}
