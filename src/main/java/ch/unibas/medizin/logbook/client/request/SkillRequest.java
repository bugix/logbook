package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillFilteredResultProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.Skill")
public interface SkillRequest extends RequestContext {

	//abstract Request<Long> countSkills();

	//abstract Request<List<SkillProxy>> findAllSkills();

	//abstract Request<List<SkillProxy>> findSkillEntries(int firstResult, int maxResults);

	//abstract Request<SkillProxy> findSkill(Long id);

	//abstract InstanceRequest<SkillProxy, Void> persist();

	//abstract InstanceRequest<SkillProxy, Void> remove();
	
	abstract Request<List<Long>> findCountOfSkillBySkillLevel();

	abstract Request<SkillFilteredResultProxy> findSkillBySearchCriteria(int start, int max, Long studentId, Long mainClassificationId, Long classificationTopicId, Long topicId, String fulltextSearch, int chkAsc);

	abstract Request<String> retrieveHtmlFile(Long studentId, Long mainClassificationId, Long classificationTopicId, Long topicId, String fulltextSearch, int chkAsc);

	abstract Request<String> findProgressOfMainClassification(MainClassificationProxy mainClassification, Long studentId);

	abstract Request<String> findProgressOfClassificationTopic(ClassificationTopicProxy mainClassification, Long studentId);

	abstract Request<String> findProgressOfTopic(TopicProxy mainClassification, Long studentId);

	abstract Request<String> addCommnets(Long skillProxyId, Long studentId, String comment);

	abstract Request<String> getCommentOfStudentForSkill(Long skillId, Long studentId);
}
