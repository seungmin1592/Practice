package admin;

import java.util.Scanner;



public class AdminMemberMenu {
	static void AdminMemberMenu() {
		
		AdminMemberManager manager = new AdminMemberManager(AdminMemberDao.getInstance());
		
		AdminMenu fMemu = new AdminMenu();
		
		System.out.println("=========관리자 회원관리 메뉴=========");
		System.out.println("1번 : 회원 목록 | 2번 : 회원 삭제");
		System.out.println("메뉴를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1 :
				manager.AdminMemberList();
				
				System.out.println("");
				int choice2 = sc.nextInt();
				switch(choice2) {
					case 1: 
						
				}
				break;
			case 2 :
				manager.AdminMemberDel();
				break;
		}
		
	}
}
