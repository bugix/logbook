package ch.unibas.medizin.logbook.client.place;

import ch.unibas.medizin.logbook.client.navigation.LogBookNav;
import ch.unibas.medizin.logbook.client.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class LogBookPlaceHistoryFactory {

	private final LoginPlace.Tokenizer placeLoginTokenizer;

	private final SkillPlace.Tokenizer placeSkillTokenizer;

	private final ProgressPlace.Tokenizer placeProgressTokenizer;

	@Inject
	public LogBookPlaceHistoryFactory(LogBookRequestFactory requestFactory) {
		Log.debug("LogBookPlaceHistoryFactory.Konstruktor");
		placeLoginTokenizer = new LoginPlace.Tokenizer(requestFactory);
		placeSkillTokenizer = new SkillPlace.Tokenizer(requestFactory);
		placeProgressTokenizer = new ProgressPlace.Tokenizer(requestFactory);
	}

	public PlaceTokenizer<LoginPlace> getLoginPlaceTokenizer() {
		LogBookNav.logBookNav.masterActivityManager.setDisplay((SimplePanel) LogBookNav.logBookNav.getMainLoogBookTabpanel().getWidget(0));
		LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(0, false);
		return placeLoginTokenizer;
	}

	public PlaceTokenizer<SkillPlace> getSkillPlaceTokenizer() {

		LogBookNav.logBookNav.masterActivityManager.setDisplay((SimplePanel) LogBookNav.logBookNav.getMainLoogBookTabpanel().getWidget(1));

		LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(1, false);

		SkillPlace.tabIndex = 1;

		return placeSkillTokenizer;
	}

	public PlaceTokenizer<ProgressPlace> getProgressPlaceTokenizer() {
		LogBookNav.logBookNav.masterActivityManager.setDisplay((SimplePanel) LogBookNav.logBookNav.getMainLoogBookTabpanel().getWidget(2));

		LogBookNav.logBookNav.getMainLoogBookTabpanel().selectTab(2, false);

		ProgressPlace.tabIndex = 1;
		return placeProgressTokenizer;
	}
}
