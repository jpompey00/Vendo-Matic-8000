package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private double balance;
    private double change;


    private int quarters;
    private int dimes;
    private int nickles;

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
        double sum = 0;
        while (balance != 0) {
            if (balance >= 0.25) {
                quarters = (int) (balance / .25);
                setBalance(balance - (quarters * .25));
                sum += (quarters * 0.25);
            } else if (balance >= 0.10) {
                dimes = (int) (balance / 0.10);
                setBalance(balance - (dimes * 0.10));
                sum += (dimes * .10);
            } else if (balance >= 0.05) {
                nickles = (int) (balance / .05);
                setBalance(balance - (nickles * .05));
                sum += (nickles * .05);
            } else
                break;
        }
        System.out.println(System.lineSeparator() + "Quarters: " + quarters + "\n" +
                "Dimes: " + dimes + "\n" +
                "Nickles: " + nickles + "\n" +
                "Total change: $" + BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP) + "\n" +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP));
        Product.log.log("GIVE CHANGE: $" + BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(getBalance()).setScale(2, RoundingMode.HALF_UP));
    }
}
