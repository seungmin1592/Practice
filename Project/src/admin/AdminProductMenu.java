package admin;

import java.util.Scanner;

public class AdminProductMenu {
	public static void ProductMenu() {
		Scanner sc = new Scanner(System.in);
		
		ProductManager pm = new ProductManager();
		while(true) {
			System.out.println("■■■■■■■■■■■■■■■ 상품 수정 메뉴입니다 ■■■■■■■■■■■■■■■");
			System.out.println("1번 : 상품 추가 | 2번 : 상품 수정");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : 
					pm.productList();
					pm.productInsert();
					break;
				case 2 : 
					pm.productList();
					pm.productUpdate();
					break;	
			}
		}
	}
}
