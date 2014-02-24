package ch.unibas.medizin.logbook.client.suggest.simple;

import java.util.Map;

import ch.unibas.medizin.logbook.client.suggest.EventHandlingValueHolderItem;
import ch.unibas.medizin.logbook.client.suggest.ValueRendererFactory;
import ch.unibas.medizin.logbook.client.util.Option;

import com.google.gwt.text.shared.Renderer;

public class DefaultValueRendererFactory<T, W extends EventHandlingValueHolderItem<T>> implements ValueRendererFactory<T, W> {

	@SuppressWarnings("unchecked")
	@Override
	public W createValueRenderer(T value, String filterText, Map<String, Option<?>> options) {
		W toReturn = (W) new DefaultValueRenderer<T>(value, filterText, false, this);
		toReturn.setStyleName(EventHandlingValueHolderItem.ITEM_DEFAULT_STYLE);
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public W createValueRenderer(T value, String filterText, Map<String, Option<?>> options,Renderer<T> renderer) {
		W toReturn = (W) new DefaultValueRenderer<T>(value, filterText, false, this,renderer);
		toReturn.setStyleName(EventHandlingValueHolderItem.ITEM_DEFAULT_STYLE);
		return toReturn;
	}

	@Override
	public ValueRendererFactory.ListRenderer<T, W> createListRenderer() {
		DefaultListRenderer<T, W> defaultListRenderer = new DefaultListRenderer<T, W>();
		defaultListRenderer.setSpacing(0);
		return defaultListRenderer;
	}
}
