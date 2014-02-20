package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.SkillLevel;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillLevelLocator extends Locator<SkillLevel, Long> {

    public SkillLevel create(Class<? extends SkillLevel> clazz) {
        return new SkillLevel();
    }

    public SkillLevel find(Class<? extends SkillLevel> clazz, Long id) {
        return SkillLevel.findSkillLevel(id);
    }

    public Class<SkillLevel> getDomainType() {
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
