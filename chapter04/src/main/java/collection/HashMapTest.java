package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		String ks1 = "one";

		map.put("one", 1);// auto boxing
		map.put("two", 2);
		map.put("three", 3);

		int i = map.get(ks1); // auto unBoxing
		int j = map.get(new String("one"));

		System.out.println(i);
		System.out.println(j);

		map.put("three", 3333); // 같은 키값으로 다시 입력되면 override
		System.out.println(map.get("three"));

		// 순회
		Set<String> s = map.keySet();
		for (String key : s) {
			int value = map.get(key);
			System.out.println("key : " + key + " : " + "value : " + value);
		}
		
		
		
	}
}
