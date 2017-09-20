// Name:Chuanli Wei
// USC NetID:6222006323
// CS 455 PA3
// Spring 2017

import java.util.*;

/**
 *This class ScrableWords is used to
 * provide several static methods to process the input string
 */
public class ScrableWords{
    String word;
    public ScrableWords(String word){
        this.word = word;
    }

    /**
     * Sort the string alphabetically by each character
     * @param word the string to be sorted
     * @return the string after sorted
     */
    public static String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String str = new String(chars);
        return str;
    }

    /**
     * Clean the string: get rid of characters which is not from 'a' to 'z'
     * @param word the string to be cleaned
     * @return the string after cleaned
     */
    public static String cleanWord(String word) {
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            letter = Character.toLowerCase(letter);
            if (letter >= 'a' && letter <= 'z') {
                str = str + letter;
            }
        }
        return str;
    }


    /**
     * Get the multiplicity of the string
     * @param str the string to get its multiplicity
     * @return int[] each element in the array represent how many times the corresponding character appears
     */
    public static int[] multi(String str){
        int[] multi;
        String cleanedAnagram = ScrableWords.cleanWord(str);
        String sortedAnagram = ScrableWords.sortWord(cleanedAnagram);
        String unique = sortedAnagram.charAt(0)+"";

        for(int i = 1; i < sortedAnagram.length(); i++){
            if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                unique = unique + sortedAnagram.charAt(i);
            }
        }
        multi = new int[unique.length()];
        int num = 1;
        int index = 0;
        for(int i = 0; i < sortedAnagram.length()-1; i++){
            if(sortedAnagram.charAt(i) == sortedAnagram.charAt(i+1)){
                num++;
            }else{
                multi[index++] = num;
                num = 1;
            }
        }
        multi[unique.length()-1] = num;
        return multi;
    }

    /**
     * Get rid of the repeated character of each character
     * @param str the string to be processed
     * @return the string with each character only once
     */
    public static String uniqueString(String str){

        String cleanedAnagram = ScrableWords.cleanWord(str);
        String sortedAnagram = ScrableWords.sortWord(cleanedAnagram);
        String unique = sortedAnagram.charAt(0)+"";

        for(int i = 1; i < sortedAnagram.length(); i++){
            if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                unique = unique + sortedAnagram.charAt(i);
            }
        }
        return unique;
    }
}