package ch.unibas.medizin.logbook.shared.enums;

public enum Gender {

	NotKnown(0), Male(1), Female(2), NotSpecified(9);

	private int genderValue;

	private Gender(int value) {
		genderValue = value;
	}

	public int getGenderValue() {
		return genderValue;
	}

	public static Gender findGender(int value) {

		final Gender gender;
		switch (value) {
		case 0:
			gender = NotKnown;
			break;
		case 1:
			gender = Male;
			break;
		case 2:
			gender = Female;
			break;
		case 9:
			gender = NotSpecified;
			break;
		default:
			// in case of error
			gender = NotSpecified;
			break;
		}

		return gender;
	}
}
