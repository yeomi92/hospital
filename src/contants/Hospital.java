package contants;

public class Hospital {
	public final static String HOSPITAL_NAME="ÇÑºûº´¿ø";
	public final static String EXE_OPTION=
			"0. EXIT\n"
			+ "1.REG-DOCTOR\n"
			+ "2.REG-NURSE\n"
			+ "3.REG-PATIENTS\n"
			+ "4.CHECK BMI\n"
			+ "5.DOCTOR LIST\n"
			+ "6.NURSE LIST\n"
			+ "7.Find by doctor ID\n"
			+ "8.Find by nurse ID\n"
			+ "9.Find by doctor Name\n"
			+ "10.Find by nurse Name\n";
	public final static String DOC_SPEC=
			"INPUT AS doctor ID, major treatment, name, ssn, phone, email, position";
	public final static String NUR_SPEC=
			"INPUT AS nurse ID, major job, name, ssn, phone, email, position";
	public final static String PAT_SPEC=
			"INPUT AS patient ID, nurse ID, doctor ID, name, ssn, address, phone, email, job";
}
