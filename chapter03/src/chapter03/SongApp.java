package chapter03;

//int globalVar = 100;

//void globalFunc() {
//	System.out.println("HelloWorld");
//}
//  이런방식의 전역변수는 자바에서 지원하지 않고 static키워드로 만들어야함

public class SongApp {
	public static void main(String[] args) {
		Song s = new Song();
		s.setTitle("좋은날");
		s.setArtist("아이유");
		s.setAlbum("Real");
		s.setComposer("이민수");
		s.setYear(2010);
		s.setTrack(3);

		s.show();

//		System.out.println(globalVar);
//		globalFunc();

		System.out.println(Global.globalVar);
		Global.globalFunc();

		// var에 static 키워드가 없어서 사용 불가능
		// System.out.println(Global.var);

		// 사용하려면 객체를 만들어야함
		System.out.println(new Global().var);

		Song s2 = new Song("날은좋", "유이아", null, null, 0, 0);
		s2.show();

		Song s3 = new Song("먹구름", "윤하");
		s3.show();
	}
}