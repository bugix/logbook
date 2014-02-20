package logbook.client.a_nonroo.app.client.place;

import logbook.client.a_nonroo.app.client.LogBookNav;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.web.bindery.requestfactory.shared.RequestFactory;


/**
 * @author Manish
 *
 */
public class SkillPlace extends LogBookPlace {
	
	private String token;
	
	public static int tabIndex=0;
	
	public static LogBookNav nav=null;
	
	public SkillPlace(){
		Log.debug("SkillPlace");
		this.token = "SkillPlace";
	}
	
	public SkillPlace(String token){
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	public HandlerManager handler;
	
	public SkillPlace(String token,HandlerManager handler){
		this.handler=handler;
		this.token = token;	
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Tokenizer.
	 */

	public static class Tokenizer implements PlaceTokenizer<SkillPlace> {
		private final RequestFactory requests;

		public Tokenizer(RequestFactory requests) {
			Log.debug("SkillPlace.Tokenizer");
			this.requests = requests;
		}

		public SkillPlace getPlace(String token) {
			Log.debug("SkillPlace.Tokenizer.getPlace");
			return new SkillPlace(token);
		}

		public String getToken(SkillPlace place) {
			Log.debug("SkillPlace.Tokenizer.getToken");
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
