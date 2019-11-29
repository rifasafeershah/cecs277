/**
 * Class that deals with writing the mementos to a file and getting the memento's saved state.
 * Homework Assignment: Memento
 * @author Rifa Safeer Shah and Michael Zaragoza
 * 10/30/19
 */
package MementoHW;

import java.io.*;
import java.util.Stack;

public class PersonCaretaker {
    /** Stack that contains all saved mementos of Person */
    private Stack<PersonMemento> mStack = new Stack<>();
    /** File for containing all mementos */
    private File mMementoFile;
    /** input stream to read the binary file */
    private FileInputStream mInputStream;
    /** output stream to write to the binary file */
    private FileOutputStream mOutputStream;
    /** object output stream for writing the memento objects */
    private ObjectOutputStream objOS;
    /** object input stream for reading the memento objects */
    private ObjectInputStream objIS;
    /**
     * Overloaded constructor.
     * @param mementoFile The file to save all the mementos.
     * @throws FileNotFoundException throws if the file is not found.
     */
    public PersonCaretaker(File mementoFile) throws IOException {
        try {
            mMementoFile = mementoFile;
            mOutputStream = new FileOutputStream(mMementoFile, true);
            objOS = new ObjectOutputStream(mOutputStream);
        } //creates streams for reading and writing the file
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("File was not found to store mementos.");
        }
    }

    /**
     * Adds the memento to the stack and writes it to the file.
     * @param memento The memento that's being added.
     * @throws IOException throws if the output stream cannot be detected.
     */
        public void addMemento(Person memento) throws IOException {
        PersonMemento person = new PersonMemento(memento);
        objOS.writeObject(person);
        mStack.push(person);
    }

    /**
     * Returns the person instance with the lowest weight.
     * @return The person instance having the lowest weight
     * @throws IOException throws if the file cannot be read.
     */
    public PersonMemento getMemento() throws IOException, ClassNotFoundException {
        mInputStream = new FileInputStream(mMementoFile);
        objIS = new ObjectInputStream(mInputStream);
        PersonMemento personLowestWeight = (PersonMemento) objIS.readObject();
        while (objIS.read() != -1) {
            PersonMemento pm = (PersonMemento) objIS.readObject();
            if (pm.getWeightPounds() <= personLowestWeight.getWeightPounds()) {
                personLowestWeight = pm;
            }
        } //checks as along as there is a PersonMemento object in the file
        return personLowestWeight;
    }

    /**
     * Returns the person instance with the desired weight.
     * @param weight The weight in question.
     * @return The person instance carrying this weight value.
     * @return Null if the desired weight was not found in any instances of person.
     */
    public PersonMemento getMemento(int weight) throws IOException, ClassNotFoundException {
        mInputStream = new FileInputStream(mMementoFile);
        objIS = new ObjectInputStream(mInputStream);
        PersonMemento pm;
        do {
            pm = (PersonMemento) objIS.readObject();
        } while (pm.getSavedPerson().getWeightPounds() != weight);
        return pm;
    }

    /**
     * Closes both object streams after the program finishes to avoid stream corruption.
     * Cannot close the object output stream before getMemento(), since both ObjectInputStream and ObjectOutputStream
     * use the same binary file.
     * @throws IOException When streams cannot e closed.
     */
    public void closeStreams() throws IOException {
        objIS.close();
        objOS.close();
    }
}
