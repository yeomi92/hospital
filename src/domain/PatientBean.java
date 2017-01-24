package domain;

public class PatientBean extends MemberBean{
	private String patJob;
	private int docId,nurId;
	private double height,weight;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public int getNurId() {
		return nurId;
	}
	public void setNurId(int nurId) {
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
