package com.techelevator;

public class Chips extends Product implements Vendable{
    public Chips(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        //addition
        System.out.println(super.getName() + " " + super.getPrice()); //format get price
        //
        System.out.println("Crunch Crunch, Yum!");
        super.updateStock();
    }
}
