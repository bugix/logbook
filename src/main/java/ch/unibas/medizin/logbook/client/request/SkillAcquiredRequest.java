package ch.unibas.medizin.logbook.client.request;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.SkillAcquiredProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName("ch.unibas.medizin.logbook.server.domain.SkillAcquired")
public interface SkillAcquiredRequest extends RequestContext {

	abstract Request<Long> countSkillAcquireds();

	abstract Request<List<SkillAcquiredProxy>> findAllSkillAcquireds();

	abstract Request<List<SkillAcquiredProxy>> findSkillAcquiredEntries(int firstResult, int maxResults);

	abstract Request<SkillAcquiredProxy> findSkillAcquired(Long id);

	abstract InstanceRequest<SkillAcquiredProxy, Void> persist();

	abstract InstanceRequest<SkillAcquiredProxy, Void> remove();
	
	abstract Request<List<Long>> findTotalSkillAcquiredByStudentLevelVise(long studentId);

	abstract Request<List<SkillAcquiredProxy>> findLatestAcquiredSkillByStudent(Long studentId, String sortOrder, String sortBy, Integer start, Integer rangeLength);

	abstract Request<Integer> findCountLatestAcquiredSkillByStudent(Long studentId, Integer totalRecords, String sortOrder, String sortBy);

	abstract Request<String> acquireORDeleteSkill(Long studentid, Long Skillid, Boolean isFirstSelected, Boolean isDeleteOperation);

	abstract Request<Integer> countSkillAcquiredByStudentandSkill(Long id, List<SkillProxy> skillProxyList);
}
