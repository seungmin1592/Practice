// 연산자

public class Calculator {

	// 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	public static int plus(int a, int b) {
		int result = a + b;
		return result;
	}
	// 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	public static int minus(int a, int b) {
		int result = a - b;
		return result;
	}
	// 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	public static int multiply(int a, int b) {
		int result = a * b;
		return result;
	}
	// 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	public static double division(int a, int b) {
		double result = a / b;
		return result;
	}
	//  실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환
	public static double round(int a) {
		double result = 2 * 3.14 * a;
		return result;
	}
	// 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환
	public static double area(int a) {
		double result = a * a * 3.14;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(plus(1,2));
		System.out.println(minus(1,2));
		System.out.println(multiply(1,2));
		System.out.println(division(1,2));
		System.out.println(round(3));
		System.out.println(area(3));
	}

}
