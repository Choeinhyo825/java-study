package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedReaderTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BufferedReader br = null;
		try {
			// 보조스트림(기반스트림) ()안쪽일수록 기반이고 그걸 타고 보조스트림으로 사용
			br = new BufferedReader(new FileReader("./src/io/BufferedReaderTest.java"));

			int index = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				index++;
				System.out.println(index + " : " + line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다 - " + e);
		} catch (IOException e) {
			System.out.println("에러 - " + e);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("에러 - " + e);
			}
		}

	}
}
