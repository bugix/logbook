package ch.unibas.medizin.logbook.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class SkillLevelTextAreaViewImpl extends Composite implements SkillLevelTextAreaView {

	private static final SkillLevelCheckboxViewImpllUiBinder uiBinder = GWT.create(SkillLevelCheckboxViewImpllUiBinder.class);

	interface SkillLevelCheckboxViewImpllUiBinder extends UiBinder<Widget, SkillLevelTextAreaViewImpl> {
	}

	@UiField
	TextArea commentTextArea;

	public TextArea getTextArea() {
		return commentTextArea;
	}

	public void setCheckbox(TextArea textArea) {
		commentTextArea = textArea;
	}

	public SkillLevelTextAreaViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		commentTextArea.setEnabled(false);

	}

	@Override
	public void setPresenter(presenter presenter) {

	}

	@Override
	public void setDelegate(Delegate delegate) {

	}
}
