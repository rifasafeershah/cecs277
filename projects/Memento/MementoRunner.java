/**
 * Saves instances of a person and uses the idea of memento to retrieve that saved data to find certain characteristics.
 * Homework Assignment: Memento
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 10/30/19
 */
package MementoHW;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MementoRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFileChooser chooser = new JFileChooser();
        PersonCaretaker personCT = null;
        boolean foundInputFile = false;
        do {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedInFile = chooser.getSelectedFile();
                foundInputFile = true;
                personCT = new PersonCaretaker(selectedInFile);
                System.out.println("File has been found for storing people.");
            } //finds the input file
        } while (!foundInputFile);

        Scanner userInput = new Scanner(System.in);
        //asks for the person's last name
        System.out.println("Enter the person's last name:" );
        String lastName = userInput.next();
        //asks for the person's first name
        System.out.println("Enter the person's first name:" );
        String firstName = userInput.next();
        //creates a person with only a last ans first name
        Person person = new Person(lastName, firstName);

        String userAnswer = "y";
        while (userAnswer.equals("y")) {
            //asks for the person's hair color
            for (int i = 0; i < Person.HairColor.values().length; i++) {
                System.out.println(i + ": \t" + Person.HairColor.values()[i]);
            }
            System.out.println("Enter the number corresponding to the hair color:" );
            int colorNumber = userInput.nextInt();
            System.out.println("You entered: " + Person.HairColor.values()[colorNumber]);
            Person.HairColor hairColor = Person.HairColor.values()[colorNumber];
            //asks for the person's feet portion of height
            System.out.println("Person's height in feet: ");
            int heightFeet = userInput.nextInt();
            //asks for the person's inches portion of height
            System.out.println("Person's height in inches (5'10 would 10 here): ");
            int heightInches = userInput.nextInt();
            //asks for the person's weight in pounds
            System.out.println("Person's weight in pounds: ");
            int weightPounds = userInput.nextInt();
            //creates a new person with the following characteristics and adds that instance as a memento
            person = new Person(lastName, firstName, hairColor, heightFeet, heightInches, weightPounds);
            personCT.addMemento(person);
            System.out.println("Will you like to continue?");
            userAnswer = userInput.next();
        } //loop that asks user for a person's characteristics for each instance of Person
        //searches mementos for a person with the lowest weight
        Person lowestWeight = person.restore(personCT.getMemento());
        System.out.println("Skinniest version: " + lowestWeight);
        //searches mementos for a person with a selected weight
        System.out.println("What weight do you want to search for? ");
        int wantedWeight = userInput.nextInt();
        Person personWantedWeight = person.restore(personCT.getMemento(wantedWeight));
        System.out.println("Person with weight, " + wantedWeight + ": " + personWantedWeight);
        personCT.closeStreams(); //closes both binary file input and output streams
    } //ends main
} //ends MementoRunner
