package logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import logbook.server.domain.SkilAcquired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.SkilAcquired")
@Component
public class SkilAcquiredLocator extends Locator<SkilAcquired, Long> {

    public SkilAcquired create(Class<? extends logbook.server.domain.SkilAcquired> clazz) {
        return new SkilAcquired();
    }

    public SkilAcquired find(Class<? extends logbook.server.domain.SkilAcquired> clazz, Long id) {
        return SkilAcquired.findSkilAcquired(id);
    }

    public Class<logbook.server.domain.SkilAcquired> getDomainType() {
        return SkilAcquired.class;
    }

    public Long getId(SkilAcquired skilAcquired) {
        return skilAcquired.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(SkilAcquired skilAcquired) {
        return skilAcquired.getVersion();
    }
}
