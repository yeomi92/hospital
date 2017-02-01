package contants;

public class Hospital {
	public final static String HOSPITAL_NAME="한빛병원";
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
			+ "10.Find by nurse Name\n"
			+ "11.Change doctor's information\n"
			+ "12.Change nurse's information\n"
			+ "13.Delete doctor\n"
			+ "14.Delete nurse";
	public final static String ADMIN_MENU=
			"0. EXIT\n"
			+ "1.의사 등록  "
			+ "2.간호사 등록\n"
			+ "3.의사 목록  "
			+ "4.간호사 목록\n"
			+ "5.아이디로 의사 찾기  "
			+ "6.아이디로 간호사 찾기\n"
			+ "7.이름으로 의사 찾기  "
			+ "8.이름으로 간호사 찾기\n"
			+ "9.의사 정보 수정  "
			+ "10.간호사 정보 수정\n"
			+ "11.의사 삭제  "
			+ "12.간호사 삭제";
	public final static String DOC_SPEC=
			"INPUT AS doctor ID, major treatment, name, ssn, phone, email, position";
	public final static String NUR_SPEC=
			"INPUT AS nurse ID, major job, name, ssn, phone, email, position";
	public final static String PAT_SPEC=
			"INPUT AS patient ID, nurse ID, doctor ID, name, ssn, address, phone, email, job";
}
