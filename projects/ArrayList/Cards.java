/**
 * Stimulation of the card game, War
 * Homework Assignment: ArrayList w/ Cards
 @author Rifa Safeer Shah and Michael Zaragoza
 * 09/04/19
 */

package Labs;
import java.util.*;

/**
 * Program that stimulates the card game of "War"
 */
public class Cards {
    /**
     * Gives the value of a given card.
     * @param playersDeck The card deck for each player.
     * @return The value of the card.
     */
    private static String printValue(ArrayList<ArrayList<Integer>> playersDeck) {
        if (playersDeck.get(0).get(1).equals(14)) {
            return "Ace";
        }
        else if (playersDeck.get(0).get(1).equals(13)) {
            return "King";
        }
        else if (playersDeck.get(0).get(1).equals(12)) {
            return "Queen";
        }
        else if (playersDeck.get(0).get(1).equals(11)) {
            return "Jack";
        }
        else {
            return Integer.toString(playersDeck.get(0).get(1));
        }
    }

    /**
     * Prints statements for what the players place down.
     * @param playerNum The player number.
     * @param playersDeck The player's deck.
     */
    private static void printPlayStatement(int playerNum, ArrayList<ArrayList<Integer>> playersDeck) {
        if (playersDeck.get(0).get(0).equals(1)) {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of clubs." );
        }
        else if (playersDeck.get(0).get(0).equals(2)) {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of diamonds." );
        }
        else if (playersDeck.get(0).get(0).equals(3)) {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of spades." );
        }
        else {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of hearts." );
        }
    } //Types: 1 = clubs; 2 = diamonds; 3 = spades; 4 = hearts

    /**
     * Adds cards to the war pile for players to obtain after winning war.
     * @param playersDeck The player's deck needed to play war.
     * @param warDeck The deck containing war cards for the winning player.
     */
    private static void addingToWarPile(ArrayList<ArrayList<Integer>> playersDeck, ArrayList<ArrayList<Integer>> warDeck) {
        ArrayList<Integer> warCard = playersDeck.get(0);
        playersDeck.remove(warCard);
        warDeck.add(warCard);
    }

    /**
     * Adds cards to the winning player's deck when doing a regular battle.
     * @param winningDeck The winning player's deck.
     * @param losingDeck The losing player's deck.
     */
    private static void addingToWinningDeck(ArrayList<ArrayList<Integer>> winningDeck, ArrayList<ArrayList<Integer>> losingDeck) {
        ArrayList<Integer> lostCard = losingDeck.get(0);
        ArrayList<Integer> victoryCard = winningDeck.get(0);
        losingDeck.remove(lostCard);
        winningDeck.remove(victoryCard);
        winningDeck.add(victoryCard);
        winningDeck.add(lostCard);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> cards = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 14; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                cards.add(temp);
            }
        } //loop for generating a stack of cards with the types and values
        //first integer, i, is the type and the second integer, j, is the value

        //shuffles the cards and distributes evenly to both players
        ArrayList<ArrayList<Integer>>  player1hand = new ArrayList<>();
        ArrayList<ArrayList<Integer>> player2hand = new ArrayList<>();
        Collections.shuffle(cards);
        int playersCardCount = cards.size() / 2;

        for (int cardCount = 0; cardCount < playersCardCount; cardCount++) {
            player1hand.add(cards.get(0));
            cards.remove(0);
        } //loop for distributing 1st player's hand
        for (int cardCount1 = 0; cardCount1 < playersCardCount; cardCount1++) {
            player2hand.add(cards.get(0));
            cards.remove(0);
        } //loop for distributing 2nd player's hand

        //asks players for the number of plays
        System.out.println("How many plays will there be for this game?");
        Scanner scan = new Scanner(System.in);
        int userInput = scan.nextInt();
        String playersContinue = "y";
        int plays = 0;
        System.out.println("Let the war begin!\n");

        //checks for conditions for war and executes game
        while (plays < userInput && playersContinue.equals("y") && player2hand.size() > 0 && player1hand.size() > 0) {
            printPlayStatement(1, player1hand);
            printPlayStatement(2, player2hand);
            
            if (player1hand.get(0).get(1).equals(player2hand.get(0).get(1))) {
                System.out.println("It's war time!\n");
                ArrayList<ArrayList<Integer>> warPile = new ArrayList<>();
                int player1DeckSize = player1hand.size();
                int player2DeckSize = player2hand.size();
                boolean continueWar = true;
                while (continueWar) {
                    switch(player1DeckSize) {
                        case 1: case 2: case 3:
                            System.out.println("War conditions not met for Player One");
                            continueWar = false;
                            playersContinue = "n";
                            break;
                        default:
                            switch (player2DeckSize) {
                                case 1: case 2: case 3:
                                    System.out.println("War conditions not met for Player Two");
                                    continueWar = false;
                                    playersContinue = "n";
                                    break;
                                default:
                                    //Adds all tying, faced down and final faced up cards to the war pile
                                    addingToWarPile(player1hand, warPile);
                                    addingToWarPile(player2hand, warPile);

                                    System.out.println("Player 1 places down a card.");
                                    addingToWarPile(player1hand, warPile);
                                    System.out.println("Player 2 places down a card.");
                                    addingToWarPile(player2hand, warPile);
                                    System.out.println("Player 1 places down a card.");
                                    addingToWarPile(player1hand, warPile);
                                    System.out.println("Player 2 places down a card.");
                                    addingToWarPile(player2hand, warPile);
                                    System.out.println("Player 1 places down a card.");
                                    addingToWarPile(player1hand, warPile);
                                    System.out.println("Player 2 places down a card.");
                                    addingToWarPile(player2hand, warPile);
                                    printPlayStatement(1, player1hand);
                                    ArrayList<Integer> player1WarCard = player1hand.get(0);
                                    addingToWarPile(player1hand, warPile);
                                    printPlayStatement(2, player2hand);
                                    ArrayList<Integer> player2WarCard = player2hand.get(0);
                                    addingToWarPile(player2hand, warPile);
                                    int cardValueDifference = player1WarCard.get(1).compareTo(player2WarCard.get(1));
                                    switch (cardValueDifference) {
                                        //runs when both players tie
                                        case 0:
                                            System.out.println("This battle ends in a tie.\n");
                                            break;

                                        //runs when player 1 wins war
                                        case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12:
                                            System.out.println("Player 1 wins the war!");
                                            player1hand.addAll(warPile);
                                            continueWar = false;
                                            break;

                                        //runs when player 2 wins war
                                        case -1: case -2: case -3: case -4: case -5: case -6: case -7: case -8: case -9: case -10: case -11: case -12:
                                            System.out.println("Player 2 wins the war!");
                                            player2hand.addAll(warPile);
                                            continueWar = false;
                                            break;

                                    } //switch: checks the card value difference between Player 1 and Player 2
                            } //switch: checks the amount of cards that Player 2 has/starts war if both players have enough cards
                    } //switch: checks the amount of cards that Player 1 has
                } //loop for initiating war while war conditions are met

            } //executes when both players have cards of same value

            else if (player1hand.get(0).get(1).compareTo(player2hand.get(0).get(1)) > 0) {
                System.out.println("Player 1 wins the battle!");
                addingToWinningDeck(player1hand, player2hand);
            } //runs when player 1 wins

            else {
                System.out.println("Player 2 wins the battle!");
                addingToWinningDeck(player2hand, player1hand);
            } //runs when player 2 wins

            if (plays < userInput - 1) {
                System.out.println("Ready to start the next round? Press 'y' for yes or 'n' for no");
                playersContinue = scan.next();
            } //controls the amount of times this message is displayed
            plays++;
        } //loops ends when a player wins war

        System.out.println("The game is over.\n");
        //checks how many cards each player has at the end of game
        if (player2hand.size() == player1hand.size()) {
            System.out.println("It's a draw...");
        } //executes if both players have the same amount of cards at the end of the game
        else if (player1hand.size() > player2hand.size()) {
            System.out.println("Player 1 wins!");
        } //executes if player 1 wins the entire game
        else {
            System.out.println("Player 2 wins!");
        } //executes if player 2 wins the entire game
    } //loop for the entire war game as long as players have cards to play
} //ends public class Cards
