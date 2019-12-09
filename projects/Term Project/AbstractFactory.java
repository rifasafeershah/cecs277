/**
 * AbstractFactory class gets a specific room in the motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public abstract class AbstractFactory {
    /**
     * Produces a room specified in the parameters.
     * @param roomType The type of room.
     * @param roomNumber The motel room number.
     * @return The class with the room type specified.
     */
    public abstract Room getRoom (RoomType roomType, String roomNumber);
} // End of the AbstractFactory class
