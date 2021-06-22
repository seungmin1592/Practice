import java.util.Scanner;
import admin.AdminMenu;

public class StartMenu {
	void FirstMenu() {
	
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1 : 
				System.out.println("로그인");
				break;
			case 2 : 
				System.out.println("회원가입");
				break;
			case 3 :
				System.out.println("관리자 페이지 비밀번호를 입력해주세요 : ");
				String pw = sc.nextLine();
				
				if(pw.equals("admin")) {
					
					AdminMenu.AdminMenu();
					break;
				} else { 
					System.out.println("관리자 비밀번호가 다릅니다.");
					return;
				}
				
				
		}
		
	}
}
