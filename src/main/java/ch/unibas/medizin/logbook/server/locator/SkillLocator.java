package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Skill;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillLocator extends Locator<Skill, Long> {

    public Skill create(Class<? extends Skill> clazz) {
        return new Skill();
    }

    public Skill find(Class<? extends Skill> clazz, Long id) {
        return Skill.findSkill(id);
    }

    public Class<Skill> getDomainType() {
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
