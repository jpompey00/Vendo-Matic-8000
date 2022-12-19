package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Candy extends Product implements Vendable {
    public Candy(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        //addition
        System.out.println(super.getName() + " " + " $" +
                BigDecimal.valueOf(super.getPrice()).setScale(2, RoundingMode.HALF_UP)); //format get price

        System.out.println("Munch Munch, Yum!");
        super.update();
    }
}
