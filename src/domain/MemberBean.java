package domain;

import java.util.Calendar;

public class MemberBean {
	protected String name, ssn, addr, phone, email,uid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getGender(String ssn){
		String gender="";
		switch(ssn.charAt(7)){
			case '1':case '3':
				gender = "³²";
				break;
			case '2':case '4':
				gender = "¿©";
				break;
		}
		return gender;
	}
	public int getAge(String ssn){
		int age=0;
		int jumin=Integer.parseInt(ssn.substring(0,2));
		switch(ssn.charAt(7)){
			case '1':case '2':
				age=Calendar.getInstance().get(Calendar.YEAR)-(1900+jumin)+1;
				break;
			case '3':case '4':
				age=Calendar.getInstance().get(Calendar.YEAR)-(2000+jumin)+1;
				break;
		}
		return age;
	}
}
