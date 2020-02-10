package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		for(int i=0 ; i< goods.length;i++) {
			goods[i] = new Goods();
			goods[i].setName(scanner.next());
			goods[i].setPrice(scanner.nextInt());
			goods[i].setCountStock(scanner.nextInt());
		}
		
		for(Goods g: goods) {
			System.out.println(g.getName()+"(가격 : "+g.getPrice()+"원)이 "+g.getCountStock()+"개 입고 되었습니다.");
		}

		scanner.close();
	}
}
