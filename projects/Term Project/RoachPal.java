package cecs277termproject;

public class RoachPal implements PaymentStrategy {
    /** The name */
    private String name;
    /** The email of the buyer */
    private String emailID;

    /**
     * Creates a PayPal account.
     * @param name The buyer's colony name
     * @param emailID The buyer's email.
     */
    public RoachPal(String name, String emailID) {
        this.name = name;
        this.emailID = emailID;
    }
    /**
     * Returns amount paid with buyer's info.
     * @param amount The amount paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println(this.name + " has paid $" + amount + " with RoachPal" );
    }
}
