/**
 * Observer interface that allows observers to update all stock trades from their subjects.
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12//02/19
 */
package cecs277observerHW;

public interface Observer {
    /**
     * The method that the subject calls on each observer/subscriber to
     * @param	stock The stock.
     */
    public void update (Subject stock);
}
