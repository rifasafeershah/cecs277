package cecs277termproject;

import java.util.ArrayList;
public class RoachMotel implements Subject {
    private ArrayList<Observer> observers;
    private String motelName;
    private int capacity;
    private ArrayList<Observer> waitList;
    public RoachMotel(String name, int capacity) {
        this.motelName = name;
        this.capacity = capacity;
        waitList = new ArrayList<>();
        //FIXME make an arraylist for rooms?
    }
    /**
     * 
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
     * 
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
     * 
     */
    @Override
    public void notifyObservers() {
        for (Observer next: this.observers) {
            next.update();
        }
    }
    public String getMotelName() {
        return this.motelName;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public boolean getNoVacancy() {
        return this.noVacancy;
    }
    public void setNoVacancy(boolean noVacancy) {
        this.noVacancy = noVacancy;
    }

    public ArrayList<Room> getMotelRooms() {
        return this.motelRooms;
    }
    public void removeMotelRoom(Room room) {
        try {
            this.motelRooms.remove(room);
        }
        catch (NullPointerException ex) {
            System.out.println("Cannot remove more motel rooms. All are occupied at this time.");
        }
    }

    public void addMotelRoom(Room room) {
        if (this.motelRooms.size() < capacity) {
            this.motelRooms.add(room);
        }
        else {
            throw new IllegalArgumentException(this.motelRooms.size() + " Cannot add more motel rooms. At max capacity.");
        }
    }
} // End of the RoachMotel class
