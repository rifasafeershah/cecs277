/**
 * Class that descries what a person is and what characteristics they take.
 * Homework Assignment: Memento
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 10/30/19
 */
package MementoHW;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    /** Height of the person in inches.  Note that we do not STORE the height in feet, that's calculated.*/
    private int heightInches;
    /** The weight of the person in pounds.  Ounces not significant. */
    private int weightPounds;
    /** Last Name of the person. */
    private String lName;
    /** First Name of the person.*/
    private String fName;
    /** The person's hair color */
    private HairColor hairColor;
    /** Ratio of inches to feet. */
    public static final int inchesPerFoot = 12;
    /** Maximum believable height in inches.*/
    private static final int maxHeight = 7 * inchesPerFoot;
    /** Minimum believable height in inches. */
    private static final int minHeight = 1 * inchesPerFoot;
    /** Maximum believable weight in pounds.*/
    public static final int maxWeight = 400;
    /** Minimum believable weight in pounds.*/
    private static final int minWeight = 20;

    public enum HairColor {
        BLACK, BLONDE, RED, AUBURN, SALT_AND_PEPPER, GREY, WHITE, BALD; //each is an instance of Color
        public static HairColor getColor (int colorNumber) {
            int currentColor = 0;
            boolean found = false;
            HairColor results = HairColor.BLACK;
            for (HairColor color : values() ) {
                if (currentColor == colorNumber) {
                    results = color;
                    found = true;
                    break;
                }
                currentColor++;
            }
            if (found) {
                return results;
            }
            else {
                throw new IllegalArgumentException ("Color number outside of range!");
            }
        }
    }
    /**
     * Overloaded constructor.
     * Build a new person.
     * @param lName				Last name.
     * @param fName 			First name.
     * @param color				Color of the person's hair.
     * @param heightInFeet		Height of the person in feet.
     * @param heightInInches	Inches portion of their height.
     * @param weightInPounds	Weight of the person, in pounds.
     */
    public Person (String lName, String fName, HairColor color, int heightInFeet, int heightInInches, int weightInPounds) {
        setHeight (heightInFeet, heightInInches);				//Update the height
        setWeight (weightInPounds);
        this.lName = lName;
        this.fName = fName;
        this.hairColor = color;
    }

    /**
     * Overloaded constructor with only the first and last name.
     * @param lName Last name.
     * @param fName First name.
     */
    public Person (String lName, String fName) {
        this.lName = lName;
        this.fName = fName;
        this.hairColor = HairColor.BALD;
    }

    /**
     * Gets the last name.
     * @return The last name.
     */
    public String getlName () {
        return this.lName;
    }

    /**
     * Gets the first name.
     * @return First name.
     */
    public String getfName () {
        return this.fName;
    }

    /**
     * Retrieve the person's hair color.
     * @return	Their current hair color.
     */
    public HairColor getHairColor () {
        return this.hairColor;
    }

    /**
     * Set the person's hair color.
     * @param newColor	Their new hair color.
     */
    public void setHairColor (HairColor newColor) {
        this.hairColor = newColor;
    }

    /**
     * Sets the height of a person in feet and inches format.
     * @param feet The height of a person in feet.
     * @param inches The remaining inches below 12.
     */
    public void setHeight (int feet, int inches) {
        int totalInches = netHeight (feet, inches);
        if (totalInches < minHeight || totalInches > maxHeight) {
            throw new IllegalArgumentException("Height out of bounds!");
        }
        else {
            this.heightInches = totalInches;
        }
    }

    /**
     * Sets the weight of a person.
     * @param pounds The weight of the person in pounds.
     */
    public void setWeight (int pounds) {
        if (pounds < minWeight || pounds > maxWeight) {
            throw new IllegalArgumentException ("Weight out of bounds!");
        }
        else {
            this.weightPounds = pounds;
        }
    }

    /**
     * Give the height of the person in inches.
     * @return Height in inches.
     */
    public int getHeightInches () {
        return this.heightInches;
    }

    /**
     * Return the feet (floor) of the person.
     * @return
     */
    public int getHeightFeet () {
        return this.getHeightInches()/inchesPerFoot;
    }

    /**
     * Return the number of lbs the person weighs.
     * @return	The number of pounds that the person weighs.
     */
    public int getWeightPounds () {
        return this.weightPounds;
    }

    /**
     * Calculate height from feet & inches.
     * @param feet	The feet in height.
     * @param inches	The inches above the last foot that need to be added to get height in inches.
     * @return	Total height in inches.
     */
    private static int netHeight (int feet, int inches) {
        return feet * inchesPerFoot + inches;
    }

    /**
     * Return string version of the Person.
     * @return	Display string of the person.
     */
    @Override
    public String toString () {
        return String.format("Name: %s, %s, Hair Color: %s, Height:%d'%d, Weight #: %d",
                this.lName, this.fName, "" + this.hairColor, this.getHeightFeet(),
                this.getHeightInches() % inchesPerFoot,
                this.weightPounds);//So we can print the Person.
    }

    /**
     * Saves a Person instance as a memento.
     * @return The memento of a person.
     */
    public PersonMemento save() {
        int heightRemaining = this.heightInches % this.inchesPerFoot;
        Person personToMem = new Person(this.lName, this.fName, this.hairColor, this.getHeightFeet(), heightRemaining, this.weightPounds);
        return new PersonMemento(personToMem);
    }

    /**
     * Restores a previous state of a memento.
     * @param memento The memento.
     * @return The person instance.
     */
    public Person restore(PersonMemento memento) {
        this.lName = memento.getlName();
        this.fName = memento.getfName();
        this.hairColor = memento.getHairColor();
        int heightFeet = memento.getHeightFeet();
        int heightInches = memento.getHeightInches() % this.inchesPerFoot;;
        this.weightPounds = memento.getWeightPounds();
        return new Person(this.lName, this.fName, this.hairColor, heightFeet, heightInches, this.weightPounds);
    }
}
