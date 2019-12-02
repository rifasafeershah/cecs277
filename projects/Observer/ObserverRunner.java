/**
 * Main program that runs the trade stock operation.
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/02/19
 */
package cecs277observerHW;

public class ObserverRunner {
    public static void main(String[] args) {
        //Creating the stocks
        Stock orcl = new Stock("ORCL");
        Stock ba = new Stock("BA");
        Stock trxx = new Stock("TRXX");
        //Creating the bids
        Bid twenty = new Bid(orcl, 20, 4500, TransactionType.BUY);
        Bid ten = new Bid(ba, 10, 3500, TransactionType.SELL);
        Bid fifty = new Bid(trxx, 50, 5000, TransactionType.BUY);
        //Creating the agents
        Agent date = new Agent("Date", orcl);
        Agent rifa = new Agent("Rifa", ba);
        Agent richie = new Agent("Richie", trxx);
        //Trading stocks
        orcl.trade(twenty); //oracle.addobserve(rifa);
        ba.trade(fifty);
        trxx.trade(ten);
        orcl.trade(ten);
        ba.trade(twenty);
        trxx.trade(fifty);
    }
}
