package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.SkillLevel;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillLevelLocator extends Locator<SkillLevel, Long> {

	@Override
	public SkillLevel create(Class<? extends SkillLevel> clazz) {
		return new SkillLevel();
	}

	@Override
	public SkillLevel find(Class<? extends SkillLevel> clazz, Long id) {
		return SkillLevel.findSkillLevel(id);
	}

	@Override
	public Class<SkillLevel> getDomainType() {
		return SkillLevel.class;
	}

	@Override
	public Long getId(SkillLevel skillLevel) {
		return skillLevel.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(SkillLevel skillLevel) {
		return skillLevel.getVersion();
	}
}
