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
		AdminButt[] buttons={AdminButt.CLOSE,AdminButt.ADD_STAFF,AdminButt.STAFF_LIST,AdminButt.FIND_BY_STAFF_ID,AdminButt.FIND_BY_STAFF_NAME,AdminButt.CHANGE_STAFF_INFO, AdminButt.DELETE_STAFF};
		AdminButt[] addButt={AdminButt.DOCTOR,AdminButt.NURSE};
		while(true){
			AdminButt select=(AdminButt)JOptionPane.showInputDialog(null,"ADMIN PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]);
			switch(select){
				case CLOSE:
					JOptionPane.showConfirmDialog(null, "EXIT Ok??");
					return;
				case ADD_STAFF:
					AdminButt addSelect=(AdminButt)JOptionPane.showInputDialog(null,"ADD PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, addButt, addButt[0]);
					switch(addSelect){
					case DOCTOR:
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
					case NURSE:
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
					}
					break;
				case STAFF_LIST:
					AdminButt listSelect=(AdminButt)JOptionPane.showInputDialog(null,"ADD PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, addButt, addButt[0]);
					switch(listSelect){
					case DOCTOR:
						DoctorBean[] docList = service.doctorList();
						String docListResult="";
						if(docList.length==0){
							showMsg("의사 목록이 없습니다.");
						}else{
							for(int i=0;i<service.count()[0];i++){
								docListResult+=(i+1)+"번\n"+docList[i].toString()+"\n";
							}
							showMsg(docListResult);
						}
						break;
					case NURSE:
						NurseBean[] nurList = service.nurseList();
						String nurListResult="";
						if(nurList.length==0){
							showMsg("간호사 목록이 없습니다.");
						}else{
							for(int i=0;i<service.count()[1];i++){
								nurListResult+=(i+1)+"번\n"+nurList[i].toString()+"\n";
							}
							showMsg(nurListResult);
						}
						break;
					}
					break;
				case FIND_BY_STAFF_ID:
					AdminButt finaIdSelect=(AdminButt)JOptionPane.showInputDialog(null,"ADD PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, addButt, addButt[0]);
					switch(finaIdSelect){
					case DOCTOR:
						doc.setUid(input("찾을 의사 아이디를 입력하세요."));
						MemberBean memberDocId = service.findById(doc);
						showMsg(service.exist(doc)?"해당 의사가 없습니다.":memberDocId.toString());
						break;
					case NURSE:
						nur.setUid(input("찾을 간호사 아이디를 입력하세요."));
						MemberBean memberNurId = service.findById(nur);
						showMsg(service.exist(nur)?"해당 간호사가 없습니다.":memberNurId.toString());
						break;
					}
					break;
				case FIND_BY_STAFF_NAME:
					AdminButt finaNameSelect=(AdminButt)JOptionPane.showInputDialog(null,"ADD PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, addButt, addButt[0]);
					switch(finaNameSelect){
					case DOCTOR:
						doc= new DoctorBean();
						doc.setName(input("찾을 의사 이름을 입력하세요."));
						if(service.countByName(doc)==0){
							showMsg("해당 의사가 없습니다.");
						}else{
							MemberBean[] memberDocName = service.findByName(doc);
							String nameResult="";
							for(int i=0;i<service.countByName(doc);i++){
								nameResult+=(i+1)+"번\n"+memberDocName[i].toString()+"\n";
							}
							showMsg(nameResult);
						}
						break;
					case NURSE:
						nur= new NurseBean();
						nur.setName(input("찾을 간호사 이름을 입력하세요."));
						if(service.countByName(nur)==0){
							showMsg("해당 간호사가 없습니다.");
						}else{
							MemberBean[] memberNurName = service.findByName(nur);
							String nameResult="";
							for(int i=0;i<service.countByName(nur);i++){
								nameResult+=(i+1)+"번\n"+memberNurName[i].toString()+"\n";
							}
							showMsg(nameResult);
						}
						break;
					}
					break;
				case CHANGE_STAFF_INFO:
					AdminButt changeSelect=(AdminButt)JOptionPane.showInputDialog(null,"ADD PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, addButt, addButt[0]);
					switch(changeSelect){
					case DOCTOR:
						doc = new DoctorBean();
						String[] docItem = input("아이디, 변경할 내용을 입력하세요.(phone,email)").split(" ");
						doc.setUid(docItem[0]);
						doc.setMajorTreat(null);
						doc.setName(null);
						doc.setSsn(null);
						doc.setPhone(docItem[1]);
						doc.setEmail(docItem[2]);
						doc.setDocPosition(null);
						service.change(doc);
						break;
					case NURSE:
						nur = new NurseBean();
						String[] nurItem = input("아이디, 변경할 내용을 입력하세요.(phone,email)").split(" ");
						nur.setUid(nurItem[0]);
						nur.setMajorJob(null);
						nur.setName(null);
						nur.setSsn(null);
						nur.setPhone(nurItem[1]);
						nur.setEmail(nurItem[2]);
						nur.setNurPosition(null);
						service.change(nur);
						break;
					}
					break;
				case DELETE_STAFF:
					AdminButt deleteSelect=(AdminButt)JOptionPane.showInputDialog(null,"ADD PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, addButt, addButt[0]);
					switch(deleteSelect){
					case DOCTOR:
						doc.setUid(input("삭제할 의사 아이디를 입력하세요."));
						service.remove(doc);
						break;
					case NURSE:
						nur.setUid(input("삭제할 간호사 아이디를 입력하세요."));
						service.remove(nur);
						break;
					}
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
