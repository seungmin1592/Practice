package Inheritance;

public class Female extends Person {
	String gender = "여자";
	String hobby;
	
	public Female(String name, String personNum, String hobby) {
		super(name, personNum);
		this.hobby = hobby;
	}
	
	public void hobby() {
		System.out.println("제 성별은 " + gender + "이며, 취미는 " + hobby + "입니다." );
	}
	
	
	@Override
	public void showInfo() {
		super.showInfo();
	}

}
