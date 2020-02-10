package exception;

public class MyException extends Exception {

	private static final int test = 0;

	public MyException() {
		super("MyException Occurs");
	}

	public MyException(String m) {
		super(m);
	}
}
