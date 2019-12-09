package cecs277termproject;

public class Suite extends Room {
    private boolean doNotDisturb;

    public Suite() {
        super(roomNumber);
    }

    public void setDoNotDistributed(boolean doNotDisturb) {
        super.setDoNotDisturb(doNotDisturb);
    }

    @Override
    public String toString() {
        return "Suite";
    }

    @Override
    public double cost() {
        return 100;
    }
}
