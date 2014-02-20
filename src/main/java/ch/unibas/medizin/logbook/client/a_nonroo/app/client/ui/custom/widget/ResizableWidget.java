package ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui.custom.widget;

import com.google.gwt.user.client.Element;

public interface ResizableWidget {
  /**
   * Get the widget's element.
   */
  Element getElement();

  /**
   * Check if this widget is attached to the page.
   *
   * @return true if the widget is attached to the page
   */
  boolean isAttached();

  /**
   * This method is called when the dimensions of the parent element change.
   * Subclasses should override this method as needed.
   *
   * @param width the new client width of the element
   * @param height the new client height of the element
   */
  void onResize(int width, int height);
}
