package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Keyword;
import ch.unibas.medizin.logbook.server.domain.MainClassification;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class MainClassificationLocator extends Locator<MainClassification, Long> {

	@Override
	public MainClassification create(Class<? extends MainClassification> clazz) {
		return new MainClassification();
	}

	@Override
	public MainClassification find(Class<? extends MainClassification> clazz, Long id) {
		return MainClassification.findMainClassification(id);
	}

	@Override
	public Class<MainClassification> getDomainType() {
		return MainClassification.class;
	}

	@Override
	public Long getId(MainClassification mainClassification) {
		return mainClassification.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(MainClassification mainClassification) {
		return mainClassification.getVersion();
	}
	
	@Override
	public boolean isLive(MainClassification mainClassification) {
		return true;
	}
}
