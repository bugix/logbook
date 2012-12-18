package  logbook.client.a_nonroo.app.client.ui;

 
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;





public class SkillViewImpl extends Composite implements SkillView{
	
	private static SkillViewImpllUiBinder uiBinder = GWT
			.create(SkillViewImpllUiBinder.class);

	interface SkillViewImpllUiBinder extends UiBinder<Widget, SkillViewImpl> {
	}

	private Delegate delegate;
	
	private presenter presenter;
	
	@UiField
	Label skillLabel;
	
	/*@UiField
	FocusPanel studentPanel;
	
	public FocusPanel getStudentPanel() {
		return studentPanel;
	}*/
	

	public Label getSkillLbl() {
		return skillLabel;
	}

	public SkillViewImpl() {
	
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
