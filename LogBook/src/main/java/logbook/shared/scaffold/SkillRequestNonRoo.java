package logbook.shared.scaffold;

import java.util.List;

import logbook.client.managed.proxy.SkillProxy;
import logbook.server.domain.Skill;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Skill.class)
public interface SkillRequestNonRoo extends RequestContext {
	abstract Request<List<Long>> findCountOfSkillBySkillLevel();

abstract Request<List<SkillProxy>> findSkillBySearchCriteria
	(int start, int max, Long mainClassificationId, Long classificationTopicId, Long topidId);

	abstract Request<String> retrieveHtmlFile();

}
