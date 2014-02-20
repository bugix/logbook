package ch.unibas.medizin.logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ch.unibas.medizin.logbook.server.domain.Keyword;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@Component
public class KeywordLocator extends Locator<Keyword, Long> {

    public Keyword create(Class<? extends Keyword> clazz) {
        return new Keyword();
    }

    public Keyword find(Class<? extends Keyword> clazz, Long id) {
        return Keyword.findKeyword(id);
    }

    public Class<Keyword> getDomainType() {
        return Keyword.class;
    }

    public Long getId(Keyword keyword) {
        return keyword.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Keyword keyword) {
        return keyword.getVersion();
    }
}
