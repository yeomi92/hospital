package domain;

public class DoctorBean extends MemberBean{ //탄생목적이 db에 값을 가져가서 저장하는 것이다. 그러므로 schema와 같게 만들어야 한다.
	private String docPosition,majorTreat,progileImg;
	public String getProgileImg() {
		return progileImg;
	}
	public void setProgileImg(String progileImg) {
		this.progileImg = progileImg;
	}
	public String getDocPosition() {
		return docPosition;
	}
	public void setDocPosition(String docPosition) {
		this.docPosition = docPosition;
	}
	public String getMajorTreat() {
		return majorTreat;
	}
	public void setMajorTreat(String majorTreat) {
		this.majorTreat = majorTreat;
	}
	@Override
	public String toString() {
		return String.format("doctor ID: %s\n"
					+ "major treatment: %s\n"
					+ "name: %s\n"
					+ "gender: %s\n"
					+ "phone: %s\n"
					+ "email: %s\n"
					+ "position: %s\n",
					uid,majorTreat,name,getGender(ssn),phone,email,docPosition);
	}
}
