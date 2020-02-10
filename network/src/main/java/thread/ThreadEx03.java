package thread;

public class ThreadEx03 {
	public static void main(String[] args) {
		Thread t1 = new DigitalThread();
		Thread t2 = new AlphabetThread();
		Thread t3 = new Thread(new UppercaseAlphabetRunnableImpl());
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("-Main Thread 종료-");

	}
}
