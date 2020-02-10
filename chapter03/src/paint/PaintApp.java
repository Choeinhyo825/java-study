package paint;

public class PaintApp {

	public static void main(String[] args) {

//		Point p = new Point();

//		p.setX(2);
//		p.setY(5);
//		drawPoint(p);

//		Point p2 = new Point(10,50);
//		drawPoint(p2);
//		p2.show(true);
//		p2.show(false);

//		Point point1 = new Point(2, 3);
//		Point point2 = new ColorPoint(50, 100, "red");
//		drawPoint(point2);
//		point2.show(false);
//		point2.show(true);

//		public static void drawPoint(Point p) {
//		p.show();
//	}
//	public static void drawPoint(Point p) {
//		p.show();
//	}
		
		
		Rect rect = new Rect();
		drawShape(rect);

		Triangle triangle = new Triangle();
		drawShape(triangle);
		
		Circle circle = new Circle();
		drawShape(circle);
		
	}

//	public static void drawRect(Rect r) {
//		r.draw();
//	}
//
//	public static void drawTriangle(Triangle t) {
//		t.draw();
//	}
	
	public static void drawShape(Shape s) {
		s.draw();
	}

}
