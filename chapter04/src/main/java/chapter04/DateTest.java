package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		printDate(now);
		printDate2(now);
	}

	public static void printDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String date = sdf.format(d);

		System.out.println(date);
	}

	public static void printDate2(Date d) {
		// 년도(+1900)
		int year = d.getYear();

		// 월(0~11 +1)
		int month = d.getMonth();

		int date = d.getDate();

		// 시
		int hours = d.getHours();

		// 분
		int minutes = d.getMinutes();

		// 초
		int seconds = d.getSeconds();

		System.out.println((year + 1900) + "년 " + (month + 1) + "월 " + date + "일 " + hours + "시 " + minutes + "분 "
				+ seconds + "초");

	}
}
