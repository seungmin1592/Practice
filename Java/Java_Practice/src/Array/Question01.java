package Array;

import java.util.Scanner;

public class Question01 {
	// 최소값 구하는 메소드
	public static int miniValue(int[] arr) {
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	// 최대값 구하는 메소드
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 입력 : ");
		int arrIdx = sc.nextInt();
		int arr[] = new int[arrIdx];
		
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(i+1 + "번째 배열의 저장될 정수값 : ");
			arr[i] = sc.nextInt();
		}
				
		System.out.println("배열에 저장된 값 중 최소값은 : " + miniValue(arr));
		System.out.println("배열에 저장된 값 중 최대값은 : " + maxValue(arr));

	}

}
