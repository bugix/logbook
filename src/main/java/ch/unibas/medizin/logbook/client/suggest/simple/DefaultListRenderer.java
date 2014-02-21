package ch.unibas.medizin.logbook.client.suggest.simple;

import ch.unibas.medizin.logbook.client.suggest.EventHandlingValueHolderItem;
import ch.unibas.medizin.logbook.client.suggest.ValueRendererFactory.ListRenderer;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DefaultListRenderer<T, W extends EventHandlingValueHolderItem<T>> extends
		VerticalPanel implements ListRenderer<T, W> {

	@Override
	public void add(W item) {
		super.add((Widget) item);
	}

	@SuppressWarnings("unchecked")
	public W getAt(int index) {
		return (W) super.getWidget(index);
	}
}
