/**
 * MasterRoachCard class that implements PaymentStrategy for the Strategy pattern.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class MasterRoachCard implements PaymentStrategy {
    /** The name of the card user */
    private String name;

    /**
     * Creates a new credit card.
     * @param name The name of the colony.
     */
    public MasterRoachCard(String name) {
        this.name = name;
    }
    /**
     * Returns amount paid with buyer's info.
     * @param amount The amount paid.
     */
    @Override
    public void pay(double amount, int nights) {
        String transaction = this.name + " has paid $" + amount + " for " + nights + " night(s) with a debit/credit card";
        TransactionLogger.getLogger().log(transaction);
        System.out.println(transaction);
    }
}
