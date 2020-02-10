package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileICopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			// 빨대를 꼽음
			is = new FileInputStream("1.png"); // 경로가 들어감
			os = new FileOutputStream("1_copy.png");

			int data = -1;

			while ((data = is.read()) != -1) { // is를 읽는데 아무것도 없으면 -1을 리턴하기떄문에 -1이 되면 종료해야함
				os.write(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			System.out.println("에러 - " + e);
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				System.out.println("에러 - " + e);
			}
		}
	}
}
