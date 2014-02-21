package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Keyword;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class KeywordLocator extends Locator<Keyword, Long> {

	@Override
	public Keyword create(Class<? extends Keyword> clazz) {
		return new Keyword();
	}

	@Override
	public Keyword find(Class<? extends Keyword> clazz, Long id) {
		return Keyword.findKeyword(id);
	}

	@Override
	public Class<Keyword> getDomainType() {
		return Keyword.class;
	}

	@Override
	public Long getId(Keyword keyword) {
		return keyword.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Keyword keyword) {
		return keyword.getVersion();
	}
}
