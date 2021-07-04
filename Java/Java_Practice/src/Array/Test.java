package Array;

public class Test {
	public static void main(String[] args) {
		int [][] arr = new int[9][9];
		
		for(int i = 1; i <= arr.length; i++) {
			System.out.println("========="+ i + "단=========");
			for(int j = 1; j <= arr.length; j++) {
				System.out.printf("%d * %d = %d", i, j, (i*j));
				System.out.println();
			}
		}
	}
	
}
