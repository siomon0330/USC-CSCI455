

import sun.swing.BakedArrayList;

import java.util.ArrayList;

/**
 Stores a sequence of integer data values and supports some computations
 with it.

 CS 455 Lab 4.
 */
public class Nums {

    ArrayList<Integer> num;

    /**
     Create an empty sequence of nums.
     */
    public Nums () {

        num = new ArrayList<Integer>();
    }

    public Nums(ArrayList<Integer> array){

        num = array;
    }

    /**
     Add a value to the end of the sequence.
     */
    public void add(int value) {

        num.add(value);
    }


    /**
     Return the minimum value in the sequence.
     If the sequence is empty, returns Integer.MAX_VALUE
     */
    public int minVal() {

        if(num.isEmpty() == true){
            return Integer.MAX_VALUE;
        }

        int min = Integer.MIN_VALUE;
        for(int a:num){
            if(a < min) {
                min = a;
            }
        }

        return min;
    }

    /**
     Prints out the sequence of values as a space-separated list
     on one line surrounded by parentheses.
     Does not print a newline.
     E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
     */
    public void printVals() {

        if (num.isEmpty() == true) {
            System.out.print("");
        }

        String printVal = "(";
        for(int a:num){
            String val = a + " ";
            printVal = printVal + val;
        }
        printVal = printVal + ")";
        System.out.print(printVal);
    }

    /**
     Returns a new Nums object with all the values from this Nums
     object that are above the given threshold.  The values in the
     new object are in the same order as in this one.
     E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
     returns      (19 21 19)
     myNums after call:  (3 7 19 4 21 19 10)
     The method does not modify the object the method is called on.
     */
    public Nums valuesGT(int threshold) {

        ArrayList<Integer> numsOfT = new ArrayList<Integer>();
        for(int a:num){
            if(a > threshold){
                numsOfT.add(a);
            }
        }
      return new Nums(numsOfT);
    }


}