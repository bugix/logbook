package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Administrator;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class AdministratorLocator extends Locator<Administrator, Long> {

	@Override
	public Administrator create(Class<? extends Administrator> clazz) {
		return new Administrator();
	}

	@Override
	public Administrator find(Class<? extends Administrator> clazz, Long id) {
		return Administrator.findAdministrator(id);
	}

	@Override
	public Class<Administrator> getDomainType() {
		return Administrator.class;
	}

	@Override
	public Long getId(Administrator administrator) {
		return administrator.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Administrator administrator) {
		return administrator.getVersion();
	}
}
