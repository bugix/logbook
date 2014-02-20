package ch.unibas.medizin.logbook.shared.scaffold;

import java.util.List;

import ch.unibas.medizin.logbook.client.managed.proxy.SkillAcquiredProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.SkillProxy;
import ch.unibas.medizin.logbook.client.managed.proxy.StudentProxy;
import ch.unibas.medizin.logbook.server.domain.SkillAcquired;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(SkillAcquired.class)
public interface SkillAcquiredRequestNonRoo extends RequestContext {
	abstract Request<List<Long>> findTotalSkillAcquiredByStudentLevelVise(long studentId);
	abstract Request<List<SkillAcquiredProxy>> findLatestAcquiredSkillByStudent(Long studentId, String sortOrder,String sortBy,Integer start,Integer rangeLength);	 
	abstract Request<Integer> findCountLatestAcquiredSkillByStudent(Long studentId, Integer totalRecords,String sortOrder,String sortBy);
	
	abstract Request<String> acquireORDeleteSkill(Long studentid,Long Skillid,Boolean isFirstSelected,Boolean isDeleteOperation);
abstract Request<Integer> countSkillAcquiredByStudentandSkill(Long id,List<SkillProxy> skillProxyList);	 
}
