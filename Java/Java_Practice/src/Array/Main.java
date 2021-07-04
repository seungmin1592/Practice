package Array;

public class Main {

	public static void main(String[] args) {
	
		// 일차원 배열
		
//		Student[] studentArr = new Student[10];
//		
//		
//		studentArr[0] = new Student("김승민1",100,100,100);
//		studentArr[1] = new Student("김승민2",90,90,90);
//		studentArr[2] = new Student("김승민3",80,80,80);
//		studentArr[3] = new Student("김승민4",70,70,70);
//		studentArr[4] = new Student("김승민5",60,60,60);
//		studentArr[5] = new Student("김승민6",50,50,50);
//		studentArr[6] = new Student("김승민7",56,56,56);
//		studentArr[7] = new Student("김승민8",88,88,88);
//		studentArr[8] = new Student("김승민9",45,45,45);
//		studentArr[9] = new Student("김승민10",78,100,89);
//		
//		
//		for(int i=0; i<studentArr.length; i++) {
//			System.out.println(studentArr[i].getName() + " 학생의 총점은 " +  studentArr[i].sum() + "이며, 평균은" + 
//								studentArr[i].avg() + "입니다.");
//		}
		
		// 다차원 배열
		// 반 별 평균 구하기
	
		Student[][] student = new Student[2][5];
		
		student[0][0] = new Student("1_김승민1", 50,60,80);
		student[0][1] = new Student("1_김승민2", 54,62,87);
		student[0][2] = new Student("1_김승민3", 53,40,95);
		student[0][3] = new Student("1_김승민4", 67,43,53);
		student[0][4] = new Student("1_김승민5", 62,13,83);
		
		
		student[1][0] = new Student("2_김승민1", 62,13,45);
		student[1][1] = new Student("2_김승민2", 82,53,25);
		student[1][2] = new Student("2_김승민3", 60,83,55);
		student[1][3] = new Student("2_김승민4", 68,93,75);
		student[1][4] = new Student("2_김승민5", 28,63,95);
		
		double avg2 = 0;
		int i = 0;
		for(i = 0; i < student[0].length; i++) {
			avg2 = student[0][i].sum();
		}

		System.out.println("1반의 평균은 " + avg2 / i + "입니다.");
		
	}

}
