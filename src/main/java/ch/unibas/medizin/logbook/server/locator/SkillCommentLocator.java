package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.SkillComment;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class SkillCommentLocator extends Locator<SkillComment, Long> {

	@Override
	public SkillComment create(Class<? extends SkillComment> clazz) {
		return new SkillComment();
	}

	@Override
	public SkillComment find(Class<? extends SkillComment> clazz, Long id) {
		return SkillComment.findSkillComment(id);
	}

	@Override
	public Class<SkillComment> getDomainType() {
		return SkillComment.class;
	}

	@Override
	public Long getId(SkillComment skillComment) {
		return skillComment.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(SkillComment skillComment) {
		return skillComment.getVersion();
	}
}
