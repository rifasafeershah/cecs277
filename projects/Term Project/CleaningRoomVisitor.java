/**
 * TransactionLogger class records all the transactions for the motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
public interface CleaningRoomVisitor {
  String visit(BasicRoom room);
  String visit(DeluxeRoom room);
  String visit(Suite room);
}
