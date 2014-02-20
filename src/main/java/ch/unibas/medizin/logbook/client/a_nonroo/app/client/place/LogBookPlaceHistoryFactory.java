package logbook.client.a_nonroo.app.client.place;

import logbook.client.a_nonroo.app.client.LogBookNav;
import logbook.client.a_nonroo.app.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;



public class LogBookPlaceHistoryFactory {
	

private final LoginPlace.Tokenizer placeLoginTokenizer ; 

private final SkillPlace.Tokenizer placeSkillTokenizer;

private final ProgressPlace.Tokenizer placeProgressTokenizer;

	@Inject
	public LogBookPlaceHistoryFactory(LogBookRequestFactory requestFactory) {
		Log.debug("LogBookPlaceHistoryFactory.Konstruktor");
		this.placeLoginTokenizer= new LoginPlace.Tokenizer(requestFactory); 
		this.placeSkillTokenizer = new SkillPlace.Tokenizer(requestFactory);
		this.placeProgressTokenizer = new ProgressPlace.Tokenizer(requestFactory);
		
	}

	public PlaceTokenizer<LoginPlace> getLoginPlaceTokenizer()
	{
		LogBookNav.logBookNav.masterActivityManager.setDisplay((SimplePanel)LogBookNav.logBookNav.getMainLoogBookTabpanel().getWidget(0));
		LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(0,false);
		return placeLoginTokenizer;
	}

	public PlaceTokenizer<SkillPlace> getSkillPlaceTokenizer()
	{
		
			LogBookNav.logBookNav.masterActivityManager.setDisplay((SimplePanel)LogBookNav.logBookNav.getMainLoogBookTabpanel().getWidget(1));
			
				LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(1,false);
			
			SkillPlace.tabIndex=1;
		
		return placeSkillTokenizer;
	}
	public PlaceTokenizer<ProgressPlace> getProgressPlaceTokenizer()
	{
		LogBookNav.logBookNav.masterActivityManager.setDisplay((SimplePanel)LogBookNav.logBookNav.getMainLoogBookTabpanel().getWidget(2));
		
			LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(2,false);
		
		ProgressPlace.tabIndex=1;
		return placeProgressTokenizer;
	}

}
