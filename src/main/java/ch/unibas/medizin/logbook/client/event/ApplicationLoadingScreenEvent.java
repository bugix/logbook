package ch.unibas.medizin.logbook.client.event;

import ch.unibas.medizin.logbook.client.ui.ApplicationLoadingPopupViewImpl;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Here is a custom event. For comparison this is also a
 * ApplicationLoadingScreenEvent. This event extends the GwtEvent from the
 * com.google.gwt.event.shared package.
 */
public class ApplicationLoadingScreenEvent extends
		GwtEvent<ApplicationLoadingScreenHandler> {

	private static final Type<ApplicationLoadingScreenHandler> TYPE = new Type<ApplicationLoadingScreenHandler>();

	static int eventCounter = 0;
	private boolean show;

	/**
	 * Register a handler for ApplicationLoadingScreenEvent events on the
	 * eventbus.
	 * 
	 * @param eventBus
	 *            the {@link EventBus}
	 * @param handler
	 *            an {@link ApplicationLoadingScreenHandler} instance
	 * @return an {@link HandlerRegistration} instance
	 */
	public static HandlerRegistration register(EventBus eventBus,
			ApplicationLoadingScreenHandler handler) {
		return eventBus.addHandler(TYPE, handler);
	}

	public static void initialCounter() {
		eventCounter = 0;
	}

	public void display() {

		if (show) {
			// eventCounuter += ((show) ? 1 : -1);
			eventCounter++;
			ApplicationLoadingPopupViewImpl.showApplicationLoadingPopup(show);
		} else {
			eventCounter--;
			if (eventCounter <= 0) {
				eventCounter = 0;
				ApplicationLoadingPopupViewImpl
						.showApplicationLoadingPopup(false);
			}
		}
	}

	public ApplicationLoadingScreenEvent(boolean show) {
		this.show = show;
	}

	public ApplicationLoadingScreenEvent() {

	}

	@Override
	public Type<ApplicationLoadingScreenHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ApplicationLoadingScreenHandler handler) {
		handler.onEventReceived(this);
	}
}
