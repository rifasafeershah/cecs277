/**
 * CleaningRoomVisitorImpl class implements CleaningRoomVisitor class and records the cleaning task for each room.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class CleaningRoomVisitorImpl implements CleaningRoomVisitor {
    private String completedTask;
    /**
     * Records the cleaning task performed for Basic room.
     */
    @Override
    public String visit(BasicRoom room) {
        completedTask = "Linens Changed." + "\nFloor towels have been replaced.";
        return completedTask;
    }
    /**
     * Records the cleaning task performed for Deluxe room.
     */
    @Override
    public String visit(DeluxeRoom room) {
        completedTask = "Linens Changed." + "\nAll towels have been replaced.";
        return completedTask;
    }
    /**
     * Records the cleaning task performed for Suite room.
     */
    @Override
    public String visit(Suite room) {
        completedTask = "Linens Changed." + "\nAll towels have been replaced." + "\nHamburger on the pillow.";
        return completedTask;
    }
} // End of the CleaningRoomVisitorImpl class
