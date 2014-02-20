package ch.unibas.medizin.logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ch.unibas.medizin.logbook.server.domain.MainClassification;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.MainClassification")
@Component
public class MainClassificationLocator extends Locator<MainClassification, Long> {

    public MainClassification create(Class<? extends logbook.server.domain.MainClassification> clazz) {
        return new MainClassification();
    }

    public MainClassification find(Class<? extends logbook.server.domain.MainClassification> clazz, Long id) {
        return MainClassification.findMainClassification(id);
    }

    public Class<logbook.server.domain.MainClassification> getDomainType() {
        return MainClassification.class;
    }

    public Long getId(MainClassification mainClassification) {
        return mainClassification.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(MainClassification mainClassification) {
        return mainClassification.getVersion();
    }
}
