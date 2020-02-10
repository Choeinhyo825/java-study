package chapter03;

public class StaticMethod {
	int n;
	static int m;

	void f1() {
		System.out.println(n);
	}

	void f2() {
		System.out.println(m); // 같은 클래스기 때문에 클래스명시를 생략할 수 있다.
		System.out.println(StaticMethod.m);
	}

	void f3() {
		f2();
	}

	void f4() {
		s1(); // f2와 같은 내용
		StaticMethod.s1();
	}

	static void s1() {
		// static 메소드에서는 인스턴스 변수에 접근 불가
		// System.out.println(n);
	}

	static void s2() {
		System.out.println(m); // f2메소드와 같은 내용
	}

	static void s3() {
		// static메소드에서는 인스턴스메소드에 접근이 불가능 하다.
		// f1(); 
	}
	
	static void s4() {
		s1();// f2와 같은 내용
		StaticMethod.s1();
	}
	
}
