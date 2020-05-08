/**
 * The InheritanceRunner classruns the BetterRectangle class
 * Lab Assignment: Lab 2 Inheritance
 * @author Michael Zaragoza and Rifa Safeer Shah
 * @date 09 September 2019
 */

package cecs277LabInheritance;

import java.awt.Rectangle;

public class InheritanceRunner {
	public static void main(String [] args) {
		/*
		 * The module for this original class lacks the getArea() and getPerimeter() methods
			Rectangle rectangle = new Rectangle(1,2,3,4);
			rectangle.getArea();
			rectangle.getPerimeter();
		*/
		/*
		 * The first part refers to the original rectangle whereas the second part refers to BetterRectangle class
			Rectangle betterVar = new BetterRectangle(1,2,3,4);
			betterVar.getArea();
			betterVar.getPerimeter();
		*/
		//This works because both parts refer to BetterRectangle class
			BetterRectangle betterClass = new BetterRectangle(1,2,3,4);
			System.out.println(betterClass.getArea());
			System.out.println(betterClass.getPerimeter());


		 //The new class can't instantiate the original class
			BetterRectangle BR = new Rectangle(1,2,3,4);
			BR.getArea();
			BR.getPerimeter();
		}
	}
