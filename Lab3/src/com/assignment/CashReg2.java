package com.assignment;
import java.math.*;
/**
 A cash register totals up sales and computes change due.

 Version for CS 455 lab 3.  Modified from version from Big Java, 4th
 ed.  Note: in the 5th edition of the textbook the code is virtually
 the same except that the method called enterPayment here, is called
 receivePayment in the 5th edition.

 Changes [made by CMB]:

 Added getTotal() accessor function.
 Made constants private.

 Ex:
 CashReg register = new CashReg();
 register.recordPurchase(0.59);  // ring something up
 register.recordPurchase(1.99);  // ring up another item
 register.recordPurchase(5.0);   // ring up a third item
 double tot = register.getTotal();    // total of purchases so far: 7.58
 register.enterPayment(10,0,0,0,0);  // customer pays with a 10
 int change = register.giveChange();  // compute change owed: 2.42
 // and zeroes out register

 register.recordPurchase(1.0);  // now we start ringing up someone else . . .

 */
public class CashReg2
{
    private static final int QUARTER_VALUE = 25;
    private static final int DIME_VALUE = 10;
    private static final int NICKEL_VALUE = 5;
    private static final int PENNY_VALUE = 1;
    private static final int DOLLAR_VALUE =100;
    private double purchase;
    private double payment;

    /**
     Constructs a cash register with no money in it.
     */
    public CashReg2()
    {
        purchase = 0;
        payment = 0;
    }

    /**
     Records the purchase price of an item.
     @param amount the price of the purchased item
     */
    public void recordPurchase(double amount)
    {

        purchase = (int)(purchase + Math.round(amount*DOLLAR_VALUE));
    }

    /**
     Gets total of all purchases made.
     */
    public double getTotal() {
        return purchase/(double)DOLLAR_VALUE;
    };

    /**
     Enters the payment received from the customer.
     @param dollars the number of dollars in the payment
     @param quarters the number of quarters in the payment
     @param dimes the number of dimes in the payment
     @param nickels the number of nickels in the payment
     @param pennies the number of pennies in the payment
     */
    public void enterPayment(int dollars, int quarters,
                             int dimes, int nickels, int pennies)
    {
        payment = dollars*DOLLAR_VALUE + quarters * QUARTER_VALUE + dimes * DIME_VALUE
                + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
    }

    /**
     Computes the change due and resets the machine for the next customer.
     @return the change due to the customer
     */
    public double giveChange()
    {
        double change = (double)(payment - purchase)/DOLLAR_VALUE;
        purchase = 0;
        payment = 0;
        return change;
    }
}

