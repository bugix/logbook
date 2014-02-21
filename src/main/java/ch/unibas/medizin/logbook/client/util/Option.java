package ch.unibas.medizin.logbook.client.util;

public interface Option<T> {
	String getKey();

	T getValue();
}
