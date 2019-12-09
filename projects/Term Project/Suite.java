/**
 * Suite class visits that extends the room to be "luxurious".
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class Suite extends Room {
    /**
     * Creates a suite.
     * @param roomNumber The room number.
     */
    public Suite(String roomNumber) {
        super(roomNumber);
    }

    /**
     * Returns a room number.
     * @return The room number.
     */
    public String getRoomNumber() {
        return super.getRoomNumber();
    }

    /**
     * Gets the room type.
     * @return The room type.
     */
    public RoomType getRoomType() {
        return RoomType.SUITE;
    }

    /**
     * Sets the "Do Not Distur" sign.
     * @param doNotDisturb Boolean value.
     */
    public void setDoNotDisturb(boolean doNotDisturb) {
        super.setDoNotDisturb(doNotDisturb);
    }

    /**
     * Prints information about the room.
     * @return
     */
    @Override
    public String toString() {
        return super.getRoomNumber() + ": Suite";
    }

    /**
     * Calculates the total of the motel room.
     * @return The total cost.
     */
    @Override
    public double cost() {
        return 100;
    }

    /**
     * Sets the status of the room having a spray resistant shower.
     * @param value Boolean value.
     */
    public void setHasShower(boolean value) {
        super.setHasShower(value);
    }

    /**
     * Accepts the maid(visitor) and cleans the room.
     * @param visitor The maid visiting the room.
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
