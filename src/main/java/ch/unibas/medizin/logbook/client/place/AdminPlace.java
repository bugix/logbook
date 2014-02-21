package ch.unibas.medizin.logbook.client.place;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class AdminPlace extends LogBookPlace {

	private String token;

	public AdminPlace() {
		Log.debug("AdminPlace");
		token = "AdminPlace";
	}

	public AdminPlace(String token) {
		this.token = token;
	}

	@Override
	public String getToken() {
		return token;
	}

	public HandlerManager handler;

	public AdminPlace(String token, HandlerManager handler) {
		this.handler = handler;
		this.token = token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<AdminPlace> {
		public Tokenizer(RequestFactory requests) {
			Log.debug("LoginPlace.Tokenizer");
		}

		@Override
		public AdminPlace getPlace(String token) {
			Log.debug("LoginPlace.Tokenizer.getPlace");
			return new AdminPlace(token);
		}

		@Override
		public String getToken(AdminPlace place) {
			Log.debug("LoginPlace.Tokenizer.getToken");
			return place.getToken();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		return true;
	}
}
