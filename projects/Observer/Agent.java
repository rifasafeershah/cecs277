/**
 * Agent class that allows stocks to be traded between one another
 * Homework Assignment: Observer
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 12/02/19
 */
package cecs277observerHW;


public class Agent implements Observer {
    /** The name of the agent. */
    private String mAgentName;
    /** the WeatherData instance that got us started as a subscriber */
    private Subject mSubject;

    /**
     * Creates an agent.
     * @param name The agent's name.
     * @param stock The stock they will subscribe to.
     */
    public Agent(String name, Subject stock) {
        this.mAgentName = name;
        this.mSubject = stock;
        stock.registerObserver(this);
    }

    /**
     * Updates the agent about a stock trade.
     * @param	stock The stock.
     */
    @Override
    public void update(Subject stock) {
        Stock updatedStock = (Stock) stock;
        System.out.println("Agent - name: " + mAgentName + " alerted to Bid: " + ((Stock) stock).getBid());
    }
}
