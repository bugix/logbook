package logbook.shared;

import logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;


public enum SkillLevels{
  SOME_PRACTICLE_EXPERIENCE, ROUTINE;
  
  static LogBookConstants constants = GWT.create(LogBookConstants.class);
  private static String SkillLevelValue;
	public static String getSkillLevels(SkillLevels skillLevel){
		
		switch(skillLevel){
		case   SOME_PRACTICLE_EXPERIENCE: SkillLevelValue=constants.somePracticleExperiance();
		break;
		case ROUTINE : SkillLevelValue=constants.routine();
		break;
		default : SkillLevelValue=constants.somePracticleExperiance();;
		}
		return SkillLevelValue;
	}

  
  
}
