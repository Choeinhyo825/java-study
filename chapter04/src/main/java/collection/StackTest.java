package collection;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();

		s.push("둘리");
		s.push("마이콜");
		s.push("또치");

		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}

		// 비어있는경우 StackException발생
		// s.pop();

		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		System.out.println("pop : " + s.pop());
		System.out.println("peek : " + s.peek());
		System.out.println("pop : " + s.pop());
		
	}
}
