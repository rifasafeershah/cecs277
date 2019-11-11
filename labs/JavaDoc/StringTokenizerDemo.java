/**
 * Using the StringTokenizer class to check the amount of tokens and see what tokens come next.
 * Lab Assignment: Java Doc
 @author Rifa Safeer Shah and Michael Zaragoza
 * 09/04/19
 */

package Labs;
import java.util.StringTokenizer;

/**
 * The class uses the comma as the delimiter to see what tokens we receive.
 */
public class StringTokenizerDemo {
    public static void main(String[] args) {
        String sentence = "it's,fleece,was,white,as,snow";
        StringTokenizer mystery = new StringTokenizer(sentence, ",");
        System.out.println(mystery.countTokens());
        System.out.println(mystery.nextToken());
        System.out.println(mystery.nextToken());
    } //Ends main
} //Ends StringTokenizer class
