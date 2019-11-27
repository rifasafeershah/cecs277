/**
 * Circle class that operates based on two points of the circle.
 * Lab Assignment: Factory
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 11//25/19
 */

public class Circle2Points extends CircleAbstractClass {
    /** Points of the circle. */
    Point [] points;

    /**
     * Creates a circle based on two points.
     * @param points Points of the circle.
     */
    public Circle2Points(Point [] points) {
        this.points = Point.clone(points);
    }

    /**
     * Returns a copy of the points.
     * @return The points.
     */
    @Override
    public Point[] getPoints() {
        return Point.clone(this.points);
    }
    /**
     * Gets the radius of the circle.
     * @return The radius.
     */
    @Override
    public double getRadius() {
        return points[0].distance(points[1]) / 2;
    }
}
