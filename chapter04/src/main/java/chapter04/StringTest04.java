package chapter04;

public class StringTest04 {
	public static void main(String[] args) {
		String s = "aBcABCabcABc";

		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc")); // abc가 몇번째에 있나?
		System.out.println(s.indexOf("abc", 3)); // 3번 이후부터 abc검색
		System.out.println(s.indexOf("abc", 7)); // 없으면 -1리턴
		System.out.println(s.substring(3));// 3번index 이후부터 출력
		System.out.println(s.substring(3, 5)); // 3번부터 5번 전까지

		String s2 = "           ab   cd            ";
		String s3 = "dfg,hijk,lmno,pq";
		String s4 = s2.concat(s3);

		System.out.println(s4);
		System.out.println("----" + s2.trim() + "----");
		System.out.println("----" + s2.replace(" ", "") + "----");

		String[] tokens = s3.split(",");
		for (String str : tokens) {
			System.out.println(str);
		}

//		String str = "Hello" + "World" + "Java" + 1000;
		StringBuffer str = new StringBuffer("Hello").append("World").append("Java").append(1000);
		System.out.println(str);

		// 주의 : + 문자연산은 new를 사용하기때문에 너무 많이 반복하면 성능에 좋지 않음
		String str2 = "";
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 10000; i++) {
//			str2 += i;
			sb.append("c");
		}

		// format
		String name = "둘리";
		int score = 100;

		System.out.println(name + "님의 점수는 " + score + "점 입니다.");
		String str3 = String.format("%s님의 점수는 %d점 입니다.", name, score);
		System.out.println(str3);
	}

}
