/**
 * 
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public abstract class RoomDecorator extends Room {
    private Room decoratedRoom;

    public RoomDecorator (Room decoratedRoom) {
        this.decoratedRoom = decoratedRoom;
    }
    
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
