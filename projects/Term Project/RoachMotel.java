/**
 * Roach motel class that keeps track of customers and notifies any waitlisted ones of available rooms.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

import java.util.ArrayList;

public class RoachMotel implements Subject {
    /** List of observers */
    private ArrayList<Observer> observers = new ArrayList<>();
    /** List of rooms for the motel */
    private ArrayList<Room> motelRooms;
    /** The motel name */
    private String motelName;
    /** Max room capacity for the motel */
    private int capacity;
    /** Vacancy status for the motel */
    private boolean noVacancy;

    /**
     * Creates a roach motel.
     * @param name The motel name.
     * @param capacity The max room capacity for the motel.
     * @param motelRooms The list of rooms of the motel.
     */
    public RoachMotel(String name, int capacity, ArrayList<Room> motelRooms) {
        this.motelName = name;
        this.capacity = capacity;
        this.motelRooms = motelRooms;
        this.noVacancy = false;
    }

    /**
     * Registers a customer on the waitlist for available rooms.
     * @param	observer The new observer.
     * @return A boolean value.
     */
    @Override
    public boolean registerObserver(Observer observer) {
        if (observers.contains(observer)) {
            return false;
        }
        else {
            observers.add(observer);
            return true;
        }
    }

    /**
     * Removes a waitlisted customer after they check out a room.
     * @param	observer The existing observer to remove.
     * @return A boolean value.
     */
    @Override
    public boolean removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Notifies all customers on the waitlist any available rooms for the motel.
     */
    @Override
    public void notifyObservers() {
        for (Observer next: this.observers) {
            next.update();
        }
        System.out.println("Available rooms: " + this.motelRooms);

    }

    /**
     * Gets the motel name.
     * @return The motel name.
     */
    public String getMotelName() {
        return this.motelName;
    }

    /**
     * Gets the max capacity of rooms.
     * @return The max capacity.
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Gets the status of the vacancy of the motel.
     * @return Boolean value.
     */
    public boolean getNoVacancy() {
        return this.noVacancy;
    }

    /**
     * Prints the name of the motel with all available rooms.
     * @return String format of the description above.
     */
    public String toString() {
        return this.motelName + ": Available rooms: " + this.motelRooms;
    }

    /**
     * Sets the status of the vacancy of the motel.
     * @param noVacancy Boolean value.
     */
    public void setNoVacancy(boolean noVacancy) {
        this.noVacancy = noVacancy;
    }

    /**
     * Gets the list of the motel rooms.
     * @return The motel rooms.
     */
    public ArrayList<Room> getMotelRooms() {
        return this.motelRooms;
    }

    /**
     * Removes the motel room that is checked-in from the list.
     * @param room The motel room.
     * @throw NullPointerException if amount of rooms is zero.
     */
    public void removeMotelRoom(Room room) {
        try {
            this.motelRooms.remove(room);
        }
        catch (NullPointerException ex) {
            System.out.println("Cannot remove more motel rooms. All are occupied at this time.");
        }
    }

    /**
     * Adds the motel room that is being checked-out in the list.
     * @param room The motel room.
     * @throw IllegalArgumentException if amount of rooms hit the capacity.
     */
    public void addMotelRoom(Room room) {
        if (this.motelRooms.size() < capacity) {
            this.motelRooms.add(room);
        }
        else {
            throw new IllegalArgumentException(this.motelRooms.size() + " Cannot add more motel rooms. At max capacity.");
        }
    }
}
