package ch.unibas.medizin.logbook.client.ui;

import ch.unibas.medizin.logbook.client.proxy.SkillProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SkillLevelIconButtonViewImpl extends Composite implements SkillLevelIconButtonView {

	private static final SkillLevelIconButtonViewImpllUiBinder uiBinder = GWT.create(SkillLevelIconButtonViewImpllUiBinder.class);

	interface SkillLevelIconButtonViewImpllUiBinder extends UiBinder<Widget, SkillLevelIconButtonViewImpl> {
	}

	private boolean isSave;

	private String skillcomment;

	public String getSkillcomment() {
		return skillcomment;
	}

	public void setSkillcomment(String skillcomment) {
		this.skillcomment = skillcomment;
	}

	public boolean isSave() {
		return isSave;
	}

	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}

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
		skillIconButton = iconButton;
	}

	private SkillProxy skillProxy;

	public SkillProxy getSkillProxy() {
		return skillProxy;
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

	public SkillLevelIconButtonViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(presenter presenter) {

	}

	@Override
	public void setDelegate(Delegate delegate) {

	}
}
