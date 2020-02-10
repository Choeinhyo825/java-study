package prob6;

public class Rectangle extends Shape implements Resizable {

	private double width;
	private double height;

	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getPerimeter() {
		return 0;
	}

	@Override
	public void resize(double s) {

	}

}
