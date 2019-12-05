/**
 * Strategy runner that utilizes two different payment methods.
 * Lab Assignment: Strategy
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/04/19
 */
package StrategyPattern;

public class StrategyRunner {
    public static void main(String[] args) {
        //credit card
        PaymentStrategy myCard = new CreditCardStrategy("Michael", "696936360420", "420", "04/20");
        ShoppingCart myCart = new ShoppingCart();
        myCart.addItem(new Item("69", 2.09));
        myCart.addItem(new Item("70", 1.59));
        myCart.addItem(new Item("14", 3.00));
        //pays for all items in carts
        myCart.pay(myCard);
    } //ends main
} //ends StrategyRunner
