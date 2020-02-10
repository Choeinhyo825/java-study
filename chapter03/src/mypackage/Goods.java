package mypackage;

public class Goods {
	public static int countOfGoods;
	
	public Goods() {
		countOfGoods++;
	}
	
	public String name; // 모든곳에서 접근 가능
	protected int price; // 같은 패키지와 상속관계에서 접근 가능
	int countStock; // 같은 패키지만 가능
	private int countSold; // 같은 클래스만 가능
	
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", countStock=" + countStock + ", countSold=" + countSold
				+ ", countOfGoods="+countOfGoods+"]";
	}
	
	
}
