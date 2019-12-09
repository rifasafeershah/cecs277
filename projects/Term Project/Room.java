/**
 * Room abstract class that describes a motel room.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public abstract class Room {
    /** The room number. */
    private String roomNumber;
    /** Status of room privacy. */
    private boolean doNotDisturb;
    /** Status of room having a spray resistant shower. */
    private boolean hasShower;

    /**
     * Creates an empty room.
     */
    public Room() {
        this.roomNumber = "";
        this.doNotDisturb = false;
        this.hasShower = false;
    }

    /**
     * Creates a motel room.
     * @param roomNumber The room number.
     */
    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.doNotDisturb = false;
        this.hasShower = false;
    }

    /**
     * Gets the room number.
     * @return The room number.
     */
    public String getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Gets the room type.
     * @return The room type.
     */
    public abstract RoomType getRoomType();

    /**
     * Sets the status of the room privacy.
     * @param doNotDisturb Boolean value.
     */
    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    /**
     * Gets the status of the room privacy.
     * @return Boolean value.
     */
    public boolean getDoNotDisturb() {
        return this.doNotDisturb;
    }

    /**
     * Prints the room information.
     * @return String format of the room information.
     */
    public abstract String toString();

    /**
     * Calculates the cost of the room with/without amenities.
     * @return Total cost of the room.
     */
    public abstract double cost();

    /**
     * Sets the status of the room having a spray resistant shower.
     * @param value Boolean value.
     */
    public void setHasShower(boolean value) {
        this.hasShower = value;
    }

    /**
     * Gets the status of the room having a spray resistant shower.
     * @return Boolean value.
     */
    public boolean getHasShower() {
        return this.hasShower;
    }

    public abstract String accept(CleaningRoomVisitor visitor);
}
