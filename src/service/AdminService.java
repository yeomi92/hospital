package service;

import domain.DoctorBean;
import domain.MemberBean;
import domain.NurseBean;
import domain.PatientBean;

public interface AdminService {
	public String getBmi(PatientBean pat);
	public String checkDocIdNurId(String docId, String nurId,Object[] object);
	//create
	public void regist(MemberBean member);
	//read
	public MemberBean findById(MemberBean member);
	public MemberBean[] findByName(MemberBean member);
	public int countByName(MemberBean member);
	public DoctorBean[] doctorList();
	public NurseBean[] nurseList();
	public int[] count();
	//update
	public void change(MemberBean member);
	//remove
	//public void remove(String uid, String pw);//이렇게하면 PW가 노출된다.
	public void remove(MemberBean member);
	//util
	//validation
	public boolean exist(MemberBean member);
}
