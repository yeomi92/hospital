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
					doc.setUid(Integer.parseInt(docInfoArr[0]));
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
					nur.setUid(Integer.parseInt(nurInfoArr[0]));
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
					int docId=0,nurId=0;
					pat = new PatientBean();
					String patInfo=input(Hospital.PAT_SPEC);
					String[] patInfoArr=patInfo.split(" ");
					pat.setUid(Integer.parseInt(patInfoArr[0]));
					nurId=Integer.parseInt(patInfoArr[1]);
					docId=Integer.parseInt(patInfoArr[2]);
					/*pat.setDocId(Integer.parseInt(patInfoArr[1]));
					pat.setNurId(Integer.parseInt(patInfoArr[2]));*/
					//service.checkDocIdNurId(Integer.parseInt(patInfoArr[1]), Integer.parseInt(patInfoArr[2]),object[0],object[1]);
					/*if(docId==(doc.getUid())&&nurId==(nur.getUid())){
						pat.setDocId(docId);
						pat.setNurId(nurId);
					}else{
						showMsg("의사 또는 간호사 등록을 먼저하세요.");
						break;
					}*/
					pat.setName(patInfoArr[3]);
					pat.setSsn(patInfoArr[4]);
					pat.setAddr(patInfoArr[5]);
					pat.setPhone(patInfoArr[6]);
					pat.setEmail(patInfoArr[7]);
					pat.setPatJob(patInfoArr[8]);
					object[2]=pat;
					service.checkDocIdNurId(docId,nurId,object);
					showMsg(pat.toString());
					break;
				case "4": 
					String bmiInfo=input("키, 몸무게");
					String[] bmiInfoArr=bmiInfo.split(" ");
					pat.setHeight((Double.parseDouble(bmiInfoArr[0]))/100);
					pat.setWeight(Double.parseDouble(bmiInfoArr[1]));
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
