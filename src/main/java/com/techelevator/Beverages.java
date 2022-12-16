package com.techelevator;

public class Beverages extends Product implements Vendable{
    public Beverages(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        //addition
        System.out.println(super.getName() + " " + super.getPrice()); //format get price
        //


        System.out.println("Glug Glug, Yum!");


        //add money remaining.

        super.updateStock();
    }
}
