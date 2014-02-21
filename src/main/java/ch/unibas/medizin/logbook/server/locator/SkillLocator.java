package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Skill;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillLocator extends Locator<Skill, Long> {

	@Override
	public Skill create(Class<? extends Skill> clazz) {
		return new Skill();
	}

	@Override
	public Skill find(Class<? extends Skill> clazz, Long id) {
		return Skill.findSkill(id);
	}

	@Override
	public Class<Skill> getDomainType() {
		return Skill.class;
	}

	@Override
	public Long getId(Skill skill) {
		return skill.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Skill skill) {
		return skill.getVersion();
	}
}
