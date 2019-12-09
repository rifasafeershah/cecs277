/**
 * Food bar that decorates a room as an amenity.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class FoodBar extends RoomDecorator {
    /**
     * Creates a Food Bar.
     * @param room The room.
     */
    public FoodBar(Room room) {
        super(room);
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
     * @return The room type.
     */
    public RoomType getRoomType() {
        return super.getDecoratedRoom().getRoomType();
    }
    /**
     * Prints the room description.
     * @return The room description.
     */
    @Override
    public String toString() {
        return super.getDecoratedRoom() + ", Food bar";
    }
    /**
     * Calculates the cost of the room with the spa amenity included.
     * @return the total cost.
     */
    @Override
    public double cost() {
        return 5.00 + super.getDecoratedRoom().cost();
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
