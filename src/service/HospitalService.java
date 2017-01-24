package service;

import domain.PatientBean;

public interface HospitalService {
	public String getBmi(PatientBean pat);
	public void checkDocIdNurId(int docId, int nurId,Object[] object);
}
