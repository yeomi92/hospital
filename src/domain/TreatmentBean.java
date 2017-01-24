package domain;

public class TreatmentBean { //instance variable은 반드시 initialize하지 않는다.
	protected int treatId,docId,patId;
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
