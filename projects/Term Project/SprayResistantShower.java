package cecs277termproject;

public class SprayResistantShower extends RoomDecorator {

    public SprayResistantShower(Room room) {
        super(room);
    }

    @Override
    public String toString() {
        return super.getDecoratedRoom() + ", Shower";
    }

    @Override
    public double cost() {
        return 25.00 + super.getDecoratedRoom().cost();
    }
}
