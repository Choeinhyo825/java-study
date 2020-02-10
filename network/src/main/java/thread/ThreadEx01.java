package thread;

public class ThreadEx01 {
	public static void main(String[] args) {

		Thread t = new DigitalThread();
		t.start();

		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
