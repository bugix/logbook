package logbook.client.a_nonroo.app.client.place;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.web.bindery.requestfactory.shared.RequestFactory;


/**
 * @author Manish
 *
 */
public class LoginPlace extends LogBookPlace {
	
	private String token;

	public LoginPlace(){
		Log.debug("LoginPlace");
		this.token = "LoginPlace";
	}
	
	public LoginPlace(String token){
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	public HandlerManager handler;
	
	public LoginPlace(String token,HandlerManager handler){
		this.handler=handler;
		this.token = token;	
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Tokenizer.
	 */

	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
		private final RequestFactory requests;

		public Tokenizer(RequestFactory requests) {
			Log.debug("LoginPlace.Tokenizer");
			this.requests = requests;
		}

		public LoginPlace getPlace(String token) {
			Log.debug("LoginPlace.Tokenizer.getPlace");
			return new LoginPlace(token);
		}

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
