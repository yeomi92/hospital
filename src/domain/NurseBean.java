package domain;

public class NurseBean extends MemberBean{
	private String nurPosition, majorJob,profileImg;
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getNurPosition() {
		return nurPosition;
	}
	public void setNurPosition(String nurPosition) {
		this.nurPosition = nurPosition;
	}
	public String getMajorJob() {
		return majorJob;
	}
	public void setMajorJob(String majorJob) {
		this.majorJob = majorJob;
	}
	@Override
	public String toString() {
		/*return String.format("nurse ID: %s\n"
					+ "major job: %s\n"
					+ "name: %s\n"
					+ "gender: %s\n"
					+ "phone: %s\n"
					+ "email: %s\n"
					+ "position: %s\n",
					uid,majorJob,name,getGender(),phone,email,nurPosition);*/
		return String.format("nurse ID: %s\n"
				+ "major job: %s\n"
				+ "name: %s\n"
				+ "phone: %s\n"
				+ "email: %s\n"
				+ "position: %s\n",
				uid,majorJob,name,phone,email,nurPosition);
	}
}
