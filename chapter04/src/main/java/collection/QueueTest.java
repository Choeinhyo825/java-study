package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();

		q.offer("둘리");
		q.offer("마이콜");
		q.offer("또치");

		while (!q.isEmpty()) {
			System.out.println("poll : " + q.poll());
		}

		// 비어있는경우 null을 리턴
		System.out.println(q.poll());

		q.offer("둘리");
		q.offer("마이콜");
		q.offer("또치");

		System.out.println("poll : " + q.poll());
		System.out.println("peek : " + q.peek());
		System.out.println("poll : " + q.poll());

	}
}
