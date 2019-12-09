package TermProject;

public class BasicRoom extends Room {
    private boolean doNotDistributed;

    public BasicRoom() {
        super();
    }

    public void setDoNotDistributed(boolean doNotDistributed) {
        super.setDoNotDistributed(doNotDistributed);
    }

    @Override
    public String toString() {
        return "Basic Room";
    }

    @Override
    public double cost() {
        return 80;
    }
} //End of the BasicRoom class
