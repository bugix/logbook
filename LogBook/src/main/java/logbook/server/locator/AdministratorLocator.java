package logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import logbook.server.domain.Administrator;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.Administrator")
@Component
public class AdministratorLocator extends Locator<Administrator, Long> {

    public Administrator create(Class<? extends logbook.server.domain.Administrator> clazz) {
        return new Administrator();
    }

    public Administrator find(Class<? extends logbook.server.domain.Administrator> clazz, Long id) {
        return Administrator.findAdministrator(id);
    }

    public Class<logbook.server.domain.Administrator> getDomainType() {
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
