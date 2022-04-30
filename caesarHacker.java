import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Static library with methods to decode the a message coded with the caesar cipher, if you don't have the key
 * NOTE: ONLY DEALING WITH POSITIVE KEYS for now, and only looking at the first 50 keys
 * @author Andres Ibarra
 */

public class caesarHacker {
    private static Set<String> dict = new HashSet<String>();
    private static Set<String> potentialMessages;

    /**
     * Checks the keys 1-50. Takes each and tests if it contains valid words. If it contains a high enough percentage
     * of words in english, adds it to a set of potential messages, which the function returns
     * @param coded The message that the caesar cipher has been applied to
     * @return A set of strings containing possible messages
     */
    public static Set<String> decode (String coded) {
        potentialMessages = new HashSet<>();
        if (dict == null) {
            caesarHacker.createDict("inputs/words_alpha.txt");
        }

        char first = coded.charAt(0);
        int lowestChar = first;
        for (int i = 0; i < coded.length(); i++) {
            char c = coded.charAt(i);
            if (c < lowestChar) lowestChar = c;
        }
        System.out.println(lowestChar);

        //starting so that lowest is 30, note, 32 is the space character

//        for (int i = lowestChar; i < 1112064-lowestChar; i++) {
//            System.out.println(caesarEncryptor.decrypt(i - lowestChar, "coded"));
//             if (i >= 35+lowestChar) {break;}
//        }

        //testing out only checking the first 50 possible keys
        for (int i = 1; i < 50; i++) {
            String possible = caesarEncryptor.decrypt(i, coded);
            //System.out.println(possible);
            checkAgainstDict(possible);
        }

        return potentialMessages;
    }

    /**
     * Reads a file with words in the English language and uses it to create a Set with possible words
     */
    private static void createDict(String filename) {
        BufferedReader input;

        if (dict != null) {

            try {
                input = new BufferedReader(new FileReader(filename));
            } catch (FileNotFoundException e) {
                System.err.println("Cannot open file. \n" + e.getMessage());
                return;
            }

            try {
                String line;
                while ((line = input.readLine()) != null) {
                    dict.add(line);
                }
            } catch (IOException e) {
                System.err.println("IO error while reading.\n" + e.getMessage());
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    System.err.println("Cannot close file.\n" + e.getMessage());
                }
            }
        }
    }

    /**
     * Uses the dictionary Set to check if the string is a valid English word
     * @param string The string being verified if its a valid English word
     */
    public static void checkAgainstDict(String string) {
        //split along whitespace and punctuation
        String[] s = string.toLowerCase().split("[, ?.@]+");
        int wordsInDict = 0;
        for (int i = 0; i < s.length; i++) {
            //check every word to see if its in dictionary
            if (dict.contains(s[i])) wordsInDict++;
        }
        //if > 80% are words, add to the possible messages set
        double score = (double)wordsInDict/s.length;
        //System.out.println(score);
        if (score > 0.5){
            potentialMessages.add(string);
            System.out.println(score);
        }
    }
}
