/**
 * Stock class that utilizes Bid objects to trade.
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/02/19
 */
package cecs277observerHW;


import java.util.ArrayList;

public class Stock implements Subject {
    /** The bid for the stock */
    private Bid bid;
    /** Our list of current observers. */
    private ArrayList<Observer> observers;
    /** The stock type */
    private String mStockSymbol;

    /**
     * Creates a stock.
     * @param symbol The stock symbol.
     */
    public Stock(String symbol) {
        this.observers = new ArrayList<>();
        this.mStockSymbol = symbol;
    }

    /**
     * Gets the stock's symbol.
     * @return The symbol.
     */
    public String getSymbol() {
        return mStockSymbol;
    }

    /**
     * Creates the stock.
     * @param bidObject The bid for the stock.
     */
    public void trade(Bid bidObject) {
        this.bid = bidObject;
        notifyObservers();
    }

    /**
     * Returns a copy of the bid.
     * @return Copy of the bid.
     */
    public Bid getBid() {
        Bid copyBid = this.bid;
        return copyBid;
    }

    /**
     * Registers an observer to the list of observers.
     * @param observer	The new observer.
     * @return
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
     * Removes an observer to the list.
     * @param	observer	The existing observer to remove.
     * @return Boolean value if the observer was removed from the list.
     */
    @Override
    public boolean removeObserver (Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Notifies observers that changes have been made to the stock trades.
     */
    @Override
    public void notifyObservers() {
        for (Observer next: this.observers) {
            next.update(this);
        }
    }
}
