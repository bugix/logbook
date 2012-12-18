package  logbook.client.a_nonroo.app.client.ui;

 
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;





public class ProgressViewImpl extends Composite implements ProgressView{
	
	private static ProgressViewImpllUiBinder uiBinder = GWT
			.create(ProgressViewImpllUiBinder.class);

	interface ProgressViewImpllUiBinder extends UiBinder<Widget, ProgressViewImpl> {
	}

	private Delegate delegate;
	
	private presenter presenter;
	
	@UiField
	Label progressLabel;
	
	/*@UiField
	FocusPanel studentPanel;
	
	public FocusPanel getStudentPanel() {
		return studentPanel;
	}*/
	

	public Label getProgressLbl() {
		return progressLabel;
	}

	public ProgressViewImpl() {
	
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
