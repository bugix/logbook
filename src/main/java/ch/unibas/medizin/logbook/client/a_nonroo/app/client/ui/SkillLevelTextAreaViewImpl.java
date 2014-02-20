package ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class SkillLevelTextAreaViewImpl extends Composite implements SkillLevelTextAreaView{

	private static final SkillLevelCheckboxViewImpllUiBinder uiBinder = GWT.create(SkillLevelCheckboxViewImpllUiBinder.class);
	
	interface SkillLevelCheckboxViewImpllUiBinder extends UiBinder<Widget, SkillLevelTextAreaViewImpl> {
	}
	
	private Delegate delegate;

	private presenter presenter;
	
	private SkillLevelTextAreaViewImpl skillLevelTextAreaViewImpl;
	
	/*private int classificationTopicRow=0;
	
	public int getClassificationTopicRow() {
		return classificationTopicRow;
	}

	public void setClassificationTopicRow(int classificationTopicRow) {
		this.classificationTopicRow = classificationTopicRow;
	}
*/
/*	public int getTopicRow() {
		return topicRow;
	}

	public void setTopicRow(int topicRow) {
		this.topicRow = topicRow;
	}

	public int getMainClassificationRow() {
		return mainClassificationRow;
	}

	public void setMainClassificationRow(int mainClassificationRow) {
		this.mainClassificationRow = mainClassificationRow;
	}

	private int topicRow=0;
	
	private int mainClassificationRow=0;
*/	
	@UiField
	TextArea commentTextArea;
	
	public TextArea getTextArea() {
		return commentTextArea;
	}

	public void setCheckbox(TextArea textArea) {
		this.commentTextArea = textArea;
	}

	/*@UiHandler("checkbox")
	public void checkboxSelected(ValueChangeEvent<Boolean> event){
		//Window.alert("" +event.getValue() + "gwt skill :" + skillProxy.getId());
		delegate.chekBoxSelected(skillProxy,isLevel1,skillLevelTextAreaViewImpl);
		
	}*/
	
	/*private SkillProxy skillProxy;
	
	public SkillProxy getSkillProxy() {
		return skillProxy;
	}
	
	public boolean isLevel1=false;
	public boolean isLevel1() {
		return isLevel1;
	}

	public void setLevel1(boolean isLevel1) {
		this.isLevel1 = isLevel1;
	}

	public void setSkillProxy(SkillProxy skillProxy) {
		this.skillProxy = skillProxy;
	}

	public int row; 
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int column;
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
*/
	public SkillLevelTextAreaViewImpl()
	{
		skillLevelTextAreaViewImpl=this;
		initWidget(uiBinder.createAndBindUi(this));
		this.commentTextArea.setEnabled(false);
		
		
	}

	@Override
	public void setPresenter(presenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
		
	}
	
	
}
