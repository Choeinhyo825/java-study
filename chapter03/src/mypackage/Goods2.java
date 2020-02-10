package mypackage;

public class Goods2 {

	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods2() {
		super();
	}
	
	public Goods2(String name, int price, int countStock, int countSold) {
		super();
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCountStock() {
		return countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		if (price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println("name : " + name + " / price : " + price + " / countStock : " + countStock
				+ " / countSold : " + countSold);
	}

	public int calcDiscountPrice(double discountRate) {
		return (int) (price - price * discountRate);
	}

}
