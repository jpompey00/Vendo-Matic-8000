package com.techelevator;

public class Candy extends Product implements Vendable{
    public Candy(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        //addition
        System.out.println(super.getName() + " " + super.getPrice()); //format get price
        //
        System.out.println("Munch Munch, Yum!");
        super.updateStock();
    }
}
