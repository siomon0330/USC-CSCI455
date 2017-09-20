// Name:Chuanli Wei
// USC NetID:6222006323
// CS 455 PA3
// Spring 2017

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


/**
 * A dictionary of all anagram sets.
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
    //This anagramMap maps each word to its all anagrams which are stored in an arraylist
    Map<String, ArrayList<String>> anagramMap;

    /**
     * Create an anagram dictionary from the list of words given in the file
     * indicated by fileName.
     * PRE: The strings in the file are unique.
     * @param fileName  the name of the file to read from
     * @throws FileNotFoundException  if the file is not found
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException {

        //Read each word from dictionary and store it in the anagram dictionary
        anagramMap = new HashMap<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            String str = scanner.next();

            //Get rid of all the characters which are not from 'a' to 'z'
            String word = ScrableWords.cleanWord(str);

            //Get the sorted version of the string
            word = ScrableWords.sortWord(word);
            if(anagramMap.containsKey(word)){
                anagramMap.get(word).add(str);
            }else{
                ArrayList<String> anagram = new ArrayList<>();
                anagram.add(str);
                anagramMap.put(word, anagram);
            }
        }
    }


    /**
     * Get all anagrams of the given string. This method is case-sensitive.
     * E.g. "CARE" and "race" would not be recognized as anagrams.
     * @param s string to process
     * @return a list of the anagrams of s
     *
     */
    public ArrayList<String> getAnagramsOf(String s) {
        s = ScrableWords.cleanWord(s);
        s = ScrableWords.sortWord(s);
        return anagramMap.get(s);
    }


}