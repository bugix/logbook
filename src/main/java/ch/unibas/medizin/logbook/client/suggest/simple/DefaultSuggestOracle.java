
package ch.unibas.medizin.logbook.client.suggest.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ch.unibas.medizin.logbook.client.suggest.SuggestOracle;
import ch.unibas.medizin.logbook.client.util.Option;


public class DefaultSuggestOracle<T> extends SuggestOracle<T> {

	protected List<T>	possiblilities	= new ArrayList<T>();

	@Override
	public void requestSuggestions(SuggestOracle.Request request,
			SuggestOracle.Callback<T> callback) {
		String text = request.getQuery();
		List<T> toReturn = new ArrayList<T>();
		for (T t : possiblilities) {
			if (accept(text, t))
				toReturn.add(t);
		}
		callback.onSuggestionsReady(request, new Response<T>(toReturn));

	}

	public void add(T t) {
		possiblilities.add(t);
	}

	public void clear() {
		possiblilities.clear();
	}

	public List<T> getPossiblilities() {
		return possiblilities;
	}

	public void setPossiblilities(List<T> possiblilities) {
		this.possiblilities = possiblilities;

			
	}

	
	protected boolean accept(String text, T t) {
		Map<String, Option<?>> options = suggestBox.getOptions();
		//boolean caseSensitive = BooleanOption.isEnabled(DefaultOptions.CASE_SENSITIVE.name(), options);
		//boolean caseSensitive = BooleanOption.isEnabled("CASE_SENSITIVE", options);
		boolean caseSensitive = false;
		String stringFormula = suggestBox.toString(t);
		String stringValue = caseSensitive ? stringFormula : stringFormula.toUpperCase();
		String textValue = caseSensitive ? text : text.toUpperCase();
		
		//boolean startsWith = BooleanOption.isEnabled(DefaultOptions.STARTS_WITH.name(), options);
		//boolean startsWith = BooleanOption.isEnabled("STARTS_WITH", options);
		boolean startsWith = false;
		if (startsWith ? stringValue.startsWith(textValue) : (stringValue.indexOf(textValue) != -1)) {
			return true;
		}
		return false;
	}
}
