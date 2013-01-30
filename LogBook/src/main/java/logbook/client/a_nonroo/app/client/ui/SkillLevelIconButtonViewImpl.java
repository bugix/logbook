package logbook.client.a_nonroo.app.client.ui;

import logbook.client.managed.proxy.SkillProxy;
import logbook.client.style.widgets.IconButton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SkillLevelIconButtonViewImpl extends Composite implements SkillLevelIconButtonView{

	private static final SkillLevelIconButtonViewImpllUiBinder uiBinder = GWT.create(SkillLevelIconButtonViewImpllUiBinder.class);
	
	interface SkillLevelIconButtonViewImpllUiBinder extends UiBinder<Widget, SkillLevelIconButtonViewImpl> {
	}
	
	private Delegate delegate;

	private presenter presenter;
	
	private SkillLevelIconButtonViewImpl skillLevelIconButtonViewImpl;
	
	private boolean isSave;
	
	public boolean isSave() {
		return isSave;
	}

	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}

	/*private int classificationTopicRow=0;
	
	public int getClassificationTopicRow() {
		return classificationTopicRow;
	}

	public void setClassificationTopicRow(int classificationTopicRow) {
		this.classificationTopicRow = classificationTopicRow;
	}

	public int getTopicRow() {
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
	DivElement skillIconButton;
	
	@UiField
	HorizontalPanel editButtonHP;
		
	public HorizontalPanel getEditButtonHP() {
		return editButtonHP;
	}

	public void setEditButtonHP(HorizontalPanel editButtonHP) {
		this.editButtonHP = editButtonHP;
	}

	public DivElement getIconButton() {
		return skillIconButton;
	}

	public void setIconButton(DivElement iconButton) {
		this.skillIconButton = iconButton;
	}

	/*@UiHandler("skillIconButton")
	public void iconButtonClicked(ClickEvent event){
		
		System.out.println("is Save" + isSave);
		if(this.isSave==false)
		{
			this.isSave=true;			
			this.skillIconButton.setClassName("ui-icon ui-icon-disk");
		}
		else{
			
			this.isSave=false;
			this.skillIconButton.setClassName("ui-icon ui-icon-pencil");
		}
		
		//Window.alert("" +event.getValue() + "gwt skill :" + skillProxy.getId());
		delegate.iconButtonClicked(skillProxy,skillLevelIconButtonViewImpl);
		
	}*/
	
	private SkillProxy skillProxy;
	
	public SkillProxy getSkillProxy() {
		return skillProxy;
	}
	
	/*public boolean isLevel1=false;
	public boolean isLevel1() {
		return isLevel1;
	}

	public void setLevel1(boolean isLevel1) {
		this.isLevel1 = isLevel1;
	}*/

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

	public SkillLevelIconButtonViewImpl()
	{
		skillLevelIconButtonViewImpl=this;
		initWidget(uiBinder.createAndBindUi(this));
		
		
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
