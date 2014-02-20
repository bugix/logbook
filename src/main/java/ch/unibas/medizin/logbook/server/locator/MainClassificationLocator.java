package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.MainClassification;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class MainClassificationLocator extends Locator<MainClassification, Long> {

    public MainClassification create(Class<? extends MainClassification> clazz) {
        return new MainClassification();
    }

    public MainClassification find(Class<? extends MainClassification> clazz, Long id) {
        return MainClassification.findMainClassification(id);
    }

    public Class<MainClassification> getDomainType() {
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
