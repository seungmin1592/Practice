package orders;

public class OrderTestMain {

	public static void main(String[] args) {
//		OrderManager2 or = new OrderManager2();
		OrderManager or = new OrderManager();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			or.menu();
			System.out.println("종료");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ProductManager p = new ProductManager();
//		p.allMenu();

	}

}