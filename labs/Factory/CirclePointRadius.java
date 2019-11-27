/**
 * Circle class that operates based on the center point and the radius.
 * Lab Assignment: Factory
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 11//25/19
 */

public class CirclePointRadius extends CircleAbstractClass {
    /** The center point of the circle. */
    Point center;
    /** The radius of a circle */
    private double radius;

    /**
     * Creates a circle based on two points.
     * @param points Points of the circle.
     */
    public CirclePointRadius(Point [] points) {
        this.center = points[0].between(points[1]);
        this.radius = points[0].distance(points[1]) / 2;
    }
    /**
     * Gets the points of the circle.
     * @return The points.
     */
    @Override
    public Point[] getPoints() {
        Point[] circlePoints = new Point[2];
        circlePoints[0] = new Point(this.center.getX(), this.center.getY() - this.radius);
        circlePoints[1] = new Point(this.center.getX(), this.center.getY() + this.radius);;
        return circlePoints;
    }
    /**
     * Gets the radius of the circle.
     * @return The radius.
     */
    @Override
    public double getRadius() {
        return this.radius;
    }
}
