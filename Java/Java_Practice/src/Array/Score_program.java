package Array;

public class Score_program {
	public static void main(String[] args) {
		// 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의
		int[] kor = new int[10];
		int[] math = new int[10];
		int[] eng = new int[10];
		
		
		// 10개의 국어 점수
		kor[0] = 76;
		kor[1] = 100;
		kor[2] = 100;
		kor[3] = 98;
		kor[4] = 55;
		kor[5] = 78;
		kor[6] = 80;
		kor[7] = 60;
		kor[8] = 90;
		kor[9] = 46;
	
		
		// 10개의 수학 점수
		math[0] = 71;
		math[1] = 98;
		math[2] = 45;
		math[3] = 92;
		math[4] = 52;
		math[5] = 75;
		math[6] = 87;
		math[7] = 80;
		math[8] = 96;
		math[9] = 43;
		
		
		// 10개의 영어 점수
		eng[0] = 71;
		eng[1] = 45;
		eng[2] = 48;
		eng[3] = 56;
		eng[4] = 52;
		eng[5] = 75;
		eng[6] = 87;
		eng[7] = 80;
		eng[8] = 96;
		eng[9] = 43;
		
		
		// 모든 학생의 점수 출력
		for(int i = 0; i < kor.length; i++) {
			System.out.println(i+1 + "번 학생의 국어 점수 : " + kor[i]);
		}
		
		
		// 평균 출력
		int avg = 0;
		int sum = 0;
		
		for (int i = 0; i < kor.length; i++) {
			sum += kor[i];
			avg = sum / kor.length;
		}
		
		System.out.println("평균은 " + avg + "점 입니다.");
	}
		
}
