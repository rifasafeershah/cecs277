package cecs277labAdapter;

public class AdapterRunner {
	public static void main(String[] args) {
		Point first = new Point(1,5);
		Point second = new Point(4,5);
		Point third = new Point(1,3);
		Point fourth = new Point(4,3);
		OldRectangle rectangle = new RectangleAdapter(first, second, third, fourth);
		
		Point[] listOfPoints = rectangle.getCorners();
		for (Point p: listOfPoints) {
			System.out.println(p);
		}
		double area = rectangle.getArea();
		double perimeter = rectangle.getperimeter();
		double diagonal = rectangle.getDiagonal();
		System.out.println("Area: " + area + "\nPerimeter: " + perimeter + "\nDiagonal: " + diagonal);
	}
}
