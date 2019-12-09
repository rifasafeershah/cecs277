/**
 * TransactionLogger class records all the transactions for the motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
public class CleaningRoomVisitorImpl implements CleaningRoomVisitor {
  private String completedTask;
  
  @Override
  public String visit(BasicRoom room) {
    //this is what i meant. repeat for other rooms below
    String roomNum = "Visiting room " + room.getRoomNumber();
    if (room.getDoNotDisturb()) {
      completedTask = "Did not clean room because of the "Do Not Disturb Sign"";
    }
    else {
      completedTask = "Cleaning room " + rooNum + "/nLinens Changed." + "\nFloor towels have been replaced.";
    }
    return completedTask;
  }
  
  @Override
  public String visit(DeluxeRoom room) {
    String roomNum = "Visiting room " + room.getRoomNumber();
    if (room.getDoNotDisturb()) {
      completedTask = "Did not clean room because of the "Do Not Disturb Sign"";
    }
    else {
      completedTask = "Cleaning room " + rooNum + "/nLinens Changed." + "\nAll towels have been replaced.";
    }
    return completedTask;
  }
  
  @Override
  public String visit(Suite room) {
    String roomNum = "Visiting room " + room.getRoomNumber();
    if (room.getDoNotDisturb()) {
      completedTask = "Did not clean room because of the "Do Not Disturb Sign"";
    }
    else {
      completedTask = "Cleaning room " + rooNum + "/nLinens Changed." + "\nAll towels have been replaced." + "\nHamburger on the pillow.";
    }
    return completedTask;
  }
} // End of the CleaningRoomVisitorImpl class
