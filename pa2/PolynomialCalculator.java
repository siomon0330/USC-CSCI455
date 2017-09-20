
// Name:Chuanli Wei
// USC loginid:6222006323
// CS 455 PA2
// Spring 2017

import java.util.*;

public class PolynomialCalculator {

    public static final int MAX_NUMBER = 10;


    public static void main(String[] args) {


        Polynomial[] result = new Polynomial[MAX_NUMBER];

        //Initialize the array
        for (int i = 0; i < result.length; i++) {
            result[i] = new Polynomial();
        }

        //Direct users to a help command option
        System.out.println("Type 'help' for command options, Or type the command if you don't need help.");


        //Get the command from the user
        Scanner scanner = new Scanner(System.in);
        String typeIn = scanner.nextLine();
        Scanner in = new Scanner(typeIn);
        String command = in.next().toLowerCase();


       //The loop will continue unless 'quit' is typed
       while(true){

            if (command.equals("create")) {

                //check whether the user has provided the index of the polynomial
                if(in.hasNextInt()) {
                    int index = in.nextInt();

                    //Check whether the index is valid
                    if (index >= MAX_NUMBER || index < 0) {
                        System.out.println("ERROR: illegal index for a poly. must be between 0 and 9, inclusive");
                    } else {
                        doCreate(index, result);
                    }
                }else{
                    System.out.println("ERROR: Illegal command. you must provide the index of the polynomial");
                }

            } else if (command.equals("print")) {

                //check whether the user has provided the index of the polynomial
                if(in.hasNextInt()) {
                    int index = in.nextInt();

                    //Check whether the index is valid
                    if (index >= MAX_NUMBER || index < 0) {
                        System.out.println("ERROR: illegal index for a poly. must be between 0 and 9, inclusive");
                    } else {
                        doPrint(index, result);
                    }
                }else{
                    System.out.println("ERROR: Illegal command. you must provide the index of the polynomial.");
                }

            } else if (command.equals("add")) {

                //Store the indexes in a array list, to test whether the user has provided the valid indexes
                ArrayList<Integer> index = new ArrayList<>();
                while(in.hasNext()==true){
                    index.add(in.nextInt());
                }

                //check whether the user has provided the index of the polynomial
                if(index.size()==3) {
                    int index1 = index.get(0);
                    int index2 = index.get(1);
                    int index3 = index.get(2);

                    //Check whether the index is valid
                    if(0 <=index1 && index1 < MAX_NUMBER && 0 <=index2 && index2 < MAX_NUMBER &&  0 <=index3 && index3 <MAX_NUMBER ) {
                        doAdd(index1, index2, index3, result);
                    }else{
                        System.out.println("ERROR: illegal index for a poly. must be between 0 and 9, inclusive");
                    }
                }else {

                    System.out.println("ERROR: Illegal command.you must provide three indexes of the polynomials.");
                }

            } else if (command.equals("eval")) {

                //Check whether the user has provided the index of the polynomial
                if (in.hasNextInt()) {
                    int index = in.nextInt();

                    //Check whether the index is valid
                    if (index >= MAX_NUMBER || index < 0) {
                        System.out.println("ERROR: illegal index for a poly. must be between 0 and 9, inclusive");
                    } else {
                        doEval(index, result);
                    }
                } else {
                    System.out.println("ERROR: Illegal command, you must provide the index of the polynomial");
                }


            }else if (command.equals("quit")) {

                return;

            } else if (command.equals("help")) {

                help();

            } else {
                System.out.println("ERROR: Illegal command. Type 'help' for command options.");
            }

            //get the next command as long as if the command is not 'quit'
             System.out.print("cmd>");
             scanner = new Scanner(System.in);
             typeIn = scanner.nextLine();
             in = new Scanner(typeIn);
             command = in.next().toLowerCase();


       }

    }



// **************************************************************
    //  PRIVATE METHOD(S)


    //Help method providing the choice of commands
    private static void help() {

        System.out.println("X,Y,Z stands for the index of the polynomial");
        System.out.println("Enter create X to create a polynomial of index X");
        System.out.println("Enter print X to print the polynomial of index X");
        System.out.println("Enter add X Y Z to create a polynomial X equals Y + Z");
        System.out.println("Enter eval X to print the value of polynomial for index X");
        System.out.println("Enter quit to to terminate the program");

    }

    /**
     * Create method to create a polynomial using a sequence of coeff-power pairs given by user
     *
     * @ param  index   the index of the array we want to create polynomial
     * @ param  result  the Polynimial array that we operate
     */

    private static void doCreate(int index, Polynomial[] result) {

        //Get the coeff-power pair from the user
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter a space-separated sequence of coeff-power pairs terminated by <nl>");
        String typeIn2 = scanner2.nextLine();
        Scanner in2 = new Scanner(typeIn2);

        //Use an array list to store what user has typed in
        ArrayList<Double> terms = new ArrayList<>();
        while (in2.hasNextDouble()) {
            terms.add(in2.nextDouble());

        }

        //Error checking: this means the user didn't type any double values
        if(terms.size()==0){
            System.out.println("ERROR:Invalid coeff-pow pair, please type the command again.");
        }

        //Error checking: use the absolute value of negative exponent
        for(int i = 1; i < terms.size(); i=i+2){
            if(terms.get(i)<0){
                System.out.println("WARNING: Negative exponent, help you make it positive");
                terms.set(i,Math.abs(terms.get(i)));
            }
        }

        //Error checking: whether the pair of coeff-power is valid
        if (terms.size() % 2 == 1) {
            System.out.println("WARNING:Invalid coeff-power pair, help you get rid of the last coeff");
            terms.remove(terms.size() - 1);
        }

        //Initialize the polynomial to zero in order to create a new one
        result[index] = new Polynomial();

        for (int i = 0; i < terms.size(); i = i + 2) {

            //Use the value in the array to make a term and add it to the polynomial
            Term term = new Term(terms.get(i), terms.get(i + 1).intValue());
            result[index] = result[index].add(new Polynomial(term));

        }

    }

    /**
     * Print the polynomial of index given by user
     *
     * @ param  index   the index of the array we want to print
     * @ param  result  the Polynimial array that we operate
     */

    private static void doPrint(int index, Polynomial[] result) {

        System.out.println(result[index].toFormattedString());

    }

    /**
     * Add two polynomials to aonther using the index given by user
     *
     * @ param  index1,index2,index3   index1 = index2 + index3
     * @ param  result  the Polynimial array that we operate
     */

    private static void doAdd(int index1, int index2, int index3, Polynomial[] result) {

        result[index1] = result[index2].add(result[index3]);

    }


    /**
     * Print the value of a polynomial using the indes given by user
     *
     * @ param  index   the index of the array that we want to calculate its value
     * @ param  result  the Polynimial array that we operate
     */

    private static void doEval(int index, Polynomial[] result) {

        //Get the value of x
        System.out.print("Enter a floating point value for x: ");
        Scanner scanner2 = new Scanner(System.in);
        double val = scanner2.nextDouble();
        System.out.println((result[index]).eval(val));


    }


}



