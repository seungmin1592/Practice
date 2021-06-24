package admin;

import java.io.InputStream;
import java.util.Scanner;

public class AdminMenu {

	public static void AdminMenu() {
		Scanner sc = new Scanner(System.in);

		AdminMemberManager manager = new AdminMemberManager(AdminMemberDao.getInstance());
		AdminServiceImpl svcmanager = new AdminServiceImpl(AdminDaoImpl.getInstance());

		AdminMenu fMemu = new AdminMenu();
		
		System.out.println("패스워드를 입력하세요 ");
		String pw = sc.nextLine();
		
		if(!pw.equals("admin")) {
			System.out.println("패스워드를 잘못 입력하셨습니다.");
			return;
		} 
		
		while(true) {
			
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 관리자 메뉴 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println();
			System.out.println("1번 : 회원 정보 리스트 | 2번 : 휴면 계정 설정 | 3번 : 전체 판매 리스트 | 4번 : 총 매출 | 5번 : 월 별 매출 | 6번 : 일일 매출 | 7번 : 재고 조회 | 8번 : 재고 입력 | 9번 : 상품 관리 | 0번 : 종료 ");
			System.out.println();
			System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println();
			System.out.print("메뉴를 입력하세요 : ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 :
					manager.AdminMemberList();
					break;
				case 2 :
					manager.AdminMemberChange();
					break;
				case 3 : 
					svcmanager.orderList();
					break;
				case 4 : 
					svcmanager.salseManagement();
					break;
				case 5 : 
					svcmanager.salseManagementMonth();
					break;
				case 6 : 
					svcmanager.salseManagementDaily();
					break;
				case 7 : 
					svcmanager.inventory();
					break;
				case 8 :
					svcmanager.putIndentory();
					break;
				case 9 :
					AdminProductMenu.ProductMenu();
					break;
				case 0 :
					System.out.println("이전메뉴로 돌아갑니다.");
					return;
			}
			
			System.out.println();
		}
	}



}