package ch.unibas.medizin.logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ch.unibas.medizin.logbook.server.domain.Administrator;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@Component
public class AdministratorLocator extends Locator<Administrator, Long> {

    public Administrator create(Class<? extends Administrator> clazz) {
        return new Administrator();
    }

    public Administrator find(Class<? extends Administrator> clazz, Long id) {
        return Administrator.findAdministrator(id);
    }

    public Class<Administrator> getDomainType() {
        return Administrator.class;
    }

    public Long getId(Administrator administrator) {
        return administrator.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Administrator administrator) {
        return administrator.getVersion();
    }
}
