/**
 * CleaningRoomVisitor class visits all the rooms in the motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public interface CleaningRoomVisitor {
    //Visiting the Basic room
    String visit(BasicRoom room);
    //Visiting the Deluxe room
    String visit(DeluxeRoom room);
    //visiting the Suite room
    String visit(Suite room);
} // End of the CleaningRoomVisitor class
