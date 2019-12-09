/**
 * TransactionLogger class that records all transactions in the motel.
 * Homework Assignment: Term Project
 * @author Michael Zaragoza and Rifa Safeer Shah
 * 12/09/2019
 */
package cecs277termproject;

import java.io.*;
import java.util.Scanner;

public class TransactionLogger {
    /** The file name where we will do the ASCII logging */
    private static String logFileName = "RoachyInnTransaction.txt";

    /**
     * The singleton instance. The volatile keyword makes sure that multiple threads
     * handle the unique instance variable correctly when we initialize it.
     */
    private volatile static TransactionLogger logger;

    /** The File corresponding to the log file name */
    private File logFile;

    /** Flag to tell whether we have written to this log yet or not. */
    boolean append = false;

    public static void setFile (String fileName) {
        TransactionLogger.logFileName = fileName;
    }

    /** The private constructor that only this class can use. */
    private TransactionLogger () {
        this.logFile = new File (TransactionLogger.logFileName);
    }

    /**
     * Takes the place of a typical constructor.
     * @return	The one and only instance of the Logger class.
     */
    public static TransactionLogger getLogger () {
        if (TransactionLogger.logger== null) {
            //Make this thread safe
            synchronized (TransactionLogger.class) {
                if (TransactionLogger.logger == null) {
                    TransactionLogger.logger = new TransactionLogger();
                }
            }
        }
        return TransactionLogger.logger;
    } // End of the getLogger method

    /**
     * Logs any transaction information.
     * @param message The string that you want to put out to the log.
     */
    public void log (String message) {
        FileWriter fileWriter = null;
        synchronized (this) {
            try {
                //Create a new FileWriter and append if we have written anything already.
                fileWriter = new FileWriter (this.logFile.getAbsoluteFile(), this.append);
                this.append = true;					// From here on out, append
            } catch (IOException e) {
                e.printStackTrace();
            } // End of squelching the IOException exception
            PrintWriter pw = new PrintWriter (fileWriter);
            pw.println(message);
            pw.close();
        }
    }

    /**
     * Prints all transactions from the log file.
     * @throws FileNotFoundException if the file is not found.
     */
    public void printAllTransactions() throws FileNotFoundException {
        System.out.println("\nAll records of transactions for this motel: ");
        Scanner inputFile = new Scanner(this.logFile);
        while (inputFile.hasNextLine()) {
            System.out.println(inputFile.nextLine());
        }
    }
}
