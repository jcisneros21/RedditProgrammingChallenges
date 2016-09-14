import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class anagram {

  public static Boolean isAnagram(String word1, String word2) {
    // Strip any spaces between words
    String strip_word1 = word1.replaceAll("\\s", "");
    String strip_word2 = word2.replaceAll("\\s", "");
    // Change all letters to lowercase
    String lowercase_word1 = strip_word1.toLowerCase();
    String lowercase_word2 = strip_word2.toLowerCase();
    // Arrays are referenced objects, so you can't check if their equivalent with
    // the equivalent operator "==". They will always be different.
    char[] wordArray1 = lowercase_word1.toCharArray();
    char[] wordArray2 = lowercase_word2.toCharArray();
    Arrays.sort(wordArray1);
    Arrays.sort(wordArray2);

    // Checks to see if two arrays are equivalent
    if(Arrays.equals(wordArray1,wordArray2)){
      return true;
    }
    else {
      return false;
    }
  }
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    String sentence = reader.nextLine();
    String[] parts = sentence.split("\"");

    String word1 = parts[1];
    String word2 = parts[3];

    if(isAnagram(word1,word2)) {
      System.out.println("\"" + word1 + "\"" + " is an anagram of " +
                         "\"" + word2 + "\"");
    }
    else{
      System.out.println("\"" + word1 + "\"" + " is NOT an anagram of " +
                         "\"" + word2 + "\"");
    }
  }

}
