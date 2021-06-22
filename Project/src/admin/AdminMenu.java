package admin;

import java.io.InputStream;
import java.util.Scanner;

public class AdminMenu {

	public static void AdminMenu() {
		
		AdminMemberManager manager = new AdminMemberManager(AdminMemberDao.getInstance());
		
		AdminMenu fMemu = new AdminMenu();
		
		System.out.println("=========관리자 메뉴=========");
		System.out.println("1번 : 회원 정보 리스트 | 2번 : 회원 삭제 | 3번 : 총 매출  | 4번 : 월 별 매출 | 5번 : 당일 매출 | 6번 : 재고 조회");
		System.out.println("메뉴를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1 :
				manager.AdminMemberList();
				
				System.out.println("================================");
				System.out.println("1번 : 관리자 메뉴 | 2번 : 메인 페이지");
				int choice2 = sc.nextInt();
				
				switch(choice2) {
					case 1 :
					return ;
					
					case 2 :
						return; // 메인 페이지로 이동
				}
				break;
				
			case 2 :
				manager.AdminMemberDel();
				break;
			case 3 : 
				//AdminStockMenu.AdminStockMenu();
				break;
			case 4 :
				return;
		}

	}
		
	

}
