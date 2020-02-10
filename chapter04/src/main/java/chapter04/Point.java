package chapter04;

public class Point {

	private int x;
	private int y;

//	public Point() {
//	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {
		System.out.println("점[x=" + x + ",y=" + y + "]을 그렸습니다.");
	}

	public void show(boolean visible) {
		if (visible == true) {
			show();
		} else {
			System.out.println("점[x=" + x + ",y=" + y + "]을 지웠습니다.");
		}
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

//	@Override
//	public void draw() {
//		show();
//	}

//	public void disappear() {
//	System.out.println("점[x=" + x + ",y=" + y + "]을 지웠습니다.");
//}
}
