/**
 * 
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */

package cecs277termproject;

//---------------------------------------------------------------------------------------------------------------------------
//FactoryProvider.java
/**
* Observer class represents an observer watching over a subject.
* Homework Assignment: Term Project
* @author Michael Zaragoza and Rifa Safeer Shah
* 12/09/2019
*/

public class FactoryProvider {
public static Room getRoom (RoomType roomType, String roomNumber) {
    Room results;
    switch (roomType) {
        case BASIC:
            results = new BasicRoom(roomNumber);
            break;
        case DELUXE:
            results = new DeluxeRoom(roomNumber);
            break;
        case SUITE:
            results = new Suite(roomNumber);
            break;
        default:
            results = null;
    }
    return results;
} // End of the getRoom method
} // End of the FactoryProvider class
