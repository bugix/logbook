package ch.unibas.medizin.logbook.client.place;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class LoginPlace extends LogBookPlace {

	private String token;

	public LoginPlace() {
		Log.debug("LoginPlace");
		token = "LoginPlace";
	}

	public LoginPlace(String token) {
		this.token = token;
	}

	@Override
	public String getToken() {
		return token;
	}

	public HandlerManager handler;

	public LoginPlace(String token, HandlerManager handler) {
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
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
		public Tokenizer(RequestFactory requests) {
			Log.debug("LoginPlace.Tokenizer");
		}

		@Override
		public LoginPlace getPlace(String token) {
			Log.debug("LoginPlace.Tokenizer.getPlace");
			return new LoginPlace(token);
		}

		@Override
		public String getToken(LoginPlace place) {
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
