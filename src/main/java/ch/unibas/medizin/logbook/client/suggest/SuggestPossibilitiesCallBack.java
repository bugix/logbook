package ch.unibas.medizin.logbook.client.suggest;

import java.util.List;

public interface SuggestPossibilitiesCallBack<T> {
	void setPossibilities(List<T> possibilities);
}
