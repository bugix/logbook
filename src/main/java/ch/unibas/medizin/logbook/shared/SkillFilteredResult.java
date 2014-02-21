package ch.unibas.medizin.logbook.shared;

import java.util.List;

import ch.unibas.medizin.logbook.server.domain.Skill;
import ch.unibas.medizin.logbook.shared.enums.SkillLevels;

public class SkillFilteredResult {

	String key;
	
	List<Skill> skillList;
	
	Integer totalSkill=0;
	
	public Integer getTotalSkill() {
		return totalSkill;
	}

	public void setTotalSkill(Integer totalSkill) {
		this.totalSkill = totalSkill;
	}

	List<SkillLevels> skillLevelsAcquiredList;
	
	List<String> mainClassificationProgress;
	
	List<String> skillComment;
	
	public List<String> getSkillComment() {
		return skillComment;
	}

	public void setSkillComment(List<String> skillComment) {
		this.skillComment = skillComment;
	}

	public List<String> getMainClassificationProgress() {
		return mainClassificationProgress;
	}

	public void setMainClassificationProgress(
			List<String> mainClassificationProgress) {
		this.mainClassificationProgress = mainClassificationProgress;
	}

	List<String> mainClassificationkey;
	
public List<String> getMainClassificationkey() {
		return mainClassificationkey;
	}

	public void setMainClassificationkey(List<String> mainClassificationkey) {
		this.mainClassificationkey = mainClassificationkey;
	}

	public List<SkillLevels> getSkilltLevelsAcquiredList() {
		return skillLevelsAcquiredList;
	}

	public void setSkilltLevelsAcquiredList(
			List<SkillLevels> skilltLevelsAcquiredList) {
		this.skillLevelsAcquiredList=skilltLevelsAcquiredList;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
