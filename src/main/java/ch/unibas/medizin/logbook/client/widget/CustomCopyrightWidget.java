package ch.unibas.medizin.logbook.client.widget;

import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
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
	Anchor anchorPoweredByName;
	
	@UiField
	Label lblLine;
	
	@UiField
	Anchor anchorContact;
	
	public CustomCopyrightWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		lblPoweredBy.setText(constants.poweredBy());
		anchorPoweredByName.setText(constants.LernzentrumMedizin());
		anchorPoweredByName.setHref(constants.LernzentrumMedizinHref());
		lblLine.setText(constants.copyrightSeperator());
		anchorContact.setText(constants.contact());
		anchorContact.setHref(constants.contactHref());
		
	}
}
