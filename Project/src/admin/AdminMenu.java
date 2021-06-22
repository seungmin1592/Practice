package admin;

import java.io.InputStream;
import java.util.Scanner;

public class AdminMenu {

	static void AdminMenu() {
		System.out.println("=========관리자 메뉴=========");
		System.out.println("1번 : 회원 관리 | 2번 : 매출 관리 | 3번 : 재고 관리");
		System.out.println("메뉴를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1 :
				AdminMemberMenu.AdminMemberMenu();
				break;
			case 2 :
				AdminSalesMenu.AdminSalesMenu();
				break;
			case 3 : 
				AdminStockMenu.AdminStockMenu();
				break;
		}

	}
		
	

}
