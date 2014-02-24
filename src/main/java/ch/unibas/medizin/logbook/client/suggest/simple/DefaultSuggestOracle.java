package ch.unibas.medizin.logbook.client.suggest.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ch.unibas.medizin.logbook.client.suggest.SuggestOracle;
import ch.unibas.medizin.logbook.client.util.Option;

public class DefaultSuggestOracle<T> extends SuggestOracle<T> {

	protected List<T>	possiblilities	= new ArrayList<T>();

	@Override
	public void requestSuggestions(SuggestOracle.Request request, SuggestOracle.Callback<T> callback) {
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

		boolean caseSensitive = false;
		String stringFormula = suggestBox.toString(t);
		String stringValue = caseSensitive ? stringFormula : stringFormula.toUpperCase();
		String textValue = caseSensitive ? text : text.toUpperCase();

		boolean startsWith = false;
		if (startsWith ? stringValue.startsWith(textValue) : (stringValue.indexOf(textValue) != -1)) {
			return true;
		}
		return false;
	}
}
