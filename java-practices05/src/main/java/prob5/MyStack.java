package prob5;

public class MyStack<T> {
	private int top;
	private T[] buffer;
	private int size;

	public MyStack(int size) {
		buffer = (T[])new Object[size];
		this.size = size;
		this.top = -1;
	}

	public void push(T t) {

		if (buffer.length - 1 == top) { // stack full
			resize();
		}
		buffer[++top] = t;
	}

	public void resize() {
		T[] bufferTemp = (T[])new Object[buffer.length * 2];
		for (int i = 0; i < buffer.length; i++) {
			bufferTemp[i] = buffer[i];
		}
		buffer = bufferTemp;
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}
		T str = buffer[top];
		top--;
		return str;
	}

	public boolean isEmpty() {
		if (top < 0) {
			return true;
		} else {
			return false;
		}

	}

}