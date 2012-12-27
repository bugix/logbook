package logbook.client.a_nonroo.app.client;

import java.util.List;

import logbook.client.managed.proxy.SkillProxy;
import logbook.shared.SkillFilteredResult;
import logbook.shared.SkillLevels;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(value = SkillFilteredResult.class )
public interface SkillFilteredResultProxy extends ValueProxy {

	public String getKey();
	
	public List<SkillProxy> getSkillList();
	
	public List<SkillLevels> getSkilltLevelsAcquiredList();
	
	public List<String> getMainClassificationProgress();
	
	public List<String> getMainClassificationkey();
	
	public Integer getTotalSkill() ;
	
/*	public List<TopicProxy> getTopicList();
	
	public List<MainClassificationProxy> getMainClassificationList();
	
	public List<ClassificationTopicProxy> getClassificationTopicList();*/
}
