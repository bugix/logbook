package ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui;

 
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


public class AdminViewImpl extends Composite implements AdminView{
	
	private static AdminViewImpllUiBinder uiBinder = GWT
			.create(AdminViewImpllUiBinder.class);

	interface AdminViewImpllUiBinder extends UiBinder<Widget, AdminViewImpl> {
	}

	private Delegate delegate;
	
	private presenter presenter;

	LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	@UiField
	Label lblPersonnelInformation;
		
	@UiField
	Label lblName;
	
	@UiField
	Label lblNameVal;
	
	public Label getLblNameVal() {
		return lblNameVal;
	}

	public void setLblNameVal(Label lblNameVal) {
		this.lblNameVal = lblNameVal;
	}

	@UiField
	Label lblPrename;
	
	public Label getLblPrename() {
		return lblPrename;
	}

	public void setLblPrename(Label lblPrename) {
		this.lblPrename = lblPrename;
	}

	@UiField
	Label lblPrenameVal;
	
	public Label getLblPrenameVal() {
		return lblPrenameVal;
	}

	public void setLblPrenameVal(Label lblPrenameVal) {
		this.lblPrenameVal = lblPrenameVal;
	}

	public Label getLblPersonnelInformation() {
		return lblPersonnelInformation;
	}

	public void setLblPersonnelInformation(Label lblPersonnelInformation) {
		this.lblPersonnelInformation = lblPersonnelInformation;
	}

	@UiField
	Label lblEmail;
	
	public Label getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(Label lblEmail) {
		this.lblEmail = lblEmail;
	}

	public Label getLblEmailVal() {
		return lblEmailVal;
	}

	public void setLblEmailVal(Label lblEmailVal) {
		this.lblEmailVal = lblEmailVal;
	}

	@UiField
	Label lblEmailVal;
	
	@UiField
	Label lblExport;
	
	public Label getLblExport() {
		return lblExport;
	}

	public void setLblExport(Label lblExport) {
		this.lblExport = lblExport;
	}
	
	@UiField
	CheckBox exportCheckbox;
	
	@UiField
	Button btnExportLogBook;
	
	@UiHandler("btnExportLogBook")
	public void exportStudentClicked(ClickEvent event){
		delegate.exportStudentClicked(exportCheckbox.getValue());
	}

	public AdminViewImpl() {
	
		initWidget(uiBinder.createAndBindUi(this));
		init();
	}

	private void init() 
	{
	
		lblPersonnelInformation.setText(constants.personnelInformation());
		lblName.setText(constants.name()+": ");
		lblPrename.setText(constants.preName()+": ");
		lblEmail.setText(constants.email()+": ");
		lblExport.setText(constants.changeFilalizeToExport());
		btnExportLogBook.setText(constants.exportLogBook());
	}
	
	private void initLoginData() 
	{		
	}

	

	@Override
	public void setPresenter(presenter presenter) {
		this.presenter=presenter;
		
	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate=delegate;
		
	}

}
