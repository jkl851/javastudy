package paint;

public class Main {
	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(10);		
		// point1.disapear();
		point1.show(false);
		// drawPoint(point1);
		draw(point1);
		
		Point point2 = new ColorPoint();
		point2.setX(100);
		point2.setY(200);
		((ColorPoint)point2).setColor("red");
		// drawPoint(point2);
		draw(point2);
		
		Triangle triangle = new Triangle();
		// drawTriangle(triangle);
		// drawShape(triangle);
		draw(triangle);
		
		Rectangle rect = new Rectangle();
		// drawRectangle(rect);
		// drawShape(rect);
		// draw(rect);
		
		Circle circle = new Circle();
		// drawCircle(circle);
		// drawShape(circle);
		draw(circle);
		
		GraphicText text = new GraphicText("Hello World");
		draw(text);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}

//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}

//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}
	
}
