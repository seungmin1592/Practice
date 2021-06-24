package admin;

import java.util.Scanner;


// 버려
public class AdminSalesMenu {
	static void AdminSalesMenu() {
		System.out.println("=========관리자 매출 관리 메뉴=========");
		System.out.println("1번 : 일일 매출 | 2번 : 월 별 매출 ");
		System.out.println("메뉴를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1 :
				System.out.println("회원 목록");
				break;
			case 2 :
				System.out.println("회원 삭제");
				break;
			case 3 : 
				System.out.println("회원 정보 수정");
				break;
		}
	}
}
