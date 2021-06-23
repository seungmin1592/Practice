package admin;

public class Main {

	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
			AdminMenu am = new AdminMenu();
			am.AdminMenu();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	

}
