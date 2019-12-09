/**
 * Room decorator class that decorates a motel room with amenities.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public abstract class RoomDecorator extends Room {
    /** The motel room*/
    private Room decoratedRoom;

    /**
     * Creates a decorated room.
     * @param decoratedRoom The decorated motel room.
     */
    public RoomDecorator (Room decoratedRoom) {
        this.decoratedRoom = decoratedRoom;
    }

    /**
     * Gets the decorated room.
     * @return The decorated motel room.
     */
    public Room getDecoratedRoom() {
        return this.decoratedRoom;
    }

    /**
     * Throws an error if nothing is in the decorator.
     */
    public RoomDecorator () {
        throw new IllegalArgumentException ("Must supply something to decorate!");
    }
}
