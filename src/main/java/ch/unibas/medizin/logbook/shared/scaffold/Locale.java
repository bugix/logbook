package ch.unibas.medizin.logbook.shared.scaffold;

public enum Locale {
	de("Deutsch"), en("English"), cn("Constant names");
	
	private final String languageName;
	
	private Locale(String languageName) {
		this.languageName = languageName;
	}
	
	public String getLanguageName() {
		return languageName;
	}
}
