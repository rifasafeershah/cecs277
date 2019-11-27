package cecs277FactoryLab;

/**
 * Main driver that utilizes both factories to calculate measurements of each geometric object.
 * Lab Assignment: Factory
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 11//25/19
 */

public class FactoryRunner {
    public static void main(String[] args) throws InvalidShapeException {
        //gets the factory that is based on the points and the dimensions of a geometric object
        AbstractFactory factory = FactoryProvider.getFactory(FactoryType.POINT_DIMENSIONS);
        Point[] circlePoints = {new Point(5, 0), new Point(5, -10)};
        Point[] rectanglePoints = {new Point(0, 0), new Point(5, 0), new Point(5, -10), new Point(0, -10)};
        Point[] linePoints = {new Point(-5, 0), new Point(0, 10)};
        System.out.println("Point Dimensions:");
        System.out.println(factory.getGeometricShape(ShapeType.RECTANGLE, rectanglePoints));
        System.out.println(factory.getGeometricShape(ShapeType.LINE_SEGMENT, linePoints));
        System.out.println(factory.getGeometricShape(ShapeType.CIRCLE, circlePoints));

        //gets the factory that is only based on the points of a geometric object
        factory = FactoryProvider.getFactory(FactoryType.POINTS);
        System.out.println("Points:");
        System.out.println(factory.getGeometricShape(ShapeType.RECTANGLE, rectanglePoints));
        System.out.println(factory.getGeometricShape(ShapeType.LINE_SEGMENT, linePoints));
        System.out.println(factory.getGeometricShape(ShapeType.CIRCLE, circlePoints));
    } //ends main
} //ends FactoryRunner
