package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		printDate(cal);

		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11);// month(12) -1
		cal.set(Calendar.DATE, 25);//
		printDate(cal);

		cal.set(2017, 03, 01);
		cal.add(Calendar.DATE, 2000); // set날짜로부터 2000일되는날
		printDate(cal);

	}

	public static void printDate(Calendar cal) {
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		int year = cal.get(Calendar.YEAR);
		// 년도

		int month = cal.get(Calendar.MONTH);
		// 월 (0~11) +1해야함

		int date = cal.get(Calendar.DATE);
		// 일

		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 요일 [1(일) ~ 7(토)]

		int hour = cal.get(Calendar.HOUR);
		// 시간

		int minutes = cal.get(Calendar.MINUTE);
		// 분

		int seconds = cal.get(Calendar.SECOND);
		// 초

		System.out.println(year + "년 " + (month + 1) + "월 " + date + "일 " + days[day - 1] + "요일 " + hour + "시 "
				+ minutes + "분 " + seconds + "초");
	}
}
