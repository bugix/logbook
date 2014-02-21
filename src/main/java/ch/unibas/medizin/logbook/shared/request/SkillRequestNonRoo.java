package ch.unibas.medizin.logbook.shared.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillFilteredResultProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;
import ch.unibas.medizin.logbook.server.domain.Skill;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Skill.class)
public interface SkillRequestNonRoo extends RequestContext {
	abstract Request<List<Long>> findCountOfSkillBySkillLevel();

/*abstract Request<List<SkillProxy>> findSkillBySearchCriteria
	(int start, int max,Long studentId,Long mainClassificationId, Long classificationTopicId, Long topidId);*/

	abstract Request<SkillFilteredResultProxy> findSkillBySearchCriteria(int start, int max,Long studentId,Long mainClassificationId, Long classificationTopicId, Long topicId,String fulltextSearch,int chkAsc);
	
	abstract Request<String> retrieveHtmlFile(Long studentId,Long mainClassificationId, Long classificationTopicId, Long topicId,String fulltextSearch,int chkAsc);
	
	abstract Request<String> findProgressOfMainClassification(MainClassificationProxy mainClassification,Long studentId);
	
	abstract Request<String> findProgressOfClassificationTopic(ClassificationTopicProxy mainClassification,Long studentId);
	
	abstract Request<String> findProgressOfTopic(TopicProxy mainClassification,Long studentId);
	
	abstract Request<String> addCommnets(Long skillProxyId,Long studentId,String comment);
	

	//abstract Request<Boolean> isSkillAcquiredbyStudentAtFirstLevel(Long studentID,Long skillId, Long skillLevelID);
	
	abstract Request<String> getCommentOfStudentForSkill(Long skillId,Long studentId);
	
	

}
