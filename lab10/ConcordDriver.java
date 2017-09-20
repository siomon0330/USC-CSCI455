import java.util.Scanner;

/**
 * Finds frequency of each word in a file.
 * Unlike the lecture version of this code, this one is smarter
 * about what it considers a word.
 *
 * Version for the lab.
 */

public class ConcordDriver {


    public static void main(String[] args) {

        Concord concord = new Concord();

        Scanner in = new Scanner(System.in);

        concord.addData(in);

        //concord.print(System.out);

     	concord.printSorted(System.out);

    }

}