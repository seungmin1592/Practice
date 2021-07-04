package Inheritance;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("김승민", "970324");
		person.showInfo();
		
		System.out.println("=====================");
		Male male = new Male("김승민", "970324", "운동");
		male.showInfo();
		male.hobby();
		
		System.out.println("=====================");
		Female female = new Female("홍길동", "990801", "독서");
		female.showInfo();
		female.hobby();

	}

}
