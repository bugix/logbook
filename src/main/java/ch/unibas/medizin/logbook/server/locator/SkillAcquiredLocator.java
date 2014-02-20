package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.SkillAcquired;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillAcquiredLocator extends Locator<SkillAcquired, Long> {

    public SkillAcquired create(Class<? extends SkillAcquired> clazz) {
        return new SkillAcquired();
    }

    public SkillAcquired find(Class<? extends SkillAcquired> clazz, Long id) {
        return SkillAcquired.findSkillAcquired(id);
    }

    public Class<SkillAcquired> getDomainType() {
        return SkillAcquired.class;
    }

    public Long getId(SkillAcquired skillAcquired) {
        return skillAcquired.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(SkillAcquired skillAcquired) {
        return skillAcquired.getVersion();
    }
}
