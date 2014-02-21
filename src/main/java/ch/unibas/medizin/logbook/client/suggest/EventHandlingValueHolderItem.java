package ch.unibas.medizin.logbook.client.suggest;

import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.UIObject;

public interface EventHandlingValueHolderItem<T> extends ValueHolderItem<T>, HasAllMouseHandlers, HasClickHandlers {

	public static final String ITEM_DEFAULT_STYLE = "eu-nextstreet-SuggestItem";

	@Override
	public T getValue();

	@Override
	public void setValue(T value);

	@Override
	public void setSelected(boolean selected);

	@Override
	public void hover(boolean hover);

	@Override
	public void setStyleName(String item);

	@Override
	public UIObject getUiObject();

	@Override
	ValueRendererFactory<T, ?> getValueRendererFactory();
}
