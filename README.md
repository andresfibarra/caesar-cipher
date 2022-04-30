# caesar-cipher

### Overview

CaesarEncryptor is a library with static methods to encrypt and decrypt messages using a simplified caesarCypher. 
The included methods take a key and shift each character of the provided message by the given key.

Also included is CaesarHacker - a library to attempt to crack a message encrypted using the caesar cipher implemented above. 
It builds a set of words in the English language and then loops through keeps 1-50, checking to see if each word is in the set of potential words. 
If a high enough percentage of the words is found in the set, then that potential message is returned. 

Also included is a sample "driver" class which displays usage of the methods. 

## Usage

The encryption library, found in `CaesarEncryptor.java`, has the following functions:

```
public static String encrypt(int key, String original)
public static String decrypt(int key, String coded)
```

The hacking library, found in `CaesarHacker.java`, has the following functions:

```
public static Set<String> decode (String coded)
private static void createDict(String filename)
public static void checkAgainstDict(String string)
```
