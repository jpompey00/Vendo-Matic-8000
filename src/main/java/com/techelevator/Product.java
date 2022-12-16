package com.techelevator;

import com.techelevator.view.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Product {
    private String slotID;
    private Double price;
    private String type;
    private String name;
    private int stock;

    //ArrayList<Product> productQueue = new ArrayList<Product>();


    public Product(String slotID, String name, Double price, String type) {
        this.slotID = slotID;
        this.price = price;
        this.type = type;
        this.name = name;
        this.stock = 5;
    }
    
    //public Product(){}

    public void updateStock() {
        this.stock -= 1;
    }

    public int getStock() {
        return stock;
    }

    public String getSlotID() {
        return slotID;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void setInventory() {
//        File file = new File("vendingmachine.csv");
//        Scanner read = null;
        Product product;
//
//        try {
//            read = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try (BufferedReader br = new BufferedReader(new FileReader("vendingmachine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                product = new Product(split[0], split[1], Double.parseDouble(split[2]), split[3]);
                System.out.println(product.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(product.getName());

//        read.useDelimiter("[|\n]|(\r\n)");
//        while (read.hasNextLine()) {
//            //Product or item class that uses constructor to set values to read values.
//            //Product name = new Product(slotID, name, price, type); ??
//            String slotID = read.next();
//            String name = read.next();
//            Double price = read.nextDouble();
//            String type = read.next();
//            product = new Product(slotID, name, price, type);
//        }
//        read.close();
    }
}
