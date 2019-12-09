/**
 * Subject interface that allows observers to subscribe to any subject.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

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
