package prob6;

public class Rectangle extends Shape implements Resizable {
	public double width = 0;
	public double height = 0;
	
	public Rectangle(double a, double b) {
		width = a;
		height = b;
	}
		
	@Override
	public double getArea() {
		double rectArea = width * height;
		return rectArea;
	}
	
	@Override
	public double getPerimeter() {
		double rectPerimeter = (width + height)*2;
		return rectPerimeter;
	}
	
	@Override
	public void resize(double s) {
		width = width * s;
		height = height * s;
	}
}
