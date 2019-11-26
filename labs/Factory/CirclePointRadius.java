public class CirclePointRadius extends CircleAbstractClass {
	Point center;
	private double radius;
	
	public CirclePointRadius(Point [] points) {
		this.center = points[0].between(points[1]);
		this.radius = points[0].distance(points[1]) / 2;
	}
}
