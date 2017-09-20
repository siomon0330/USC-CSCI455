// Name:Chuanli Wei
// USC NetID:6222006323
// CS 455 PA3
// Spring 2017

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class WordFinder {
    public static void main(String[] args) {

        try{
            System.out.println("Type . to quit.");

            //Our anagram dictionary
            AnagramDictionary anagramDictionary;

            //The source of our dictionary
            String diction;
            if (args.length > 0) {
                diction = args[0];
                anagramDictionary = new AnagramDictionary(diction);
            } else{
                //Our default sowpods dictionary
                anagramDictionary = new AnagramDictionary("sowpods.txt");
            }


            Scanner scanner = new Scanner(System.in);
            //The input rack
            String input = scanner.next();

            while(true) {

                System.out.print("Rack? ");
                //The sentinel command to exit
                if(input.equals(".")){
                    return;
                }

                //Return the multiplicity of the input rack
                int[] multi = ScrableWords.multi(input);

                //Return the cleaned version of the input(only contains characters from 'a' to 'z')
                String cleanedAnagram = ScrableWords.cleanWord(input);

                //Return the sorted version of the input(alphabetically)
                String sortedAnagram = ScrableWords.sortWord(cleanedAnagram);

                //Unique is the input without any repeated characters
                String unique = sortedAnagram.charAt(0)+"";
                for(int i = 1; i < sortedAnagram.length(); i++){
                    if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                        unique = unique + sortedAnagram.charAt(i);
                    }
                }

                Rack rack = new Rack();

                //Return all the subsets of unique
                ArrayList<String> res = rack.getAllSubsets(unique, multi, 0);

                //This list is used to store all the legal anagrams of each subset
                ArrayList<String> list = new ArrayList<>();
                for (String str : res) {
                    String word = ScrableWords.sortWord(str);
                    if (anagramDictionary.anagramMap.containsKey(word)) {
                        list.addAll(anagramDictionary.anagramMap.get(word));
                    }
                }

                //This Hash map is used to map each anagram to its corresponding score
                HashMap<String, Integer> map = new HashMap<>();
                ScoreTable scoreTable = new ScoreTable();
                for (String str : list) {
                    int sum = 0;
                    for (int i = 0; i < str.length(); i++) {
                        int score = scoreTable.table[str.charAt(i) - 'a'];
                        sum = sum + score;
                    }
                    map.put(str, sum);

                }

                //This comparator is used to compare each anagram by their score
                Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o2.getValue() == o1.getValue()) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue() - o1.getValue();
                    }
                };

                //This list is used to store each map entry in order to sort them
                ArrayList<Map.Entry<String, Integer>> array = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    array.add(entry);
                }
                Collections.sort(array, comparator);

                //Print out the result
                System.out.println("we can make " + array.size()+" words from " + "\""+sortedAnagram+"\"");
                if(array.size()>0) {
                    System.out.println("All of the words with their scores (sorted by score):");
                    for (Map.Entry<String, Integer> entry : array) {
                        System.out.println(entry.getValue() + ": " + entry.getKey());
                    }
                }

                //Get the next input
                input = scanner.next();

            }

        }catch (FileNotFoundException exp){

            System.out.print(exp.getStackTrace());
        }
    }
}
