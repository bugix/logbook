package ch.unibas.medizin.logbook.client;

import java.util.ArrayList;
import java.util.List;

import ch.unibas.medizin.logbook.client.event.RecordChangeEvent;
import ch.unibas.medizin.logbook.client.place.AdminPlace;
import ch.unibas.medizin.logbook.client.place.LogBookDetailsPlace;
import ch.unibas.medizin.logbook.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.place.ProgressPlace;
import ch.unibas.medizin.logbook.client.place.SkillPlace;
import ch.unibas.medizin.logbook.client.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.shared.enums.Locale;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.inject.Inject;

public class LogBookHeaderLogic implements LogBookHeader.Delegate {
	private LogBookRequestFactory requestFactory;
	private LogBookConstants constants = GWT.create(LogBookConstants.class);
	private List<BreadCrumb> breadCrumbs = new ArrayList<BreadCrumb>();

	@Inject
	public LogBookHeaderLogic(LogBookRequestFactory requestFactory, PlaceController placeController, EventBus eventBus) {
		this.requestFactory = requestFactory;
		PlaceChangeEventHandler eventHandler = new PlaceChangeEventHandler();
		eventBus.addHandler(PlaceChangeEvent.TYPE, eventHandler);
		Log.debug("new OsMaHeaderLogic()");
	}

	private class BreadCrumb {
		private String description;

		public BreadCrumb(String desc) {
			description = desc;
		}

		public String getDescription() {
			return description;
		}
	}

	private class PlaceChangeEventHandler implements PlaceChangeEvent.Handler {
		@Override
		public void onPlaceChange(PlaceChangeEvent event) {
			Log.debug("onPlaceChange()");
			Place newPlace = event.getNewPlace();
			removeOldPlace(newPlace);
			addNewPlace(newPlace);
		}
	}

	private void removeOldPlace(Place newPlace) {
		int indexOfLastCrumb = breadCrumbs.size() - 1;
		if (indexOfLastCrumb < 0) {
			return;
		}

		BreadCrumb lastCrumb = breadCrumbs.get(indexOfLastCrumb);
		if (lastCrumb == null) {
			return;
		}

		logBreadCrumbs();
	}

	private void addRootPlace(Place place) {
		String placeDescription;
		if (place instanceof LoginPlace) {
			placeDescription = constants.login();
		} else if (place instanceof AdminPlace) {
			placeDescription = constants.adminLogin();
		} else if (place instanceof SkillPlace) {
			placeDescription = constants.skill();
		} else if (place instanceof ProgressPlace) {
			placeDescription = constants.progress();
		} else {
			Log.warn("Unknown instance of place");
			placeDescription = "?";
		}
		breadCrumbs.add(new BreadCrumb(placeDescription));
		logBreadCrumbs();
	}

	private void addNewPlace(Place place) {
		if (place instanceof LogBookDetailsPlace) {
		} else {
			addRootPlace(place);
		}
	}

	private void logBreadCrumbs() {
		if (Log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder("BreadCrumbs: ");
			for (BreadCrumb element : breadCrumbs) {
				sb.append(element.getDescription());
				sb.append(" > ");
			}
			Log.debug(sb.toString());
		}
	}

	@Override
	public void changeLocale(Locale locale) {
		int indexOfHash;
		String newLocaleString;
		String url = Location.getHref();

		url = url.replaceAll("locale=[a-z]{2,2}", "locale=" + locale.toString());
		if (url.indexOf("locale") < 0) {
			if (url.indexOf("?") > -1) {
				newLocaleString = "&locale=" + locale.toString();
			} else {
				newLocaleString = "?locale=" + locale.toString();
			}

			if ((indexOfHash = url.indexOf("#")) > -1) {
				url = url.substring(0, indexOfHash) + newLocaleString + url.substring(indexOfHash);
			} else {
				url = url + newLocaleString;
			}
		}
		Window.open(url, "_self", "");
	}

	@Override
	public void changeRecordValue(String val) {
		Log.debug("~~Selected Record Value : " + val);
		requestFactory.getEventBus().fireEvent(new RecordChangeEvent(val));
	}
}
