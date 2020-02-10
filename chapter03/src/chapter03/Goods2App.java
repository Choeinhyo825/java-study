package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 g = new Goods2();

		g.setName("nikon");
		g.setPrice(2000);
		g.setCountStock(50);
		g.setCountSold(100);

		g.showInfo();

		int price = g.calcDiscountPrice(0.5);
		System.out.println(price);

		Goods2 g2 = new Goods2("g2g2", 3000, 30, 100);
		g2.showInfo();
	}
}
