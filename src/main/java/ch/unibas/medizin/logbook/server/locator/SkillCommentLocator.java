package ch.unibas.medizin.logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ch.unibas.medizin.logbook.server.domain.SkillComment;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.SkillComment")
@Component
public class SkillCommentLocator extends Locator<SkillComment, Long> {

    public SkillComment create(Class<? extends logbook.server.domain.SkillComment> clazz) {
        return new SkillComment();
    }

    public SkillComment find(Class<? extends logbook.server.domain.SkillComment> clazz, Long id) {
        return SkillComment.findSkillComment(id);
    }

    public Class<logbook.server.domain.SkillComment> getDomainType() {
        return SkillComment.class;
    }

    public Long getId(SkillComment skillComment) {
        return skillComment.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(SkillComment skillComment) {
        return skillComment.getVersion();
    }
}
