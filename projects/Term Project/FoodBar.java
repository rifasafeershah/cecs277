/**
 * Observer class represents an observer watching over a subject.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package TermProject;

public class FoodBar extends RoomDecorator {

    public FoodBar(Room room) {
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
        return super.getDecoratedRoom() + ", Food bar";
    }

    @Override
    public double cost() {
        return 5.00 + super.getDecoratedRoom().cost();
    }
}
