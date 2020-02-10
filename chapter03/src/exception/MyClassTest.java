package exception;

import java.io.IOException;

public class MyClassTest {
	public static void main(String[] args) {
		MyClass m = new MyClass();
		try {
			m.danger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
