import java.sql.SQLOutput;
import java.util.ArrayList;

public class ArrayList {
    //Prints the list of friends
    public static void printList(ArrayList friends) {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ArrayList<String> friends= new ArrayList<>();
        //Adding friends to the array
        friends.add("Alice");
        friends.add("Bob");
        friends.add("Connie");
        friends.add("David");
        friends.add("Edward");
        friends.add("Fran");
        friends.add("Gomez");
        friends.add("Harry");

        printList(friends);

        //Printing the size of the array
        System.out.println("The friends list currently has: " + friends.size() + "\n");

        //Printing the first name in the list
        System.out.println(friends.get(0));

        //Printing the last name in the list
        System.out.println(friends.get(friends.size() - 1) + "\n");

        //Setting Alice to Alice B. Toklas
        int index = friends.indexOf("Alice");
        friends.set(index, "Alice B. Toklas");
        printList(friends);

        //Adding Doug after David
        int index1 = friends.indexOf("David");
        friends.add(index1 + 1, "Doug");
        printList(friends);

        //Creating a new array list
        ArrayList<String> friends2 = new ArrayList<>(friends);
        printList(friends2);
        friends2.remove(0);
        printList(friends2);

        printList(friends);
    }
}
