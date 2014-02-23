package ch.unibas.medizin.logbook.client.widget;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AdvancedTextBox extends TextBox implements HasDoubleClickHandlers {
	private static final String READ_ONLY_TEXT_STYLE = "eu-nextstreet-AdvancedTextBoxReadOnlyText";
	protected String defaultText;
	protected String defaultTextStyle;
	protected String errorTextStyle;
	protected String mandatoryTextStyle;
	protected String readOnlyTextStyle;
	protected boolean mandatory;
	protected Widget representer;

	public AdvancedTextBox() {
		this(null);
		setVisibleLength(10);
		Log.info("Constructor1");
	}

	public AdvancedTextBox(final String defautText) {
		Log.info("Constructor2");
		setVisibleLength(10);
		defaultText = defautText;
		addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent event) {
				String text = AdvancedTextBox.this.getText();
				if (defaultText == null || !defaultText.equals(text)) {
					setSelectionRange(0, text.length());
				} else {
					AdvancedTextBox.super.setText("");
				}
			}
		});

		addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				handleDefaultText();
			}
		});

		addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
			}
		});
	}

	@Override
	public HandlerRegistration addDoubleClickHandler(final DoubleClickHandler handler) {
		return addDomHandler(handler, DoubleClickEvent.getType());
	}

	@Override
	public void setText(String text) {
		super.setText(text);
		handleDefaultText();
		setCursorPos(0);
	}

	/**
	 * If the box text is empty fills it with the default value
	 * 
	 */
	protected void handleDefaultText() {
		if (defaultText != null && defaultText.length() > 0) {
			boolean empty = isEmptyTextField();
			if (empty && !isReadOnly()) {
				super.setText(defaultText);
			}
		}
	}

	protected boolean isEmptyTextField() {
		String text = getText();
		return text == null || text.trim().length() == 0;
	}

	public boolean isEmpty() {
		return isEmptyTextField() || (defaultText == null ? true : defaultText.equals(getText()));
	}

	public String getTextValue() {
		String text = super.getText();
		if (text.trim().equals(defaultText)) {
			return "";
		}
		return text;
	}

	public void setDefaultText(String text) {
		defaultText = text;
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		if (defaultText != null && isEmptyTextField()) {
			setText(defaultText);
		}
	}

	public String getReadOnlyTextStyle() {
		if (readOnlyTextStyle == null) {
			return READ_ONLY_TEXT_STYLE;
		}
		return readOnlyTextStyle;
	}

	public void setReadOnlyTextStyle(String readOnlyTextStyle) {
		this.readOnlyTextStyle = readOnlyTextStyle;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		removeStyleName(getReadOnlyTextStyle());
		super.setReadOnly(readOnly);
		if (readOnly) {
			String text = getText();
			if (defaultText != null && text != null && defaultText.equals(text)) {
				setText("");
			}
		} else {
			handleDefaultText();
		}
	}

	@Override
	public void removeStyleName(String style) {
		super.removeStyleName(style);
	}

	@Override
	public void addStyleName(String style) {
		super.addStyleName(style);
	}

	public Widget getRepresenter() {
		return representer;
	}

	public void setRepresenter(Widget representer) {
		this.representer = representer;
	}
}