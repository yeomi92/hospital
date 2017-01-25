package domain;

public class TreatmentBean { //instance variable은 반드시 initialize하지 않는다.
	protected int treatId,docId,patId,treatDate,treatContents;
	public int getTreatDate() {
		return treatDate;
	}
	public void setTreatDate(int treatDate) {
		this.treatDate = treatDate;
	}
	public int getTreatContents() {
		return treatContents;
	}
	public void setTreatContents(int treatContents) {
		this.treatContents = treatContents;
	}
	public int getTreatId() {
		return treatId;
	}
	public void setTreatId(int treatId) {
		this.treatId = treatId;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
}
