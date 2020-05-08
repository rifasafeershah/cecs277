/**
 * Stimulation of the card game, War using ArrayLists
 * Homework Assignment: ArrayList w/ Cards
 @author Rifa Safeer Shah and Michael Zaragoza
 * 09/04/19
 */



package cecs277_homeworks;
import java.util.*;

public class Cards {
	
	/**
	 * 
	 * @param playersDeck
	 * @return 
	 */
    public static String printValue(ArrayList<ArrayList<Integer>> playersDeck) {
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
     * 
     * @param playerNum
     * @param playersDeck
     */
    public static void printPlayStatement(int playerNum, ArrayList<ArrayList<Integer>> playersDeck) {
        if (playersDeck.get(0).get(1).equals(1)) {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of clubs." );
        }
        else if (playersDeck.get(0).get(1).equals(2)) {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of diamonds." );
        }
        else if (playersDeck.get(0).get(1).equals(3)) {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of spades." );
        }
        else {
            System.out.println("Player " + playerNum + " plays " + printValue(playersDeck) + " of hearts." );
        }
    }
    
    /**
     * 
     * @param args
     */
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
          //Types: 1 = clubs; 2 = diamonds; 3 = spades; 4 = hearts

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

        System.out.println("How many plays will there be for this game?");
        Scanner scan = new Scanner(System.in);
        int userInput = scan.nextInt();
        String playersContinue = "y";
        int plays = 0;
        System.out.println("Let the war begin!");
        while (plays < userInput && playersContinue.equals("y")) {
            printPlayStatement(1, player1hand);
            printPlayStatement(2, player2hand);
            if (player1hand.get(0).get(1).equals(player2hand.get(0).get(1))) {
                //FIXME war!!!
                System.out.println("its a draw...");
            } //ends if
            else if (player1hand.get(0).get(1).compareTo(player2hand.get(0).get(1)) > 0) {
                System.out.println("Player 1 wins the battle!");
                ArrayList<Integer> lostCard = player2hand.get(0);
                ArrayList<Integer> victoryCard = player1hand.get(0);
                player2hand.remove(lostCard);
                player1hand.remove(victoryCard);
                player1hand.add(victoryCard);
                player1hand.add(lostCard);
            } //ends else if
            else {
                System.out.println("Player 2 wins the battle!");
                ArrayList<Integer> lostCard = player1hand.get(0);
                ArrayList<Integer> victoryCard = player2hand.get(0);
                player1hand.remove(lostCard);
                player2hand.remove(victoryCard);
                player1hand.add(victoryCard);
                player1hand.add(lostCard);
            } //ends else
            if (player2hand.size() == 0 || player1hand.size() == 0) {
                break;
            } //ends if
            System.out.println("Ready for the next round? Press 'y' for yes or 'n' for no");
            playersContinue = scan.next();
            plays++;
        } //ends while loop
        System.out.println("The game is over.");
        if (player2hand.size() == player1hand.size()) {
            System.out.println("It's a draw...");
        } //ends if
        else if (player1hand.size() > player2hand.size()) {
            System.out.println("Player 1 wins!");
        } //ends else if
        else {
            System.out.println("Player 2 wins!");
        } //ends else

    } //ends main
} //ends class "Cards"


//when both players have sufficient cards (4) to continue the game
// if (player1hand.size() == 3 && player2hand.size() == 3 ) {
//		System.out.println("player 1 war card is: " + player1hand.get(0).toString());
//		System.out.println("player 2 war card is: " + player2hand.get(0).toString());



//game ends when one player's cards = 0
//if (player1hand.size() = 0) {
//		System.out.println("game over!");
//		System.out.println("player 1 has won the war game");
//if (player2hand.size() = 0) {
//		System.out.println("game over!");
//		System.out.println("player 2 has won the war game");
