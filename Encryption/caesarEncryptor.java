/**
 * Static library with methods to encrypt and decrypt messages using the caesar cipher
 * @author Andres Ibarra
 */
public class caesarEncryptor {

//    public caesarEncryptor(String string) {
//        this.string = string.toLowerCase();
//        encryptedString = "";
//    }

    /**
     * Apply the caesar cipher to the given string using the supplied key
     * @param key The key number that the characters are shifted by
     * @param original Message to be coded
     * @return The coded message
     */
    public static String encrypt(int key, String original) {
        String temp;
        String encryptedString = "";
        for (int i = 0; i < original.length(); i++) {
            int chNum = original.charAt(i);
            int newChNum = chNum + key;
            char newCh = (char)newChNum;
            temp = "" + newCh;
            encryptedString += temp;
        }
        return encryptedString;
    }

    /**
     * Knowing the key, use the caesar cipher on the coded string to get the original message
     * @param key The key number that the characters are shifted by
     * @param coded Coded message
     * @return The decrypted message
     */
    public static String decrypt(int key, String coded) {
        String temp;
        String encryptedString = "";
        for (int i = 0; i < coded.length(); i++) {
            int chNum = coded.charAt(i);
            int newChNum = chNum - key;
            char newCh = (char)newChNum;
            temp = "" + newCh;
            encryptedString += temp;
        }
        return encryptedString;
    }

    /*
    Caesar cipher - simplified
    Everything is in either uppercase or lowercase
    Has a key number
    Shifts the alphabet by this key number
    Takes the text and replaces each letter with this modified alphabet

     Options for data structures to use
        Linked lists
        Maps

     */

}
