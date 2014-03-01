package ch.unibas.medizin.logbook.shared.enums;

import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.shared.GWT;

public enum SkillLevels {
	SOME_PRACTICAL_EXPERIENCE, ROUTINE, NONE;

	static LogBookConstants constants;

	static {
		if (GWT.isClient()) {
			constants = GWT.create(LogBookConstants.class);
		}
	}

    public static String getSkillLevels(SkillLevels skillLevel) {

        String skillLevelValue;

        switch (skillLevel) {
		case SOME_PRACTICAL_EXPERIENCE:
			skillLevelValue = constants.somePracticalExperiance();
			break;
		case ROUTINE:
			skillLevelValue = constants.routine();
			break;
		default:
			skillLevelValue = constants.noSkillAcquired();
		}
		return skillLevelValue;
	}

}
