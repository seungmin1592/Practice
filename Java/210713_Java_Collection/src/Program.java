
public class Program {

	public static void main(String[] args) {
		GList<Integer> list = new GList<>();
		list.add(3);
		list.add(5);
		int size = list.size();
		System.out.printf("size : %d\n", size);
		
		list.clear();
		size = list.size();
		System.out.printf("size : %d\n", size);
		
		list.add(7);
		int num = list.get(0); // Object -> Integer
		System.out.printf("num : %d\n", num);
		
		// num = (Integer)list.get(1);
		

	}

}
