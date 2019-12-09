/**
 * BasicRoom class extends Room class and represents a basic room in the motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class BasicRoom extends Room {
    /**
     * Creates a basic room.
     * @param roomNumber The room number.
     */
    public BasicRoom(String roomNumber) {
        super(roomNumber);
    }
    /**
     * Returns a room number for the motel room.
     * @return The room number.
     */
    public String getRoomNumber() {
        return super.getRoomNumber();
    }

    /**
     * Gets the room type.
     * @return The room type.
     */
    @Override
    public RoomType getRoomType() {
        return RoomType.BASIC;
    }

    /**
     * Sets the "Do Not Disturb" sign.
     * @param doNotDisturb Boolean value.
     */
    public void setDoNotDisturb(boolean doNotDisturb) {
        super.setDoNotDisturb(doNotDisturb);
    }
    /**
     * Prints information about the room.
     * @return String value of the room type.
     */
    @Override
    public String toString() {
        return super.getRoomNumber() + ": Basic Room";
    }
    /**
     * Calculates the total cost of the motel room.
     * @return The total cost.
     */
    @Override
    public double cost() {
        return 80;
    }
    /**
     * Sets the status of the room having a spray resistant shower.
     * @param value Boolean value.
     */
    public void setHasShower(boolean value) {
        super.setHasShower(value);
    }
    /**
     * Accepts the maid (visitor) and cleans the room.
     * @param visitor The maid visiting the rood.
     * @return Status of the room.
     */
    public String accept(CleaningRoomVisitor visitor) {
        if (!super.getDoNotDisturb()) {
            System.out.println("Visiting room " + getRoomNumber());
            return visitor.visit(this);
        }
        else {
            return "Do not Clean";
        }
    }
}
