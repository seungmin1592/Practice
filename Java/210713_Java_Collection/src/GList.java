
public class GList<T> {
	
	private Object[] nums;
	private int current;
	private int capacity; // 용량
	private int amount; // 늘려주는 값
	
	public GList() {
		current = 0;
		capacity = 3;
		amount = 5;
		nums = new Object[capacity];
	}

	public void add(T num) {
		

		if(capacity <= current) {
			Object[] temp = new Object[capacity + amount];
			
			// nums의 데이터를 temp로 입력
			for(int i=0; i<current; i++) {
				temp[i] = nums[i];
			}
			nums = temp;
			capacity += amount;
		}

		nums[current] = num;
		current++;
		
	}

	public void clear() {
//		for(int i=0; i<current; i++) {
//			nums[i] = 0;
//		}
		
		// nums = new int[3];
		current = 0;
		
	}
	
	public int size() {
		return current;
	}

	public T get(int index) {
		if(current <= index) {
			throw new IndexOutOfBoundsException();
		}
		return (T)nums[index];
	}

	

}
