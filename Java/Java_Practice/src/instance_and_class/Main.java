package instance_and_class;

public class Main {

	public static void main(String[] args) {
		Member member = new Member("김승민","010-0000-0000","컴공",1,"email@email.com","970324","경기도 안산시");
		member.showInfo();
		System.out.println("=======================================");
		Member member2 = new Member("김승민1","010-1111-1111","체육",2,"email1@email1.com");
		member2.showInfo();
	}

}
