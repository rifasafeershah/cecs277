/**
 * RefillBar class 
 * Homewrok Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class RefillBar extends RoomDecorator {

    public RefillBar(Room room) {
        super(room);
    }
    
    public String getRoomNumber() {
    	return super.getDecoratedRoom().getRoomNumber();
    }
    
    public RoomType getRoomType() {
    	return super.getDecoratedRoom().getRoomType();
    }
    
    @Override
    public String toString() {
        return super.getDecoratedRoom() + ", Refill Bar";
    }

    @Override
    public double cost() {
        return 5.00 + super.getDecoratedRoom().cost();
    }
} //End of the RefillBar class
