package logbook.shared.scaffold;

import java.util.List;

import logbook.server.domain.Skill;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Skill.class)
public interface SkillRequestNonRoo extends RequestContext {
	abstract Request<List<Long>> findCountOfSkillBySkillLevel();

}
