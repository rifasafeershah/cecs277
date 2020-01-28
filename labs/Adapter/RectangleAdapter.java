package cecs277labAdapter;

public class RectangleAdapter implements OldRectangle{ 
	private NewRectangle rect;
	public RectangleAdapter(Point first, Point second, Point third, Point fourth)
	{
		this.rect = new NewRectangle(first, first.getY() - third.getY(), second.getX() - first.getX());
	}

	@Override
	public  double getArea()
	{
		return this.rect.getArea();
	}

	@Override
	public double getperimeter() {
		return this.rect.getPerimeter();
	}

	@Override
	public double getDiagonal() {
		return Math.sqrt(Math.pow(this.rect.getLength(), 2) + Math.pow(this.rect.getWidth(), 2));
	}

	@Override
	public Point[] getCorners() {
		Point upperLeft = this.rect.getUpperLeft();
		Point upperRight = new Point(upperLeft.getX() + this.rect.getLength(), upperLeft.getY());
		Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() - this.rect.getWidth());
		Point lowerRight = new Point(upperRight.getX(), upperRight.getY() - this.rect.getWidth());
		Point[] points = new Point[4];
		points[0] = upperLeft;
		points[1] = upperRight;
		points[2] = lowerLeft;
		points[3] = lowerRight;
		return points;
	}
	
}
