/**
 * Bid class that describes the stock.
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/02/19
 */
package cecs277observerHW;

public class Bid {
    /** The stock type */
    private String mStockType;
    /** The number of shares for the stock */
    private int mNumofShares;
    /** The dollar amount for the stock */
    private double mDollarAmount;
    /** The transaction type fpr the stock */
    private TransactionType mType;

    /**
     * Creates the stock.
     * @param stockType Stock type.
     * @param numofShares Number of shares for the stock
     * @param dollarAmount Dollar amount for the stock
     * @param type Transaction type fpr the stock
     */
    public Bid(Stock stockType, int numofShares, double dollarAmount, TransactionType type) {
        this.mStockType = stockType.getSymbol();
        this.mNumofShares = numofShares;
        this.mDollarAmount = dollarAmount;
        this.mType = type;
    }

    /**
     * Returns a description of the stock.
     * @return The string format of the stock.
     */
    public String toString() {
        String typeFormat = this.mType.name().substring(0, 1) + this.mType.name().substring(1).toLowerCase() + "ing";
        return "Symbol: " + this.mStockType + " " + typeFormat + " " + mNumofShares + " shares for the amount: $" + this.mDollarAmount;
    }
}
