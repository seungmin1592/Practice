import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		// GList<Integer> list = new GList<>();

		// arraylist : 중복 가능
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(7);
		list.add(7);
		
		System.out.println(list.get(2));
		System.out.println(list.size());
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%d,", list.get(i));
		}
		
		
		// set : 중복 불가
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(7);
		set.add(7);
		System.out.println(set.add(6));
		System.out.println(set.size());
		
		
		// map : key, value
		Map<String, Object> map = new HashMap<>();
		map.put("id", 3);
		map.put("title", "hello");
		map.put("hit", 12);
		
		System.out.println(map.get("title"));

		
		// num = (Integer)list.get(1);
		

	}

}
