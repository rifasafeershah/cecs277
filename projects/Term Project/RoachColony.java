/**
 * RoachColony implements observer and tracks the growth rate of the colonies.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

public class RoachColony implements Observer {
    /** The colony name */
    private String colonyName;
    /** The colony population */
    private int population;
    /** The colony growth rate */
    private double growthRate;
    /** The room the colony is staying in */
    private Room motelRoom;

    /**
     * Creates a roach colony.
     * @param name the colony name.
     * @param population The colony population.
     * @param growthRate The colony growth rate.
     */
    public RoachColony(String name, int population, double growthRate) {
        this.colonyName = name;
        this.population = population;
        this.growthRate = growthRate;
    }
    /**
     * Gets colony name.
     * @return The name of the Colony.
     */
    public String getColonyName() {
        return this.colonyName;
    }
    /**
     * Gets colony population.
     * @return The popluation of the Colony.
     */
    public int getPopulation() {
        return this.population;
    }
    /**
     * Gets colony growth rate.
     * @return The growth rate of the Colony.
     */
    public double getGrowthRate() {
        return this.growthRate;
    }
    /**
     * Sets motel room
     */
    public void setMotelRoom(Room room) {
        this.motelRoom = room;
    }
    /**
     * Gets motel room.
     */
    public Room getMotelRoom() {
        return this.motelRoom;
    }
    /**
     * The population of roaches increases when a colony throws a party.
     * However, an exterminator responds to this party.
     */
    public void throwParty() {
        this.population *= this.growthRate;
        System.out.println(this.colonyName + " threw a fantastic party. Population increased to " + this.population);
        //exterminator responds to party
        if (this.motelRoom.getHasShower()) {
            this.population *= 0.75;
        }
        else {
            this.population *= 0.5;
        }
        System.out.println("However, management responded and now the population is " + this.population);
    }
    /**
     * The check in process for the motel room.
     */
    public void checkIn(RoachMotel motel, Room room) {
        if (motel.getNoVacancy()) {
            System.out.println("Currently, all rooms are occupied. We will waitlist your colony and update you for any available" +
                    "vacant rooms. Thank you for your patience.");
            motel.registerObserver(this);
        }
        else if (!motel.getMotelRooms().contains(room)) {
            System.out.println("Sorry, this room is currently occupied at the moment.");
        }
        else {
            System.out.println(this.colonyName + " has just checked into room " + room.getRoomNumber());
            setMotelRoom(room);
            motel.removeMotelRoom(room);
            motel.removeObserver(this);
            if (motel.getMotelRooms().size() == 0) {
                motel.setNoVacancy(true);
            }
            System.out.println("Available rooms after this check-in: " + motel.getMotelRooms());
        }
    }
    /**
     * The check out process for the motel room.
     */
    public void checkOut(RoachMotel motel, int numOfNights, Room room, PaymentStrategy paymentMethod) {
        if (this.motelRoom.getRoomNumber().equals(room.getRoomNumber())) {
            motel.addMotelRoom(room);
            pay(paymentMethod, numOfNights);
            setMotelRoom(null);
            motel.notifyObservers();
            if (motel.getNoVacancy()) {
                motel.setNoVacancy(false);
            }
        }
        else {
            System.out.println(this.getColonyName() + " was not checked into this room. Please try again.");
        }
    }

    /**
     * Sets a "Do Not Distur" sign for the room.
     * @param doNotDisturb Boolean value.
     */
    public void setPeace(boolean doNotDisturb) {
        this.motelRoom.setDoNotDisturb(doNotDisturb);
    }
    /**
     * Payment for the time of stay.
     */
    public void pay(PaymentStrategy paymentMethod, int numOfNights){
        double amount = this.motelRoom.cost() * numOfNights;
        paymentMethod.pay(amount, numOfNights);
    }

    /**
     * Updates the colony of any available rooms when waitlisted.
     */
    @Override
    public void update() {
        System.out.println(this.colonyName + " received a notification from the only motel in town.");
    }
}
