package ch.unibas.medizin.logbook.client.ui;

import java.util.Arrays;

import ch.unibas.medizin.logbook.client.renderer.EnumRenderer;
import ch.unibas.medizin.logbook.shared.enums.StudyYears;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;

public class StudentEditPopupViewImpl extends PopupPanel implements StudentEditPopupView {

	interface StudentEditPopupViewImplUiBinder extends UiBinder<Widget, StudentEditPopupViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);

	LogBookConstants constants = GWT.create(LogBookConstants.class);

	@UiField
	Label lblStudyYear;

	@UiField
	Label lblEmail;

	@UiField
	Button btnSave;

	@UiField
	TextBox txtEmailValue;

	@UiField
	Button btnClose;

	@UiField(provided = true)
	public ValueListBox<StudyYears> lstBoxStudyYear = new ValueListBox<StudyYears>(new EnumRenderer<StudyYears>());

	@UiHandler("btnClose")
	public void btnCloseClicked(ClickEvent event) {
	}

	public TextBox getTxtEmailValue() {
		return txtEmailValue;
	}

	public void setTxtEmailValue(String txtEmailValue) {
		this.txtEmailValue.setText(txtEmailValue);
	}

	public Label getLblStudyYear() {
		return lblStudyYear;
	}

	public void setLblStudyYear(Label lblStudyYear) {
		this.lblStudyYear = lblStudyYear;
	}

	public Label getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(Label lblEmail) {
		this.lblEmail = lblEmail;
	}

	public Button getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(Button btnSave) {
		this.btnSave = btnSave;
	}

	public Button getBtnClose() {
		return btnClose;
	}

	public void setBtnClose(Button btnClose) {
		this.btnClose = btnClose;
	}

	public ValueListBox<StudyYears> getLstBoxStudyYear() {
		return lstBoxStudyYear;
	}

	public void setLstBoxStudyYear(StudyYears studyYear) {
		lstBoxStudyYear.setValue(studyYear);
	}

	public StudentEditPopupViewImpl() {
		add(BINDER.createAndBindUi(this));
		setAnimationEnabled(true);
		center();
		setAutoHideEnabled(true);

		init();
	}

	private void init() {
		lstBoxStudyYear.setAcceptableValues(Arrays.asList(StudyYears.values()));
		lstBoxStudyYear.setValue(StudyYears.values()[0]);

		lblStudyYear.setText(constants.studyYear() + " : ");
		lblEmail.setText(constants.email() + " : ");
		btnSave.setText(constants.save());
		btnClose.setText(constants.close());
	}

	interface Binder extends UiBinder<Widget, StudentEditPopupViewImpl> {
	}
}
