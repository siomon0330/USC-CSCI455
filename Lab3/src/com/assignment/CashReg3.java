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
public class CashReg3
{
    private static final int QUARTER_VALUE = 25;
    private static final int DIME_VALUE = 10;
    private static final int NICKEL_VALUE = 5;
    private static final int PENNY_VALUE = 1;
    private static final int DOLLAR_VALUE =100;
    private int purchase;
    private int payment;

    /**
     Constructs a cash register with no money in it.
     */
    public CashReg3()
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

    /*
     Enters the payment received from the customer.
     @param dollars the number of dollars in the payment
     @param quarters the number of quarters in the payment
     @param dimes the number of dimes in the payment
     @param nickels the number of nickels in the payment
     @param pennies the number of pennies in the payment
     */
    public void enterPayment(Change change)
    {
        payment = change.totalValue();
    }

    /**
     Computes the change due and resets the machine for the next customer.
     @return the change due to the customer
     */
    public Change giveChange()
    {
        int changeCent = payment-purchase;
        purchase = 0;
        payment = 0;
        int dollar = changeCent/DOLLAR_VALUE;
        changeCent = changeCent%DOLLAR_VALUE;
        int quater = changeCent/QUARTER_VALUE;
        changeCent = changeCent%QUARTER_VALUE;
        int dim = changeCent/DIME_VALUE;
        changeCent = changeCent%DIME_VALUE;
        int nickel = changeCent/NICKEL_VALUE;
        changeCent=changeCent%NICKEL_VALUE;
        int penny = changeCent;



        Change change = new Change(dollar,quater,dim,nickel,penny);
        return change;
    }
}

