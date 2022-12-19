package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private double balance;
    //private double change;

    private int quarters;
    private int dimes;
    private int nickels;

    public Money(int moneyInserted) {
        this.balance = moneyInserted;
    }

    public Money() {

    }

    public void feedMoney(int money) {
        setBalance((balance += money));
        Product.log.log("FEED MONEY: " + "$" + BigDecimal.valueOf(money).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(getBalance()).setScale(2, RoundingMode.HALF_UP));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void calculateChange() {
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

        setBalance(change);

        int totalQuarters = quarters + (dollars * 4);

        System.out.println(System.lineSeparator() +
                "Quarters: " + totalQuarters + System.lineSeparator() +
                "Dimes: " + dimes + System.lineSeparator() +
                "Nickels: " + nickels + System.lineSeparator() +
                "Total change: $" + BigDecimal.valueOf(totalChange).setScale(2, RoundingMode.HALF_UP) + System.lineSeparator() +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP));
        Product.log.log("GIVE CHANGE: $" + BigDecimal.valueOf(totalChange).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(getBalance()).setScale(2, RoundingMode.HALF_UP));
    }
}
