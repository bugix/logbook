package logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest;

import com.google.gwt.user.client.ui.ScrollPanel;

public interface SuggestWidget<T> {

	void setWidget(ScrollPanel scrollPanel);

	boolean isShowing();

	void hide();

	void show();
	void hidecall();
	
	
	void adjustPosition(int absoluteLeft, int absoluteTop);

}
