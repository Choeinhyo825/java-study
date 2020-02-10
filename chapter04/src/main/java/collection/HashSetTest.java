package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();

		s.add("둘리");
		s.add("마이콜");
		s.add("또치");

		String s1 = new String("또치");
		System.out.println(s.contains(s1));
		// 객체가 아닌 내용으로 비교해서 찾음
		System.out.println(s.size());
		
		//순회 
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}
}
