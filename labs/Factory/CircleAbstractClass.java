/**
 * Circle abstract class that lays out the methods for measuring a circle.
 * Lab Assignment: Factory
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 11//25/19
 */

public abstract class CircleAbstractClass extends GeometricShape {
    /**
     * Gets the area of the circle.
     * @return The area.
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    /**
     * Gets the perimeter of the circle.
     * @return The perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    /**
     * Gets the center of the circle.
     * @return The center point.
     */
    @Override
    public Point getLocation() {
        return this.getPoints()[0];
    }

    /**
     * Gets the points of the circle.
     * @return The points.
     */
    @Override
    public abstract Point[] getPoints();

    /**
     * Gets the radius of the circle.
     * @return The radius.
     */
    public abstract double getRadius();

    /**
     * Formats the measurements of a circle.
     * @return String format of characteristics of a circle.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Circle- Points: ");
        Point [] points = this.getPoints();
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i].toString() + " ");
        } //prints coordinates of each point
        sb.append("of radius: " + this.getRadius() + " Area: " + getArea() + " Perimeter: " + this.getPerimeter());
        return sb.toString();
    }
}
