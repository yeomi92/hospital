package controller;

import javax.swing.JOptionPane;

import contants.Hospital;
import domain.DoctorBean;
import domain.MemberBean;
import domain.NurseBean;
import domain.PatientBean;
import enums.AdminButt;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start(){
		AdminService service = new AdminServiceImpl();
		Object[] object = new Object[3];
		DoctorBean doc=null;
		NurseBean nur=null;
		AdminButt[] buttons={AdminButt.CLOSE,AdminButt.DOCTOR_ADD,AdminButt.NURSE_ADD,AdminButt.DOCTOR_LIST,AdminButt.NURSE_LIST,AdminButt.FIND_BY_DOC_ID,AdminButt.FIND_BY_NUR_ID,AdminButt.FIND_BY_DOC_NAME,AdminButt.FIND_BY_NUR_NAME,AdminButt.CHANGE_DOC_INFO,AdminButt.CHANGE_NUR_INFO, AdminButt.DELETE_DOC, AdminButt.DELETE_NUR};
		while(true){
			AdminButt select=(AdminButt)JOptionPane.showInputDialog(null,"ADMIN PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]);
			switch(select){
				case CLOSE:
					JOptionPane.showConfirmDialog(null, "EXIT Ok??");
					return;
				case DOCTOR_ADD:
					doc = new DoctorBean();
					String[] docInfoArr= input(Hospital.DOC_SPEC).split(" ");
					doc.setUid((docInfoArr[0]));
					//doc.setMajorTreat(docInfoArr[1]);
					doc.setName(docInfoArr[1]);
					/*doc.setSsn(docInfoArr[3]);
					doc.setPhone(docInfoArr[4]);
					doc.setEmail(docInfoArr[5]);
					doc.setDocPosition(docInfoArr[6]);
					showMsg(doc.toString());*/
					object[0]=doc;
					service.regist(doc);
					break;
				case NURSE_ADD:
					nur = new NurseBean();
					String nurInfo=input(Hospital.NUR_SPEC);
					String[] nurInfoArr=nurInfo.split(" ");
					nur.setUid((nurInfoArr[0]));
					//nur.setMajorJob(nurInfoArr[1]);
					nur.setName(nurInfoArr[1]);
					/*nur.setSsn(nurInfoArr[3]);
					nur.setPhone(nurInfoArr[4]);
					nur.setEmail(nurInfoArr[5]);
					nur.setNurPosition(nurInfoArr[6]);
					showMsg(nur.toString());*/
					object[1]=nur;
					service.regist(nur);
					break;
				case DOCTOR_LIST:
					DoctorBean[] docList = service.doctorList();
					String docListResult="";
					if(docList.length==0){
						showMsg("�ǻ� ����� �����ϴ�.");
					}else{
						for(int i=0;i<service.count()[0];i++){
							docListResult+=(i+1)+"��\n"+docList[i].toString()+"\n";
						}
						showMsg(docListResult);
					}
					break;
				case NURSE_LIST:
					NurseBean[] nurList = service.nurseList();
					String nurListResult="";
					if(nurList.length==0){
						showMsg("��ȣ�� ����� �����ϴ�.");
					}else{
						for(int i=0;i<service.count()[1];i++){
							nurListResult+=(i+1)+"��\n"+nurList[i].toString()+"\n";
						}
						showMsg(nurListResult);
					}
					break;
				case FIND_BY_DOC_ID://�ǻ� ���̵� ã��
					doc.setUid(input("ã�� �ǻ� ���̵� �Է��ϼ���."));
					MemberBean memberDocId = service.findById(doc);
					showMsg(service.exist(doc)?"�ش� �ǻ簡 �����ϴ�.":memberDocId.toString());
					break;
				case FIND_BY_NUR_ID://��ȣ�� ���̵� ã��
					nur.setUid(input("ã�� ��ȣ�� ���̵� �Է��ϼ���."));
					MemberBean memberNurId = service.findById(nur);
					showMsg(service.exist(nur)?"�ش� ��ȣ�簡 �����ϴ�.":memberNurId.toString());
				case FIND_BY_DOC_NAME://�ǻ� �̸� ã��
					doc= new DoctorBean();
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
				case FIND_BY_NUR_NAME://��ȣ�� �̸� ã��
					nur= new NurseBean();
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
				case CHANGE_DOC_INFO://�ǻ� change
					doc = new DoctorBean();
					String[] docItem = input("���̵�, ������ ������ �Է��ϼ���.(phone,email)").split(" ");
					doc.setUid(docItem[0]);
					doc.setMajorTreat(null);
					doc.setName(null);
					doc.setSsn(null);
					doc.setPhone(docItem[1]);
					doc.setEmail(docItem[2]);
					doc.setDocPosition(null);
					service.change(doc);
					break;
				case CHANGE_NUR_INFO://��ȣ�� change
					nur = new NurseBean();
					String[] nurItem = input("���̵�, ������ ������ �Է��ϼ���.(phone,email)").split(" ");
					nur.setUid(nurItem[0]);
					nur.setMajorJob(null);
					nur.setName(null);
					nur.setSsn(null);
					nur.setPhone(nurItem[1]);
					nur.setEmail(nurItem[2]);
					nur.setNurPosition(null);
					service.change(nur);
					break;
				case DELETE_DOC:
					doc.setUid(input("������ �ǻ� ���̵� �Է��ϼ���."));
					service.remove(doc);
					break;
				case DELETE_NUR:
					nur.setUid(input("������ ��ȣ�� ���̵� �Է��ϼ���."));
					service.remove(nur);
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
