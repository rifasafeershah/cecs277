package cecs277termproject;

public class Spa extends RoomDecorator {

    public Spa(Room room) {
        super(room);
    }

    @Override
    public String toString() {
        return super.getDecoratedRoom() + ", Spa";
    }

    @Override
    public double cost() {
        return 20.00 + super.getDecoratedRoom().cost();
    }
}
