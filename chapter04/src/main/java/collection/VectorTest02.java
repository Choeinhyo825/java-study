package collection;

import java.util.Vector;
import java.util.Iterator;
import java.util.List;

public class VectorTest02 {
	public static void main(String[] args) {
		List<String> list = new Vector<>();

		list.add("둘리");
		list.add("마이콜");
		list.add("도우넛");

		// 순회 1
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		list.remove(1);

		// 순회 2

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();

			System.out.println("--" + s);
		}
		
		// 순회 3	
		for(String s : list) {
			System.out.println(s);
		}
	}
}
