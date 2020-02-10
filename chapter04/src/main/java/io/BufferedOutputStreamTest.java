package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			// 기반스트림(소스에 연결)
			// fis = new FileOutputStream("test.txt");
			// 보조스트림(기반스트림 또는 보조스트림에 연결)
			// BufferedOutputStream bos = new BufferedOutputStream(fis);
			bos = new BufferedOutputStream(new FileOutputStream("test.txt"));

			// for(int i = 97 ; i <= 122; i++) {
			for (int i = 'a'; i <= 'z'; i++) {
				bos.write(i);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 열수 없습니다 - " + e);
		} catch (IOException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
