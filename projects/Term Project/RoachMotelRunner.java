/**
 * Main program that drives multiple design patterns to operate the roach motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RoachMotelRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //creating and adding the rooms to the motel
        ArrayList<Room> rooms = new ArrayList<>();
        Room firstRoom = FactoryProvider.getRoom(RoomType.BASIC, "101");
        Room secondRoom = FactoryProvider.getRoom(RoomType.BASIC, "102");
        Room thirdRoom = FactoryProvider.getRoom(RoomType.DELUXE, "103");
        Room fourthRoom = FactoryProvider.getRoom(RoomType.DELUXE, "104");
        Room fifthRoom = FactoryProvider.getRoom(RoomType.SUITE, "105");
        rooms.add(firstRoom);
        rooms.add(secondRoom);
        rooms.add(thirdRoom);
        rooms.add(fourthRoom);
        rooms.add(fifthRoom);
        RoachMotel roachMotel = new RoachMotel("Roachy Inn", 5, rooms);
        System.out.println(roachMotel);

        //creating the first colony and having them stay at the first room with the food bar amenity
        RoachColony firstColony = new RoachColony("First Colony 1000", 1000, 1.25);
        PaymentStrategy firstColonyDebitCard = new MasterRoachCard(firstColony.getColonyName());
        firstColony.checkIn(roachMotel, firstRoom);
        firstColony.setMotelRoom(new FoodBar(firstRoom));
        System.out.println(firstColony.getColonyName() + " has room " + firstColony.getMotelRoom());
        //first colony throws a party
        firstColony.throwParty();

        //creating the second colony and having them stay at the second room with no amenities
        RoachColony secondColony = new RoachColony("Second Colony 2000", 2000, 1.45);
        PaymentStrategy secondColonyRoachPal = new RoachPal(secondColony.getColonyName(), secondColony.getColonyName().replaceAll("\\s", "") + "@roachmail.com");
        secondColony.checkIn(roachMotel, secondRoom);
        System.out.println(secondColony.getColonyName() + " has room " + secondColony.getMotelRoom());

        //creating the third colony and having them stay at the third room with the spray resistant shower and spa amenities
        RoachColony thirdColony = new RoachColony("Third Colony 3000", 3000, 1.35);
        PaymentStrategy thirdColonyDebitCard = new MasterRoachCard(thirdColony.getColonyName());
        thirdColony.checkIn(roachMotel, thirdRoom);
        thirdColony.setMotelRoom(new SprayResistantShower(new Spa(thirdRoom)));
        System.out.println(thirdColony.getColonyName() + " has room " + thirdColony.getMotelRoom());
        //third colony throws a party
        thirdColony.throwParty();

        //creating the fourth colony and having them stay at the fourth room with the refill bar and food bar amenities
        RoachColony fourthColony = new RoachColony("Fourth Colony 4000", 4000, 1.40);
        PaymentStrategy fourthColonyRoachPal = new RoachPal(fourthColony.getColonyName(), fourthColony.getColonyName().replaceAll("\\s", "") + "@roachmail.com");
        fourthColony.checkIn(roachMotel, fourthRoom);
        fourthColony.setMotelRoom(new RefillBar(new FoodBar(fourthRoom)));
        System.out.println(fourthColony.getColonyName() + " has room " + fourthColony.getMotelRoom());

        //creating the fifth colony and having them stay at the fifth room with all amenities
        RoachColony fifthColony = new RoachColony("Fifth Colony 5000", 5000, 1.50);
        PaymentStrategy fifthColonyDebitCard = new MasterRoachCard(fifthColony.getColonyName());
        fifthColony.checkIn(roachMotel, fifthRoom);
        fifthColony.setMotelRoom(new SprayResistantShower(new RefillBar(new Spa(new FoodBar(fifthRoom)))));
        System.out.println(fifthColony.getColonyName() + " has room " + fifthColony.getMotelRoom());
        //fifth colony throws a party
        fifthColony.throwParty();

        //creating the sixth colony and having them stay at the second room when the motel is now no vacant
        RoachColony sixthColony = new RoachColony("Sixth Colony 6000", 6000, 1.20);
        PaymentStrategy sixthColonyDebitCard = new MasterRoachCard(sixthColony.getColonyName());
        sixthColony.checkIn(roachMotel, secondRoom);

        //all colonies check out of their rooms and the sixth colony is notified of the first check-out
        firstColony.checkOut(roachMotel, 1, firstRoom, firstColonyDebitCard);
        //sixth colony immediately checks into the first room instead of the second room, which is still occupied
        sixthColony.checkIn(roachMotel, firstRoom);
        System.out.println(sixthColony.getColonyName() + " has room " + sixthColony.getMotelRoom());
        secondColony.checkOut(roachMotel, 1, secondRoom, secondColonyRoachPal);
        thirdColony.checkOut(roachMotel, 1, thirdRoom, thirdColonyDebitCard);
        fourthColony.checkOut(roachMotel, 1, fourthRoom, fourthColonyRoachPal);
        fifthColony.checkOut(roachMotel, 2, fifthRoom, fifthColonyDebitCard);
        sixthColony.checkOut(roachMotel, 1, firstRoom, sixthColonyDebitCard);

        //maid visits each room and cleans them according the procedures for each room type.
        CleaningRoomVisitorImpl maid = new CleaningRoomVisitorImpl();
        System.out.println("\nTime to clean all the motel rooms");
        for (Room r:rooms) {
            System.out.println(r.accept(maid));
        }
        //prints all transactions from the transactions file
        TransactionLogger.getLogger().printAllTransactions();
    }
}
