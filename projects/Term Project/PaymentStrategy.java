/**
 * Payment strategy interface that allows customers to pay in different ways.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public interface PaymentStrategy {
    /** Returns the amount paid*/
    void pay(double amount, int nights);
}
