package chapter03;

public class Student extends Person {

	public Student() {
		// 자식생성자에서 부모 생성자를 명시적으로 호출하지 않아도 자동으로 부모의 기본생성자를 호출하게된다.
		// super();
		System.out.println("Student() 기본 생성자 호출");
	}

}
