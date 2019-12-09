package TermProject;

public class DeluxeRoom extends Room {
    private boolean doNotDistributed;

    public DeluxeRoom() {
        super();
    }

    public void setDoNotDistributed(boolean doNotDistributed) {
        super.setDoNotDistributed(doNotDistributed);
    }

    @Override
    public String toString() {
        return "Deluxe Room";
    }

    @Override
    public double cost() {
        return 90;
    }
} //End of the DeluxeRoom class
