package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("1someCode.");
		System.out.println("2someCode..");
		System.out.println("3someCode...");

		if (true) {
			throw new MyException();
		}
		if (true) {
			throw new IOException();
		}

		System.out.println("4someCode....");
		System.out.println("5someCode.....");

	}

}
