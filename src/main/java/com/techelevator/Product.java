package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Product {
    private String slotID;
    private Double price;
    private String type;
    private String name;
    private int stock;

    public Product(String slotID, String name, Double price, String type) {
        this.slotID = slotID;
        this.price = price;
        this.type = type;
        this.name = name;
        this.stock = 5;
    }

    public void updateStock() {
        this.stock -= 1;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void readInFile() {
        File file = new File("vendingmachine.csv");
        Scanner read = null;
        Product product;

        /*String line;
        String[] split;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null) {
                split = line.split("\|");
                flightQueue.add(new Flight(split[0], split[1], split[2]));
            }
        } catch(IOException e) {
            flight = new Flight(scheduledTime, eventType, flightID);*/

        try {
            read = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        read.useDelimiter("[|\n]|(\r\n)");
        while (read.hasNextLine()) {
            //Product or item class that uses constructor to set values to read values.
            //Product name = new Product(slotID, name, price, type); ??
            String slotID = read.next();
            String name = read.next();
            Double price = read.nextDouble();
            String type = read.next();
            product = new Product(slotID, name, price, type);
        }
        read.close();
    }
}
