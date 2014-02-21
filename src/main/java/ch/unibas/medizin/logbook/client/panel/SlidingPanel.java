/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package ch.unibas.medizin.logbook.client.panel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.layout.client.Layout;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Shows one panel at a time, sliding them left or right based on the order they
 * were added. A full fledged version might implement
 * {@link com.google.gwt.user.client.ui.InsertPanel.ForIsWidget}.
 * <p>
 * Note that we implement HasWidgets so that SlidingPanel will work nicely in
 * ui.xml files.
 */
public class SlidingPanel extends ResizeComposite implements HasWidgets, HasOneWidget {

	private final List<Widget> widgets = new ArrayList<Widget>();
	private final LayoutPanel layoutPanel = new LayoutPanel();
	private int currentIndex = -1;

	public SlidingPanel() {
		initWidget(layoutPanel);
		DOM.setElementAttribute(layoutPanel.getElement(), "style", "position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px;");
	}

	public void add(IsWidget w) {
		add(asWidgetOrNull(w.asWidget()));
	}

	@Override
	public void add(Widget w) {
		widgets.remove(w);
		widgets.add(w);

		// Display the first widget added by default
		if (currentIndex < 0) {
			layoutPanel.add(w);
			currentIndex = 0;
		}
	}

	@Override
	public void clear() {
		setWidget(null);
		widgets.clear();
		currentIndex = 0;
	}

	public void destroyWidgets() {
		widgets.clear();
		currentIndex = 0;
	}

	@Override
	public Widget getWidget() {
		return widgets.get(currentIndex);
	}

	@Override
	public Iterator<Widget> iterator() {
		return Collections.unmodifiableList(widgets).iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return widgets.remove(w);
	}

	@Override
	public void setWidget(IsWidget w) {
		setWidget(asWidgetOrNull(w));
	}

	/**
	 * Set the widget to show, adding it to the end of our sliding set if we
	 * haven't seen it before. Nulls are ignored.
	 */
	@Override
	public void setWidget(Widget widget) {
		if (widget == null) {
			return;
		}

		int newIndex = widgets.indexOf(widget);

		if (newIndex < 0) {
			newIndex = widgets.size();
			add(widget);
		}

		show(newIndex);
	}

	private void show(int newIndex) {

		if (newIndex == currentIndex) {
			return;
		}
		Log.debug(Integer.toString(newIndex));

		boolean fromLeft = newIndex < currentIndex;
		currentIndex = newIndex;

		Widget widget = widgets.get(newIndex);
		final Widget current = layoutPanel.getWidget(0);

		// Initialize the layout.
		layoutPanel.add(widget);
		layoutPanel.setWidgetLeftWidth(current, 0, Unit.PCT, 100, Unit.PCT);
		if (fromLeft) {
			layoutPanel.setWidgetLeftWidth(widget, -100, Unit.PCT, 100, Unit.PCT);
		} else {
			layoutPanel.setWidgetLeftWidth(widget, 100, Unit.PCT, 100, Unit.PCT);
		}
		layoutPanel.forceLayout();

		// Slide into view.
		if (fromLeft) {
			layoutPanel.setWidgetLeftWidth(current, 100, Unit.PCT, 100, Unit.PCT);
		} else {
			layoutPanel.setWidgetLeftWidth(current, -100, Unit.PCT, 100, Unit.PCT);
		}
		layoutPanel.setWidgetLeftWidth(widget, 0, Unit.PCT, 100, Unit.PCT);
		layoutPanel.animate(500, new Layout.AnimationCallback() {
			@Override
			public void onAnimationComplete() {
				// Remove the old widget when the animation completes.
				layoutPanel.remove(current);
			}

			@Override
			public void onLayout(Layer layer, double progress) {
			}
		});
	}
}
