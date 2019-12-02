/**
 * Stock class that utilizes Bid objects to trade.
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/02/19
 */
package cecs277observerHW;

import java.util.Observable;

public class Stock extends Observable {
    /** The bid for the stock */
    private Bid bid;

    /**
     * Creates the stock.
     * @param bidObject The bid for the stock.
     */
    public void trade(Bid bidObject) {
        this.bid = bidObject;
    }

    /**
     * Returns a copy of the bid.
     * @return Copy of the bid.
     */
    public Bid getBid() {
        Bid copyBid = this.bid;
        return copyBid;
    }
}
