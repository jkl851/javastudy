package prob6;

public class RectTriangle extends Shape {
	public double width = 0;
	public double height = 0;
	
	public RectTriangle(double a, double b) {
		width = a;
		height = b;
	}
	
	@Override
	public double getArea() {
		double rectTriArea = width * height * 0.5;
		return rectTriArea;
	}
	
	@Override
	public double getPerimeter() {
		double rectTriPerimeter = width + height + Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		return rectTriPerimeter;
	}
	
	
}
