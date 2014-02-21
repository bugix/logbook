package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.SkillAcquired;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillAcquiredLocator extends Locator<SkillAcquired, Long> {

	@Override
	public SkillAcquired create(Class<? extends SkillAcquired> clazz) {
		return new SkillAcquired();
	}

	@Override
	public SkillAcquired find(Class<? extends SkillAcquired> clazz, Long id) {
		return SkillAcquired.findSkillAcquired(id);
	}

	@Override
	public Class<SkillAcquired> getDomainType() {
		return SkillAcquired.class;
	}

	@Override
	public Long getId(SkillAcquired skillAcquired) {
		return skillAcquired.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(SkillAcquired skillAcquired) {
		return skillAcquired.getVersion();
	}
}
