package  logbook.client.a_nonroo.app.client.ui;

 
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;





public class StudentInformationViewImpl extends Composite implements StudentInformationView{
	
	private static StudentInformationViewImpllUiBinder uiBinder = GWT
			.create(StudentInformationViewImpllUiBinder.class);

	interface StudentInformationViewImpllUiBinder extends UiBinder<Widget, StudentInformationViewImpl> {
	}

	private Delegate delegate;
	
	private presenter presenter;
	
	@UiField
	Label studentLbl;
	
	/*@UiField
	FocusPanel studentPanel;
	
	public FocusPanel getStudentPanel() {
		return studentPanel;
	}*/
	

	public Label getStudentLbl() {
		return studentLbl;
	}

	public StudentInformationViewImpl() {
	
		initWidget(uiBinder.createAndBindUi(this));
		
	
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
