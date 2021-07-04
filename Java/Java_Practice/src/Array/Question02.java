package Array;

public class Question02 {

	public static void addOneDArr(int[][] arr, int add) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] += add;
				System.out.println(i+1 + "-" + (j+1) + "의 값은 : " + arr[i][j]);
			}
			System.out.println("=========================");
			
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {
						{10,20,30}, 
						{20,30,60},
						{30,20,10}
					};
		addOneDArr(arr, 4);
	}

}
