public class Main {

	public static void main(String[] args) {
		StartMenu start = new StartMenu();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			start.FirstMenu();
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}