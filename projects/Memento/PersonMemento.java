/**
 * Class that stores an instance of a person into a saved state called a memento.
 * Homework Assignment: Memento
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 10/30/19
 */
package MementoHW;
import java.io.Serializable;

public class PersonMemento implements Serializable {
    /** The person instance saved to memento*/
    private Person personMem;
    /**
     * Overloaded constructor.
     * @param personMem The person memento.
     */
    public PersonMemento(Person personMem) {
        this.personMem = personMem;
    }

    /**
     * Gets the last name of the person.
     * @return The last name.
     */
    public String getlName () {
        return personMem.getlName();
    }

    /**
     * Gets the first name of the person.
     * @return The first name.
     */
    public String getfName () {
        return personMem.getfName();
    }

    /**
     * Retrieve the person's hair color.
     * @return	Their current hair color.
     */
    public Person.HairColor getHairColor () {
        return personMem.getHairColor();
    }


    /**
     * Give the height of the person in inches.
     * @return Height in inches.
     */
    public int getHeightInches () {
        return personMem.getHeightInches();
    }

    /**
     * Return the feet (floor) of the person.
     * @return The feet part of their height
     */
    public int getHeightFeet () {
        return personMem.getHeightFeet();
    }

    /**
     * Return the number of lbs the person weighs.
     * @return	The number of pounds that the person weighs.
     */
    public int getWeightPounds () {
        return personMem.getWeightPounds();
    }

    /**
     * Returns a memento of a person.
     * @return A memento of a person.
     */
    public Person getSavedPerson() {
        return personMem;
    }
}
