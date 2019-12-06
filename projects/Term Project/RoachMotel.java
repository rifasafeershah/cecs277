package TermProject;

import java.util.ArrayList;

public class RoachMotel implements Subject {
    private ArrayList<Observer> observers;
    private String motelName;
    private int capacity;

    public RoachMotel(String name, int capacity) {
        this.motelName = name;
        this.capacity = capacity;
        //FIXME make an arraylist for rooms?
    }
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

    @Override
    public void notifyObservers() {
        for (Observer next: this.observers) {
            next.update();
        }
    }
}
