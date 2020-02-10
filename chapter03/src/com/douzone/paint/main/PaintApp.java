package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PaintApp {

	public static void main(String[] args) {

		Point p1 = new Point(2, 5);
//		drawPoint(p);
		draw(p1);

		Point p2 = new Point(10, 50);
		draw(p2);
		// drawPoint(p2);
//		p2.show(true);
//		p2.show(false);

//		Point point1 = new Point(2, 3);
		Point p3 = new ColorPoint(50, 100, "red");
		draw(p3);
//		drawPoint(point2);
		p3.show(false);
		p3.show(true);

//		public static void drawPoint(Point p) {
//		p.show();
//	}
//	public static void drawPoint(Point p) {
//		p.show();
//	}

		Rect rect = new Rect();
//		drawShape(rect);
		draw(rect);

		Triangle triangle = new Triangle();
//		drawShape(triangle);
		draw(triangle);

		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);

		draw(new GraphicText("Hello"));

		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류 : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
		// System.out.println(circle instanceof Rect);
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);

		// Interface는 hierachy와 상관없이 가능
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);

	}

	public static void draw(Drawable d) {
		d.draw();
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
