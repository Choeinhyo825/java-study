package chapter03;

import mypackage.Goods;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();

		// public은 접근제한이 없음
		goods.name = "nikon";

		// protected는 같은 패키지와 상속에서만 가능하기에 에러
		// goods.price = 400000;

		// default는 같은 패키지만 가능 에러
		// goods.countStock = 30;

		// private는 같은 클래스에서만 가능 에러
		// goods.countSold = 50; 
		
		System.out.println(goods);

		Goods goods1 = new Goods();
		Goods goods2 = new Goods();

		System.out.println(goods);

	}
}
