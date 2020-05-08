/**
 * BetterRectangle provides area and perimeter of a rectangle
 * Lab Assignment: Lab 2 Inheritance
 * @author Michael Zaragoza and Rifa Safeer Shah
 * @date 09 September 2019
 */
package cecs277LabInheritance;

import java.awt.Rectangle;

public class BetterRectangle extends Rectangle {

	/**
	 * BetterRectangle takes in 4 parameters to create a rectangle
	 * @param x - x coordinate for rectangle
	 * @param y - y coordinate for rectangle
	 * @param width - width of rectangle
	 * @param height - height of rectangle
	 */
	
	Rectangle rectangle; //creates a rectangle
	BetterRectangle (int x, int y, int width, int height) {
		super(x, y, width, height);
		rectangle = new Rectangle(x, y, width, height);
		
	}
	
	/**
	 * getArea() gets the area of a rectangle (height x width)
	 * @return area of the rectangle
	 */
	public int getArea() {
		return (height * width); //area = height x width
	}
	
	/**
	 * getPerimeter() gets the perimeter of a rectangle 2 * (w + h)
	 * @return perimeter of the rectangle
	 */
	public int getPerimeter() {
			return (2 * width) + (2 * height); //perimeter = 2 * (height + width)
		}
	
	/**
	 * Override the toString Method
	 */
	@Override
	public String toString() {
		return rectangle.toString();
	}
}
