package logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import logbook.server.domain.SkillLevel;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.SkillLevel")
@Component
public class SkillLevelLocator extends Locator<SkillLevel, Long> {

    public SkillLevel create(Class<? extends logbook.server.domain.SkillLevel> clazz) {
        return new SkillLevel();
    }

    public SkillLevel find(Class<? extends logbook.server.domain.SkillLevel> clazz, Long id) {
        return SkillLevel.findSkillLevel(id);
    }

    public Class<logbook.server.domain.SkillLevel> getDomainType() {
        return SkillLevel.class;
    }

    public Long getId(SkillLevel skillLevel) {
        return skillLevel.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(SkillLevel skillLevel) {
        return skillLevel.getVersion();
    }
}
