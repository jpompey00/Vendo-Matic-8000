package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    private double balance;
    //private double change;

    private int quarters;
    private int dimes;
    private int nickels;

    Money testMon = new Money(5);
    //==tests to run==
    //test that balance is being set correctly
    //test for negative input being added

    public String calculateChange(int balance) {
        // old cod
//        double sum = 0;
//        while (balance != 0) {
//            if (balance >= 0.25) {
//                quarters = (int) (balance / .25);
//                setBalance(balance - (quarters * .25));
//                sum += (quarters * 0.25);
//            } else if (balance >= 0.10) {
//                dimes = (int) (balance / 0.10);
//                setBalance(balance - (dimes * 0.10));
//                sum += (dimes * .10);
//            }
//            else if (balance >= 0.05) {
//                nickels = (int) (balance / .05);
//                setBalance(balance - (nickels * .05));
//                sum += (nickels * .05);
//            } else
//                break;
//        }

        double totalChange = balance;
        int change = (int)(Math.ceil(balance*100));

        int dollars = Math.round((int)change/100);
        change=change%100;
        quarters = Math.round((int)change/25);
        change=change%25;
        dimes = Math.round((int)change/10);
        change=change%10;
        nickels = Math.round((int)change/5);
        change=change%5;
        //int pennies = Math.round((int)change/1);

        testMon.setBalance(0);

        int totalQuarters = quarters + (dollars * 4);
        return System.lineSeparator() +
                "Quarters: " + totalQuarters + System.lineSeparator() +
                "Dimes: " + dimes + System.lineSeparator() +
                "Nickels: " + nickels + System.lineSeparator() +
                "Total change: $" + BigDecimal.valueOf(totalChange).setScale(2, RoundingMode.HALF_UP) + System.lineSeparator() +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP);
    }

    @Test
    public void testFeedMoney(){
        testMon.feedMoney(5);
        assertEquals(10.00, testMon.getBalance());
    }

    @Test
    public void testChange(){
        assertEquals(System.lineSeparator() +
                "Quarters: " + "40" + System.lineSeparator() +
                "Dimes: " + dimes + System.lineSeparator() +
                "Nickels: " + nickels + System.lineSeparator() +
                "Total change: $" + BigDecimal.valueOf(10).setScale(2, RoundingMode.HALF_UP) + System.lineSeparator() +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP),
                this.calculateChange(10));
    }

}
