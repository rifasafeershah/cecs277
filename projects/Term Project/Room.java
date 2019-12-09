package cecs277termproject;

/**
 * Observer class represents an observer watching over a subject.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
public abstract class Room {
    private String roomNumber;
    private boolean doNotDisturb;
    private boolean hasShower;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.doNotDisturb = false;
        this.hasShower = false;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public boolean getDoNotDisturb() {
        return this.doNotDisturb;
    }
    public abstract String toString();

    public abstract double cost();

    public void setHasShower(boolean value) {
        this.hasShower = value;
    }
    public boolean getHasShower() {
        return this.hasShower;
    }
    
} // End of the Room class
