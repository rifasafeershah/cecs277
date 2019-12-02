/**
 * Subject interface that allows subjects to notify any observers that they are designated to.
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12//02/19
 */
package cecs277observerHW;

public interface Subject {
    /**
     * Add a new observer to our list of subscribers.
     * @param	observer	The new observer.
     * @return				True if the observer could be added, false otherwise.
     */
    public boolean registerObserver (Observer observer);

    /**
     * Remove an existing observer (unsubscribe them).
     * @param	observer	The existing observer to remove.
     * @return				True if we found them, false otherwise.
     */
    public boolean removeObserver (Observer observer);

    /**
     * Pass along the new values to all of the registered observers.
     */
    public void notifyObservers();
}
