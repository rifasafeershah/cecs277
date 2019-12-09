/**
 * FactoryProvider class adds new rooms of different types and sets it to a room number.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class FactoryProvider {
    /**
     * Produces a type of room.
     * @param roomType The typr of room requested.
     * @param roomNumber The room number.
     * @return The desired room.
     */
    public static Room getRoom (RoomType roomType, String roomNumber) {
        Room results;
        switch (roomType) {
            case BASIC:
                results = new BasicRoom(roomNumber);
                break;
            case DELUXE:
                results = new DeluxeRoom(roomNumber);
                break;
            case SUITE:
                results = new Suite(roomNumber);
                break;
            default:
                results = null;
        }
        return results;
    } // End of the getRoom method
} // End of the FactoryProvider class
