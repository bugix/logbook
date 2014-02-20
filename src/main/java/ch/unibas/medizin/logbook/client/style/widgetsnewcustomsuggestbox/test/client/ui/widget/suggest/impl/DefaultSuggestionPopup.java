
package ch.unibas.medizin.logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl;

import ch.unibas.medizin.logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.SuggestWidget;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;


public class DefaultSuggestionPopup<T> extends PopupPanel implements
		SuggestWidget<T> {
	private static final String POPUP_STYLE = "eu-nextstreet-SuggestPopup"; // Border and Transperant

	public DefaultSuggestionPopup() {
		this(true, false);
		super.getElement().getStyle().setZIndex(2);
		this.getElement().getStyle().setPosition(Position.RELATIVE);
	}

	public DefaultSuggestionPopup(boolean autoHide) {
		this(autoHide, false);
		super.getElement().getStyle().setZIndex(2);
		this.getElement().getStyle().setPosition(Position.RELATIVE);
	}

	public DefaultSuggestionPopup(boolean autoHide, boolean modal) {
		super(autoHide, modal);
		setStylePrimaryName(POPUP_STYLE);
		super.getElement().getStyle().setZIndex(2);
	}

	@Override
	public void setWidget(ScrollPanel scrollPanel) {
		//this.getElement().getStyle().setDisplay(Display.INLINE);
		super.setWidget(scrollPanel);
	}

	@Override
	public void adjustPosition(int absoluteLeft, int absoluteTop) {
		super.setPopupPosition(absoluteLeft, absoluteTop);
	}

	@Override
	public void hide() {
		
		super.hide();
	}

	@Override
	public void hidecall() {
		// TODO Auto-generated method stub
	}		
}
