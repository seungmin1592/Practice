// 조건문

package if_and_for;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	String name;
	int age;
	
	static Date date = new Date();
	static SimpleDateFormat today = new SimpleDateFormat("YYYY");
	static String year = today.format(date);
	// 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
	// - 매개변수로 태어난 해(년도)를 전달받습니다.
	// - 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
	// - 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.

	
	public static void inoculation(int a) {

		System.out.println("나이는 : 만 " + (Integer.parseInt(year) - a));
		if(Integer.parseInt(year) - a < 15 || Integer.parseInt(year) - a >= 65) {
			// 나이가 15세 미만이거나, 65세 이상일 경우
			System.out.println("무료 예방 접종이 가능합니다.");
		} else {
			// 나이가 15세 이상이거나, 65세 미만일 경우
			System.out.println("무료 예방 접종 대상이 아닙니다.");
		}
	}
	
	
	// 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
	// - 매개변수로 태어난 해(년도)를 전달받습니다.
	// - 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
	// - 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
	// - 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
	
	public static void checkUp(int a) {
		int AdultAge = Integer.parseInt(year) - a;
		
		System.out.println("나이는 : 만 " + AdultAge);
		
		if(AdultAge >= 20) { // 나이가 20세 이상일 경우
			if(Integer.parseInt(year) % 2 == 0) { // 올해가 짝수년일 경우
				if(a % 2 == 0) { // 태어난 년도가 짝수일 경우
					System.out.println("건강검진 검사 대상입니다.");
					if(AdultAge >= 40) { // 40세 이상인 경우
						System.out.println("암 검사 무료 대상입니다.");
					}
				} else { // 태어난 년도가 짝수가 아닐 경우
					System.out.println("건강검진은 내년 대상입니다.");
				}
			} else if(Integer.parseInt(year) % 2 != 0) { // 올해가 홀수년일 경우
				if(a % 2 != 0) { // 태어난 년도가 홀수일 경우
					System.out.println("건강검진 검사 대상입니다.");
					if(AdultAge >= 40) { // 나이가 40세 이상일 경우
						System.out.println("암 검사 무료 대상입니다.");
					}
				} else { // 태어난 년도가 홀수가 아닐 경우
					System.out.println("건강검진은 내년 대상입니다.");
				}
			}		
		} else { // 나이가 20세 미만일 경우
			System.out.println("성인이 아닙니다.");
		}
	}

}

