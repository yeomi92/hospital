package serviceImpl;

import domain.MemberBean;
import domain.PatientBean;
import service.HospitalService;

public class HospitalServiceImpl implements HospitalService{
	@Override
	public String getBmi(PatientBean pat){
		String result="";
		double bmi=0;
		bmi=pat.getWeight()/(pat.getHeight()*pat.getHeight());
		if (bmi>30.0){
			result="����";
		} else if (bmi>25.0){
			result="��";
		} else if (bmi>23.0){
			result="��ü��";
		} else if (bmi>18.5){
			result="����";
		} else{
			result="��ü��";
		}
		return result;
	}
	@Override
	public String checkDocIdNurId(int docId, int nurId,Object[] object){
		String result="";
		System.out.println(((MemberBean) object[0]).getUid()+"   "+((MemberBean)object[1]).getUid());
		if(docId==(((MemberBean) object[0]).getUid())&&nurId==(((MemberBean)object[1]).getUid())){
			((PatientBean)object[2]).setDocId(docId);
			((PatientBean)object[2]).setNurId(nurId);
			result=((PatientBean)object[2]).toString();
		}else{
			result="�ǻ� ��ȣ�� ��� �����ϼ���.";
		}
		return result;
	}
}
