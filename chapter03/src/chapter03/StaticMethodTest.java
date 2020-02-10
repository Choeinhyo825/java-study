package chapter03;

public class StaticMethodTest {

	public static void main(String[] args) {
		int a = Math.abs(-1); // abs메소드는 static 메소드라는것을 알 수 있음.
		
		int b = Math.max(10, 20);
		
		System.out.println(a+" : "+ b);
	}

}
