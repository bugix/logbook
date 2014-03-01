package ch.unibas.medizin.logbook.shared;

import java.util.List;

import ch.unibas.medizin.logbook.server.domain.Skill;
import ch.unibas.medizin.logbook.shared.enums.SkillLevels;

public class SkillFilteredResult {

	private String key;

	private List<Skill> skillList;

	private Integer totalSkill = 0;
	
	private List<String> mainClassificationKey;
	
	private List<SkillLevels> skillLevelsAcquiredList;

	private List<String> mainClassificationProgress;

	private List<String> skillComment;

	public Integer getTotalSkill() {
		return totalSkill;
	}

	public void setTotalSkill(Integer totalSkill) {
		this.totalSkill = totalSkill;
	}

	public List<String> getSkillComment() {
		return skillComment;
	}

	public void setSkillComment(List<String> skillComment) {
		this.skillComment = skillComment;
	}

	public List<String> getMainClassificationProgress() {
		return mainClassificationProgress;
	}

	public void setMainClassificationProgress(List<String> mainClassificationProgress) {
		this.mainClassificationProgress = mainClassificationProgress;
	}

	public List<String> getMainClassificationKey() {
		return mainClassificationKey;
	}

	public void setMainClassificationKey(List<String> mainClassificationKey) {
		this.mainClassificationKey = mainClassificationKey;
	}

	public List<SkillLevels> getSkillLevelsAcquiredList() {
		return skillLevelsAcquiredList;
	}

	public void setSkillLevelsAcquiredList(List<SkillLevels> skillLevelsAcquiredList) {
		this.skillLevelsAcquiredList = skillLevelsAcquiredList;
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
