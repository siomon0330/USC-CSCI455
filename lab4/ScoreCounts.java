

import java.util.Scanner;
import java.util.Arrays;

/**
 Completed program should read student score data from System.in and
 compute count of how many students got each score, and then
 print out each score with its count.
 Scores are in the range 0-HIGH_SCORE

 Why array is better than arraylist for this app:
 1.  size of array doesn't change
 2.  can easily init all spots to the same value
 3.  ints are stored directly in arrays (more efficient)

 Note: also illustrates legality of defining same local twice in
 parallel scopes (not legal if nested).
 */

public class ScoreCounts {

    public static final int HIGH_SCORE = 10;

    public static void main(String[] args) {

        int[] counts = new int[HIGH_SCORE + 1];

        Arrays.fill(counts, 0); // optional

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int score = in.nextInt();

            if (score < 0 || score > HIGH_SCORE) {
                System.out.println("BAD SCORE: " + score
                        + " not counting it.");
            }
            else {
                counts[score]++;
            }

        }

        for (int score = 0; score < counts.length; score++) {
            System.out.println(counts[score] +
                    " students got a score of " +
                    score);
        }



    }
}
