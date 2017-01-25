package service;

import domain.PatientBean;

public interface HospitalService {
	public String getBmi(PatientBean pat);
	public String checkDocIdNurId(String docId, String nurId,Object[] object);
}
