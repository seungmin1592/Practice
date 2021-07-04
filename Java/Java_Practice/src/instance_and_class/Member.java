// 인스턴스와 클래스

package instance_and_class;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	String name;
	String phoneNum;
	String major; 
	int grade;
	String email;
	String birthday;
	String address;
	
	public Member(String name, String phoneNum, String major, int grade, String email, String birthday, String address) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	
	public Member(String name, String phoneNum, String major, int grade, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
	}


	public void showInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
		System.out.println("이메일 : " + email);
		System.out.println("생일 : " + birthday);
		System.out.println("주소 : " + address);
	}
	
	


}

