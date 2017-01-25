package domain;

public class PatientBean extends MemberBean{
	private String patJob,height,weight,bloodType,docId,nurId;
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getNurId() {
		return nurId;
	}
	public void setNurId(String nurId) {
		this.nurId = nurId;
	}
	public String getPatJob() {
		return patJob;
	}
	public void setPatJob(String patJob) {
		this.patJob = patJob;
	}
	@Override
	public String toString() {
		return String.format("%S님 진료 접수되었습니다.\n"
				+ "patient ID: %s\n"
					+ "nurse ID: %s\n"
					+ "doctor ID: %s\n"
					+ "name: %s\n"
					+ "gender: %s\n"
					+ "ssn: %s\n"
					+ "address: %s\n"
					+ "phone: %s\n"
					+ "email: %s\n"
					+ "job: %s\n",
					name,uid,nurId,docId,name,getGender(ssn),ssn,addr,phone,email,patJob);
	}
}
