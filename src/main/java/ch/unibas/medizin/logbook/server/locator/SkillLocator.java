package ch.unibas.medizin.logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ch.unibas.medizin.logbook.server.domain.Skill;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.Skill")
@Component
public class SkillLocator extends Locator<Skill, Long> {

    public Skill create(Class<? extends logbook.server.domain.Skill> clazz) {
        return new Skill();
    }

    public Skill find(Class<? extends logbook.server.domain.Skill> clazz, Long id) {
        return Skill.findSkill(id);
    }

    public Class<logbook.server.domain.Skill> getDomainType() {
        return Skill.class;
    }

    public Long getId(Skill skill) {
        return skill.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Skill skill) {
        return skill.getVersion();
    }
}
