package ch.unibas.medizin.logbook.shared.util;

import java.util.Collection;
import java.util.Iterator;

import com.google.gwt.i18n.client.NumberFormat;

public class UtilityLogBook {
	
	public static final NumberFormat DECIMAL_FORMAT = NumberFormat.getFormat("#0.00%");

	/* text : The text to be printed. */
	/* length : Len of the text to be shown after that ... will be concatenated. */

	public static String getFormatedString(String text, int length) {
		if (text.length() > length) {
			text = text.substring(0, length).concat("...");
		}
		return text;
	}

	public static String getEmptyStringIfNull(Object str) {
		if (str == null)
			return "";
		else
			return str.toString();
	}

	// Join Collection Using Seperator and Return seperator seperated String
	public static <T> String join(Collection<T> collection, String seperator) {
		StringBuffer buffer = new StringBuffer();

		for (Iterator<T> iterator = collection.iterator(); iterator.hasNext();) {

			buffer.append(iterator.next().toString());
			if (iterator.hasNext())
				buffer.append(seperator);
		}

		return buffer.toString();

	}

}
