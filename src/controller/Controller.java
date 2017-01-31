package controller;

import javax.swing.*;

import contants.Hospital;
import domain.*;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class Controller {
	
	public void start(){
		AdminService service = new AdminServiceImpl();
		Object[] object = new Object[3];
		DoctorBean doc=null;
		NurseBean nur=null;
		PatientBean pat=null;
		while(true){
			switch(input(Hospital.EXE_OPTION)){
				case "0":
					showMsg("����^^");
					return;
				case "1":
					doc = new DoctorBean();
					String[] docInfoArr= input(Hospital.DOC_SPEC).split(" ");
					doc.setUid((docInfoArr[0]));/*
					doc.setMajorTreat(docInfoArr[1]);
					doc.setName(docInfoArr[2]);
					doc.setSsn(docInfoArr[3]);
					doc.setPhone(docInfoArr[4]);
					doc.setEmail(docInfoArr[5]);
					doc.setDocPosition(docInfoArr[6]);
					showMsg(doc.toString());*/
					object[0]=doc;
					service.regist(doc);
					break;
				case "2":
					nur = new NurseBean();
					String nurInfo=input(Hospital.NUR_SPEC);
					String[] nurInfoArr=nurInfo.split(" ");
					nur.setUid((nurInfoArr[0]));
					nur.setMajorJob(nurInfoArr[1]);/*
					nur.setName(nurInfoArr[2]);
					nur.setSsn(nurInfoArr[3]);
					nur.setPhone(nurInfoArr[4]);
					nur.setEmail(nurInfoArr[5]);
					nur.setNurPosition(nurInfoArr[6]);
					showMsg(nur.toString());*/
					object[1]=nur;
					service.regist(nur);
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
					String bmiInfo=input("Ű, ������");
					String[] bmiInfoArr=bmiInfo.split(" ");
					pat.setHeight((bmiInfoArr[0]));
					pat.setWeight((bmiInfoArr[1]));
					showMsg(service.getBmi(pat));
				break;
				case "5":
					DoctorBean[] docList = service.doctorList();
					String docListResult="";
					System.out.println(docList[0].toString());
					for(int i=0;i<service.count()[0];i++){
						docListResult+=(i+1)+"��\n"+docList[i].toString()+"\n";
					}
					showMsg(docListResult);
					break;
				case "6":
					NurseBean[] nurList = service.nurseList();
					String nurListResult="";
					System.out.println(nurList[0].toString());
					for(int i=0;i<service.count()[1];i++){
						nurListResult+=(i+1)+"��\n"+nurList[i].toString()+"\n";
					}
					showMsg(nurListResult);
					break;
				case "7"://�ǻ� ���̵� ã��
					doc.setUid(input("ã�� �ǻ� ���̵� �Է��ϼ���."));
					MemberBean memberDocId = service.findById(doc);
					showMsg(memberDocId.getUid()==null?"�ش� �ǻ簡 �����ϴ�.":memberDocId.toString());
					break;
				case "8"://��ȣ�� ���̵� ã��
					nur.setUid(input("ã�� ��ȣ�� ���̵� �Է��ϼ���."));
					MemberBean memberNurId = service.findById(nur);
					showMsg(memberNurId.getUid()==null?"�ش� ��ȣ�簡 �����ϴ�.":memberNurId.toString());
				case "9"://�ǻ� �̸� ã��
					doc.setName(input("ã�� �ǻ� �̸��� �Է��ϼ���."));
					
					if(service.countByName(doc)==0){
						showMsg("�ش� �ǻ簡 �����ϴ�.");
					}else{
						MemberBean[] memberDocName = service.findByName(doc);
						String nameResult="";
						for(int i=0;i<service.countByName(doc);i++){
							nameResult+=(i+1)+"��\n"+memberDocName[i].toString()+"\n";
						}
						showMsg(nameResult);
					}
					break;
				case "10"://��ȣ�� �̸� ã��
					nur.setName(input("ã�� ��ȣ�� �̸��� �Է��ϼ���."));
					if(service.countByName(nur)==0){
						showMsg("�ش� ��ȣ�簡 �����ϴ�.");
					}else{
						MemberBean[] memberNurName = service.findByName(nur);
						String nameResult="";
						for(int i=0;i<service.countByName(nur);i++){
							nameResult+=(i+1)+"��\n"+memberNurName[i].toString()+"\n";
						}
						showMsg(nameResult);
					}
					break;
				case "11"://�ǻ� change
					String[] docItem = input("���̵�, ������ ������ �Է��ϼ���.").split(" ");
					doc.setUid(null);
					doc.setMajorTreat(null);
					doc.setName(null);
					//doc.setSsn(null);
					doc.setPhone(docItem[0]);
					doc.setEmail(docItem[1]);
					doc.setDocPosition(null);
					service.change(doc);
					break;
				case "12":
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
