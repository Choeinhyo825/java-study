package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest02 {
	public static void main(String[] args) {
		HashSet<Gugudan> s = new HashSet<Gugudan>();

		s.add(new Gugudan(2, 3));
		s.add(new Gugudan(9, 9));
		s.add(new Gugudan(3, 2));// 연산 값이 첫번째와 같아서 add 안됨
		s.add(new Gugudan(2, 3));// 첫번째와 같으니 add 안됨
		// hashCode와 equals 오버라이드로 수정해줘서 가능

		for (Gugudan g : s) {
			System.out.println(g);
		}

	}
}
