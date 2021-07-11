package interface_and_abstract;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Calculator cal = new ImplementCal();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요.");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 숫자를 입력하세요.");
		int num2 = sc.nextInt();
		
		
		System.out.println(num1 + " + " + num2 + " = " + cal.add(num1, num2));
		System.out.println(num1 + " - " + num2 + " = " + cal.substract(num1, num2));
		System.out.println(num1 + " * " + num2 + " = " + cal.multiply(num1, num2));
		System.out.println(num1 + " / " + num2 + " = " + cal.divide(num1, num2));
		
		

	}

}
