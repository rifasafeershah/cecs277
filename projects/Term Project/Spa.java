/**
 * Observer class represents an observer watching over a subject.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package TermProject;

public class Spa extends RoomDecorator {

    public Spa(Room room) {
        super(room);
    }

    public String getRoomNumber() {
        return super.getDecoratedRoom().getRoomNumber();
    }

    public RoomType getRoomType() {
        return super.getDecoratedRoom().getRoomType();
    }

    @Override
    public String toString() {
        return super.getDecoratedRoom() + ", Spa";
    }

    @Override
    public double cost() {
        return 20.00 + super.getDecoratedRoom().cost();
    }
} // End of the Spa class
