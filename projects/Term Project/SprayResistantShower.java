/**
 * Spray resistant shower class that implements the RoomDecorator class as an amenity.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class SprayResistantShower extends RoomDecorator {
    /**
     * Creates a motel room with the spray resistant shower and sets the status of having the shower to true.
     * @param room The motel room.
     */
    public SprayResistantShower(Room room) {
        super(room);
        setHasShower(true);
    }

    /**
     * Gets the room number.
     * @return The room number.
     */
    public String getRoomNumber() {
        return super.getDecoratedRoom().getRoomNumber();
    }

    /**
     * Gets the room type.
     * @return the room type.
     */
    public RoomType getRoomType() {
        return super.getDecoratedRoom().getRoomType();
    }

    /**
     * Prints the room information.
     * @return The room information.
     */
    @Override
    public String toString() {
        return super.getDecoratedRoom() + ", Shower";
    }

    /**
     * Calculates the total cost of the room including the shower.
     * @return The total cost.
     */
    @Override
    public double cost() {
        return 25.00 + super.getDecoratedRoom().cost();
    }

    /**
     * Accepts the maid(visitor) and cleans the room.
     * @param visitor The maid visiting the room.
     * @return Status of the room.
     */
    @Override
    public String accept(CleaningRoomVisitor visitor) {
        return super.getDecoratedRoom().accept(visitor);
    }
}
