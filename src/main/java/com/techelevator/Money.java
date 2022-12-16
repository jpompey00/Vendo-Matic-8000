package com.techelevator;

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
        System.out.println("Quarters: " + quarters + "\n" +
                "Dimes: " + dimes + "\n" +
                "Nickles: " + nickles + "\n" +
                "Total change: " + sum + "\n" +
                "Balance: " + (int) this.balance);
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickles() {
        return nickles;
    }

    public void setNickles(int nickles) {
        this.nickles = nickles;
    }

}
