package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "Bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));

			System.out.println("=========전화번호부=========");

			// 기반스트림(byte)
			FileInputStream fis = new FileInputStream(file);
			// 보조스트림(byte > char) 인코딩은 기본으로 UTF-8 생략가능
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			// 보조스트림(라인단위 입력)
			br = new BufferedReader(isr);
			// br = new BufferedReader(new InputStreamReader(new FileInputStream(new
			// File("phone.txt")), "UTF-8"));

			String line;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");

				int index = 0;
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (index == 0) {
						System.out.print(token + ":");
					} else if (index == 1 || index == 2) {
						System.out.print(token + "-");
					} else {
						System.out.println(token);
					}
					index++;
				}

			}
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
