package com.assignment;

/**
 This class tests the CashReg class.
 Version for CS 455 lab 3.  Modified from version from Big Java, 4th ed.
 Also tests getTotal() accessor function.
 */
public class CashRegTester2
{
    public static void main(String[] args)
    {
        CashReg2 register = new CashReg2();

        register.recordPurchase(4.35);
        System.out.print("Total: ");
        System.out.println(register.getTotal());
        System.out.println("Expected: 4.35");
        System.out.println();
        register.enterPayment(5,0,0,0,0);
        System.out.println(register.giveChange());
        System.out.println("Expected:0.65");
        System.out.println();


        register.recordPurchase(0.75);
        System.out.print("Total: ");
        System.out.println(register.getTotal());
        System.out.println("Expected: 0.75");
        System.out.println();

        register.recordPurchase(1.50);
        System.out.print("Total: ");
        System.out.println(register.getTotal());
        System.out.println("Expected: 2.25");
        System.out.println();

        register.enterPayment(2, 0, 5, 0, 0);
        System.out.print("Change: ");
        System.out.println(register.giveChange());
        System.out.println("Expected: 0.25");
        System.out.println();

        register.recordPurchase(2.25);
        System.out.print("Total: ");
        System.out.println(register.getTotal());
        System.out.println("Expected: 2.25");
        System.out.println();

        register.recordPurchase(19.25);
        System.out.print("Total: ");
        System.out.println(register.getTotal());
        System.out.println("Expected: 21.5");
        System.out.println();

        register.enterPayment(23, 2, 0, 0, 0);
        System.out.print("Change: ");
        System.out.println(register.giveChange());
        System.out.println("Expected: 2.0");
    }
}