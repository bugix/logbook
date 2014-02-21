package ch.unibas.medizin.logbook.client.proxy;

import java.util.List;

import ch.unibas.medizin.logbook.shared.SkillFilteredResult;
import ch.unibas.medizin.logbook.shared.enums.SkillLevels;

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
	
	public List<String> getSkillComment();
}
