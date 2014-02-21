package ch.unibas.medizin.logbook.client.place;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class ProgressPlace extends LogBookPlace {
	
	private String token;
	
	public static int tabIndex=0;
	
	public ProgressPlace(){
		Log.debug("ProgressPlace");
		this.token = "ProgressPlace";
	}
	
	public ProgressPlace(String token){
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	public HandlerManager handler;
	
	public ProgressPlace(String token,HandlerManager handler){
		this.handler=handler;
		this.token = token;	
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<ProgressPlace> {
		private final RequestFactory requests;

		public Tokenizer(RequestFactory requests) {
			Log.debug("ProgressPlace.Tokenizer");
			this.requests = requests;
		}

		public ProgressPlace getPlace(String token) {
			Log.debug("ProgressPlace.Tokenizer.getPlace");
			return new ProgressPlace(token);
		}

		public String getToken(ProgressPlace place) {
			Log.debug("ProgressPlace.Tokenizer.getToken");
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
