package Inheritance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
	String name;
	String personNum;
	
	public Person() {
		
	}
	
	public Person(String name, String personNum) {
		this.name = name;
		this.personNum = personNum;
	}
	
	public void showInfo() {
		Date date = new Date();
		SimpleDateFormat today = new SimpleDateFormat("YY");
		
		String year = today.format(date);
		
		int age = 100 + (Integer.parseInt(year) - Integer.parseInt(personNum.substring(0, 2))); 
		System.out.println("안녕하세요 저는 " + name + "입니다. " + age + "살 입니다." );
	}
}
