
import java.util.*;

/**
 This class tests the Nums class.
 CS 455  Lab 4.
 */
public class NumsTester {
    public static void main(String[] args) {

        Nums nums = new Nums();

        // TEST EMPTY NUMS OBJECT

        System.out.print("Value of empty nums: ");
        nums.printVals();
        System.out.println();

        System.out.println("Min value of empty nums: " + nums.minVal());

        testFilter(nums, 10);

        // TEST NON-EMPTY NUMS OBJECT

        readNums(nums);

        System.out.print("Value of nums read in: ");
        nums.printVals();
        System.out.println();

        System.out.println("Min value of nums: " + nums.minVal());

        testFilter(nums, 10);
        testFilter(nums, -20);
        testFilter(nums, -17);
        testFilter(nums, 21);
    }

    /**
     * testFilter tests valuesGT method on nums with given threshold argument
     * and prints info about test performed and the results.
     */
    public static void testFilter(Nums nums, int threshold) {

        System.out.print("Values greater than " + threshold + ": ");

        nums.valuesGT(threshold).printVals();
        System.out.println();

        System.out.print("Original list of nums: ");
        nums.printVals();
        System.out.println();


    }

    /**
     * Read a sequence of values from keyboard into nums variable,
     * until we get to an eof.  If nums is non-empty beforehand, these
     * values get added to the end of the sequence already in nums.
     * Does not error-check input.
     */
    public static void readNums(Nums nums) {

        Scanner in = new Scanner(System.in);
        System.out.print("please enter the input: ");

        while (in.hasNextInt()) {

            int read = in.nextInt();
            nums.add(read);

        }

    }
}