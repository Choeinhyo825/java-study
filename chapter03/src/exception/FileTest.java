package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("./hello1.txt");
			int data = is.read();
			System.out.println((char) data);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				if (is != null) {
					// 자원 정리
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
