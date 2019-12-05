/**
 * Strategy interface that displays transactions with any payment strategy.
 * Lab Assignment: Strategy
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/04/19
 */
package StrategyPattern;

public interface PaymentStrategy {
    /** Returns the amount paid*/
    void pay(double amount);
}
