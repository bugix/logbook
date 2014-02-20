package ch.unibas.medizin.logbook.client;

import java.util.ArrayList;
import java.util.List;

import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.AdminPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.LogBookDetailsPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.ProgressPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.client.place.SkillPlace;
import ch.unibas.medizin.logbook.client.a_nonroo.app.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.client.managed.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.server.domain.MainClassification;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;
import ch.unibas.medizin.logbook.shared.scaffold.Locale;
import ch.unibas.medizin.logbook.shared.scaffold.Operation;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class LogBookHeaderLogic implements LogBookHeader.Delegate {
	private LogBookRequestFactory requestFactory;
	private PlaceController placeController;
	private LogBookConstants constants = GWT.create(LogBookConstants.class);
	private List<BreadCrumb> breadCrumbs = new ArrayList<BreadCrumb>();
//	private EnumRenderer<Operation> renderer = new EnumRenderer<Operation>();
	private Place currentPlace;
	
	@Inject
	public LogBookHeaderLogic(LogBookRequestFactory requestFactory, PlaceController placeController, EventBus eventBus) {
		this.requestFactory = requestFactory;
		this.placeController = placeController;
		
		PlaceChangeEventHandler eventHandler = new PlaceChangeEventHandler();
		eventBus.addHandler(PlaceChangeEvent.TYPE, eventHandler);
//		addNewPlace(placeController.getWhere());
		Log.debug("new OsMaHeaderLogic()");
	}
	
	private class BreadCrumb {
		private Place place;
		private String description;
		
		public BreadCrumb(Place place, String desc) {
			this.place = place;
			this.description = desc;
		}
		
		public Place getPlace() {
			return place;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String desc) {
			this.description = desc;
		}
	}
	
	private class PlaceChangeEventHandler implements PlaceChangeEvent.Handler {
		@Override
		public void onPlaceChange(PlaceChangeEvent event) {
			Log.debug("onPlaceChange()");
			Place newPlace = event.getNewPlace();
			currentPlace = newPlace;
			removeOldPlace(newPlace);
			addNewPlace(newPlace);
		}
	}
	
	private class ObjectReceiver extends Receiver<Object> {
		private BreadCrumb crumb;
		
		public ObjectReceiver(BreadCrumb crumb) {
			this.crumb = crumb;
		}
		
		@Override
		public void onSuccess(Object response) {
			String desc = crumb.getDescription();
			if (response instanceof MainClassificationProxy) {
				MainClassificationProxy proxy = (MainClassificationProxy) response;
				if (proxy.getId() != null) {
					desc += proxy.getId() + " " + proxy.getId();
				}
			} 
			
			else {
				Log.warn("unknown proxy: " + response.toString());
			}
			crumb.setDescription(desc);
			breadCrumbs.add(crumb);
			logBreadCrumbs();
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
		
		/*if (newPlace instanceof OsMaDetailsPlace) {
			if (lastCrumb.getPlace() instanceof OsMaDetailsPlace) {
				breadCrumbs.remove(indexOfLastCrumb);
			}
		} else {
			breadCrumbs.remove(indexOfLastCrumb--);
			if (indexOfLastCrumb >= 0) {
				breadCrumbs.remove(indexOfLastCrumb);
			}
		}*/
		logBreadCrumbs();
	}
	
	/*private void addDetailsPlace(LogBookDetailsPlace place) {
		String placeDescription;
		if (place.getOperation() == Operation.CREATE) {
			placeDescription = renderer.render(place.getOperation());
			breadCrumbs.add(new BreadCrumb((Place) place, placeDescription));
			logBreadCrumbs();
		} else {
			placeDescription = renderer.render(place.getOperation()) + ": ";
			requestFactory.find(place.getProxyId()).fire(new ObjectReceiver(new BreadCrumb((Place)place, placeDescription)));
		}
	}*/
	
	private void addRootPlace(Place place) {
		String placeDescription;
		if (place instanceof LoginPlace) {
			placeDescription = constants.login();
		}
		else if (place instanceof AdminPlace) {
			placeDescription = constants.adminLogin();
		}
		else if (place instanceof SkillPlace) {
			placeDescription = constants.skill();
		}
		else if (place instanceof ProgressPlace) {
			placeDescription = constants.progress();
		}else {
			Log.warn("Unknown instance of place");
			placeDescription = "?";
		}
		breadCrumbs.add(new BreadCrumb(place, placeDescription));
		logBreadCrumbs();
	}

	private void addNewPlace(Place place) {
		if (place instanceof LogBookDetailsPlace) {
			//addDetailsPlace((LogBookDetailsPlace) place);
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
	
		Log.info("~~Selected Record Value : " + val);
		//handlerManager.fireEvent(new RecordChangeEvent(val));
		requestFactory.getEventBus().fireEvent(new RecordChangeEvent(val));
		
	}
}
