package controller;

import javax.swing.*;
import contants.Hospital;
import domain.*;
import service.HospitalService;
import serviceImpl.HospitalServiceImpl;

public class Controller {
	
	public void start(){
		HospitalService service = new HospitalServiceImpl();
		Object[] object = new Object[3];
		DoctorBean doc=null;
		NurseBean nur=null;
		PatientBean pat=null;
		while(true){
			switch(input(Hospital.EXE_OPTION)){
				case "0":
					showMsg("종료^^");
					return;
				case "1":
					doc = new DoctorBean();
					String docInfo=input(Hospital.DOC_SPEC);
					String[] docInfoArr= docInfo.split(" ");
					doc.setUid((docInfoArr[0]));
					doc.setMajorTreat(docInfoArr[1]);
					doc.setName(docInfoArr[2]);
					doc.setSsn(docInfoArr[3]);
					doc.setPhone(docInfoArr[4]);
					doc.setEmail(docInfoArr[5]);
					doc.setDocPosition(docInfoArr[6]);
					showMsg(doc.toString());
					object[0]=doc;
					break;
				case "2":
					nur = new NurseBean();
					String nurInfo=input(Hospital.NUR_SPEC);
					String[] nurInfoArr=nurInfo.split(" ");
					nur.setUid((nurInfoArr[0]));
					nur.setMajorJob(nurInfoArr[1]);
					nur.setName(nurInfoArr[2]);
					nur.setSsn(nurInfoArr[3]);
					nur.setPhone(nurInfoArr[4]);
					nur.setEmail(nurInfoArr[5]);
					nur.setNurPosition(nurInfoArr[6]);
					showMsg(nur.toString());
					object[1]=nur;
					break;
				case "3":
					String docId="",nurId="";
					pat = new PatientBean();
					String patInfo=input(Hospital.PAT_SPEC);
					String[] patInfoArr=patInfo.split(" ");
					pat.setUid((patInfoArr[0]));
					nurId=(patInfoArr[1]);
					docId=(patInfoArr[2]);
					pat.setName(patInfoArr[3]);
					pat.setSsn(patInfoArr[4]);
					pat.setAddr(patInfoArr[5]);
					pat.setPhone(patInfoArr[6]);
					pat.setEmail(patInfoArr[7]);
					pat.setPatJob(patInfoArr[8]);
					object[2]=pat;
					showMsg(service.checkDocIdNurId(docId,nurId,object));
					break;
				case "4": 
					String bmiInfo=input("키, 몸무게");
					String[] bmiInfoArr=bmiInfo.split(" ");
					pat.setHeight((bmiInfoArr[0]));
					pat.setWeight((bmiInfoArr[1]));
					showMsg(service.getBmi(pat));
				break;
			}
		}
		
	}
	public String input(String str){
		return JOptionPane.showInputDialog(str);
	}
	public void showMsg(String str){
		JOptionPane.showMessageDialog(null, str);
	}
}
