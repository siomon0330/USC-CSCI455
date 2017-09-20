

/*
 * Contains after7 method and tests it on a bunch of hardcoded test
 * cases, printing out test data, actual results, expected results,
 * and a FAILED message if actual results don't match expected
 * results.
 */


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class After7Tester {


    /* Removes all values after the last 7 in the list.
     */
    public static void after7(LinkedList<Integer> list) {
        ListIterator<Integer> iter = list.listIterator(list.size());
        int sentinal = 0;
        while(iter.hasPrevious()){
            if(iter.previous() != 7){
                sentinal++;
            }
        }

        if(sentinal==list.size()) return;
        iter = list.listIterator(list.size());

        while(iter.hasPrevious()){
            int element = iter.previous();
            if(element==7){
                return;
            }else {
                iter.remove();
            }
        }


    }



    public static void main(String args[]) {

        testAfter7("", "[]");
        testAfter7("7", "[7]");
        testAfter7("7 2", "[7]");
        testAfter7("3", "[3]");
        testAfter7("3 4 5", "[3, 4, 5]");
        testAfter7("3 7", "[3, 7]");
        testAfter7("2 5 7", "[2, 5, 7]");
        testAfter7("7 7 7", "[7, 7, 7]");
        testAfter7("3 7 3 7 5", "[3, 7, 3, 7]");
        testAfter7("7 3 7 3 1 4 12", "[7, 3, 7]");

    }



    /*  Assumes the following format for list strings (first one
     *     is empty list):
     *   "", "3", "3 4", "3 4 5", etc.
     */
    public static LinkedList<Integer> makeList(String listString) {
        Scanner strscan = new Scanner(listString);

        LinkedList<Integer> list = new LinkedList<Integer>();

        while (strscan.hasNextInt()) {
            list.add(strscan.nextInt());
        }

        return list;
    }


    /* Test hasPeak method on a list form of input given in listString
     * Prints test data, result, expectedResult, and whether result
     * matched expectedResult
     *
     * listString is a string form of a list given as a space separated
     * sequence of ints.  E.g.,
     *  "" (empty string), "3" (1 elmt string), "2 4" (2 elmt string), etc.
     *
     * expectedResult needs to be given in List toString() format so
     * we can compare it for equality to result.toString()
     */
    public static void testAfter7(String listString, String expectedResult) {

        LinkedList<Integer> list = makeList(listString);

        System.out.println("list: " + list);

        System.out.println("expected result: " + expectedResult);

        after7(list);

        System.out.print("after7(list): " + list);

        if (!list.toString().equals(expectedResult)) {
            System.out.print("...after7 FAILED");
        }

        System.out.println();
        System.out.println();
    }
}