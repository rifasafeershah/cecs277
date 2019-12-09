/**
 * RoachPal class that implements PaymentStrategy for the Strategy pattern.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class RoachPal implements PaymentStrategy {
    /** The name */
    private String name;
    /** The email of the buyer */
    private String emailID;

    /**
     * Creates a RoachPal account.
     * @param name The buyer's colony name
     * @param emailID The buyer's email.
     */
    public RoachPal(String name, String emailID) {
        this.name = name;
        this.emailID = emailID;
    }
    /**
     * Returns amount paid with buyer's info and logs it into a transaction file.
     * @param amount The amount paid.
     * @param nights The amount of nights/days spent at the motel.
     */
    @Override
    public void pay(double amount, int nights) {
        String transaction = this.name + " has paid $" + amount + " for " + nights + " night(s) with RoachPal using " + this.emailID;
        TransactionLogger.getLogger().log(transaction);
        System.out.println(transaction);
    }
}
