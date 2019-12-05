/**
 * PayPal payment class.
 * Lab Assignment: Strategy
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/04/19
 */
package StrategyPattern;

public class PayPalStrategy implements PaymentStrategy {
    /** The email of the buyer */
    private String emailID;
    /** The password */
    private String password;

    /**
     * Creates a PayPal account.
     * @param emailID The buyer's email.
     * @param password The password.
     */
    public PayPalStrategy(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }
    /**
     * Returns amount paid with buyer's info.
     * @param amount The amount paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println("You have paid $" + amount + " with your PayPal with Email ID: " + this.emailID);
    }
}
