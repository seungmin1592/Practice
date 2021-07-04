package Array;

public class Main {

	public static void main(String[] args) {
	
		Student[] studentArr = new Student[10];
		
		
		studentArr[0] = new Student("김승민1",100,100,100);
		studentArr[1] = new Student("김승민2",90,90,90);
		studentArr[2] = new Student("김승민3",80,80,80);
		studentArr[3] = new Student("김승민4",70,70,70);
		studentArr[4] = new Student("김승민5",60,60,60);
		studentArr[5] = new Student("김승민6",50,50,50);
		studentArr[6] = new Student("김승민7",56,56,56);
		studentArr[7] = new Student("김승민8",88,88,88);
		studentArr[8] = new Student("김승민9",45,45,45);
		studentArr[9] = new Student("김승민10",78,100,89);
		
		
		for(int i=0; i<studentArr.length; i++) {
			System.out.println(studentArr[i].getName() + " 학생의 총점은 " +  studentArr[i].sum() + "이며, 평균은" + 
								studentArr[i].avg() + "입니다.");
		}
		
		
		
		
		
	}

}
