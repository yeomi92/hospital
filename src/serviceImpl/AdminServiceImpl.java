package serviceImpl;

import domain.DoctorBean;
import domain.MemberBean;
import domain.NurseBean;
import domain.PatientBean;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
	private DoctorBean[] doctorList;
	private NurseBean[] nurseList;
	private int[] count;
	public AdminServiceImpl() {
		count = new int[2];
		doctorList = new DoctorBean[count[0]];
		nurseList = new NurseBean[count[1]];
	}
	@Override
	public String getBmi(PatientBean pat){
		String result="";
		double bmi=0,height=0;
		height=Double.parseDouble(pat.getHeight())/100;
		bmi=Double.parseDouble(pat.getWeight())/((height*height));
		if (bmi>30.0){
			result="고도비만";
		} else if (bmi>25.0){
			result="비만";
		} else if (bmi>23.0){
			result="과체중";
		} else if (bmi>18.5){
			result="정상";
		} else{
			result="저체중";
		}
		return result;
	}
	@Override
	public String checkDocIdNurId(String docId, String nurId,Object[] object){
		String result="";
		System.out.println(((MemberBean) object[0]).getUid()+","+((MemberBean)object[1]).getUid());
		if(docId==(((MemberBean) object[0]).getUid())&&nurId==(((MemberBean)object[1]).getUid())){
			((PatientBean)object[2]).setDocId(docId);
			((PatientBean)object[2]).setNurId(nurId);
			result=((PatientBean)object[2]).toString();
		}else{
			result="의사 간호사 등록 먼저하세요.";
		}
		return result;
	}
	@Override
	public void regist(MemberBean member) {
		if((member!=null)&&(member instanceof DoctorBean)){
			if(count[0]==doctorList.length){
				DoctorBean[] temp = new DoctorBean[count[0]+10];
				for(int i=0;i<count[0];i++){
					temp[i]=doctorList[i];
				}
				doctorList=temp;
			}
			doctorList[count[0]++]=(DoctorBean) member;
		}else{
			if(count[1]==nurseList.length){
				NurseBean[] temp = new NurseBean[count[1]+10];
				for(int i=0;i<count[1];i++){
					temp[i]=nurseList[i];
				}
				nurseList=temp;
			}
			nurseList[count[1]++]=(NurseBean) member;
		}
	}
	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean memberId=new MemberBean();
		if((member!=null)&&(member instanceof DoctorBean)){
			for(int i=0;i<count[0];i++){
				if(member.getUid().equals(doctorList[i].getUid())){
					memberId=doctorList[i];
					break;
				}
			}
		}else{
			for(int i=0;i<count[1];i++){
				if(member.getUid().equals(nurseList[i].getUid())){
					memberId=nurseList[i];
					break;
				}
			}
		}
		return memberId;
	}
	@Override
	public MemberBean[] findByName(MemberBean member) {
		MemberBean[] memberName=new MemberBean[countByName(member)];
		int num=0;
		if((member!=null)&&(member instanceof DoctorBean)){
			for(int i=0;i<count[0];i++){
				if(member.getName().equals(doctorList[i].getName())){
					memberName[num]=doctorList[i];
					num++;
				}
			}
		}else{
			for(int i=0;i<count[1];i++){
				if(member.getName().equals(nurseList[i].getName())){
					memberName[num]=nurseList[i];
					num++;
				}
			}
		}
		return memberName;
	}
	@Override
	public int countByName(MemberBean member) {
		int num=0;
		if((member!=null)&&(member instanceof DoctorBean)){
			for(int i=0;i<count[0];i++){
				if(member.getName().equals(doctorList[i].getName())){
					num++;
				}
			}
		}else{
			for(int i=0;i<count[1];i++){
				if(member.getName().equals(nurseList[i].getName())){
					num++;
				}
			}
		}
		return num;
	}
	@Override
	public DoctorBean[] doctorList() {
		return doctorList;
	}
	@Override
	public NurseBean[] nurseList() {
		return nurseList;
	}
	@Override
	public int[] count() {
		return count;
	}
	@Override
	public void change(MemberBean member) {
		if((member!=null)&&(member instanceof DoctorBean)){
			for(int i=0;i<count[0];i++){
				if(member.getUid().equals(doctorList[i].getUid())){
					System.out.println("내용변경"+i);
					doctorList[i].setName((member.getName().equals(""))?doctorList[i].getName():member.getName());
					doctorList[i].setEmail((member.getEmail().equals(""))?doctorList[i].getEmail():member.getEmail());
					doctorList[i].setPhone((member.getPhone().equals(""))?doctorList[i].getPhone():member.getPhone());
				}
			}
		}else{
			for(int i=0;i<count[1];i++){
				if(member.getUid().equals(nurseList[i].getUid())){
					nurseList[i].setName((member.getName().equals(""))?nurseList[i].getName():member.getName());
					nurseList[i].setEmail((member.getEmail().equals(""))?nurseList[i].getEmail():member.getEmail());
					nurseList[i].setPhone((member.getPhone().equals(""))?nurseList[i].getPhone():member.getPhone());
				}
			}
		}		
	}
	@Override
	public void remove(MemberBean member) {
		if((member!=null)&&(member instanceof DoctorBean)){
			for(int i=0;i<count[0];i++){
				if(member.getUid().equals(doctorList[i].getUid())){
					doctorList[i]=doctorList[count[0]-1];
					count[0]--;
					break;
				}
			}
		}else{
			for(int i=0;i<count[1];i++){
				if(member.getUid().equals(nurseList[i].getUid())){
					doctorList[i]=doctorList[count[1]-1];
					count[1]--;
					break;
				}
			}
		}
	}
	@Override
	public boolean exist(MemberBean member) {
		boolean check=false;
		if((member!=null)&&(member instanceof DoctorBean)){
			for(int i=0;i<count[0];i++){
				if(member.getUid().equals(doctorList[i].getUid())){
					check=true;
					break;
				}
			}
		}else{
			for(int i=0;i<count[1];i++){
				if(member.getUid().equals(nurseList[i].getUid())){
					check=true;
					break;
				}
			}
		}
		return check;
	}
}
