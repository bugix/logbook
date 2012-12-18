package logbook.client.a_nonroo.app.client.place;

import com.google.gwt.place.shared.Place;

public abstract class LogBookPlace extends Place {
	public abstract String getToken();
	
	public abstract void setToken(String token);
}
