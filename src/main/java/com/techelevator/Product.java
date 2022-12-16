package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String slotID;
    private Double price;
    private String type;
    private String name;
    private int stock;
    ArrayList<Product> productArrayList = new ArrayList<>(){};
    public Product(String slotID, String name, Double price) {
        this.slotID = slotID;
        this.price = price;
        this.name = name;
        this.stock = 5;
    }

    public Product() {

    }

    public void updateStock() {
        this.stock -= 1;
    }

    public int getStock() {
        return stock;
    }
    public String getSlotID(){
        return slotID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void readInFile() {
        File file = new File("vendingmachine.csv");
        Scanner read = null;
        Product product;
        try {
            read = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        read.useDelimiter("[|\n]|(\r\n)");
        while (read.hasNextLine()) {
            //Product or item class that uses constructor to set values to read values.
            this.slotID = read.next();
            this.name = read.next();
            this.price = read.nextDouble();
            switch (read.next()){
                case "Chip":
                    this.productArrayList.add(new Chips(slotID, name, price));
                    break;
                case "Drink":
                    this.productArrayList.add(new Beverages(this.slotID, this.name, this.price));
                    break;
                case "Candy":
                    this.productArrayList.add(new Candy(this.slotID, this.name, this.price));
                    break;
                case "Gum":
                    this.productArrayList.add(new Gum(this.slotID, this.name, this.price));
                    break;
                default:
                    return;
            }
        }
        read.close();
    }

    protected void dispense(String ID) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getSlotID().equalsIgnoreCase(ID)) {


                productArrayList.get(i).dispense(ID); //implemented product name + cost + money remaining
                break;
            }
        }
    }

    protected void comparePriceToBalance(Money money, String ID){
        //if(money.getBalance() >

    }
    protected void calculateNewBalance(Money money, String ID) {

        for (int i = 0; i < productArrayList.size(); i++){
            if (productArrayList.get(i).getSlotID().equalsIgnoreCase(ID)){
                if(money.getBalance() > productArrayList.get(i).getPrice()) {
                    money.setBalance(money.getBalance() - productArrayList.get(i).getPrice());
                    productArrayList.get(i).dispense(ID);
                    break;
                }
                else {
                    System.out.println("Balance not enough for this item.");
                }
            }
        }
    }

    public ArrayList getProductList(){
        return this.productArrayList;
    }
    public void showItems(){
        for(Product i: productArrayList){
            System.out.println(i.slotID + " " + i.name + " " + i.price + " Stock: " + i.stock);
            //format this print better, but it works.
            //implement sold out string when it goes <1
        }

    }


//    public static void setInventory() {
////        File file = new File("vendingmachine.csv");
////        Scanner read = null;
//        Product product;
////
////        try {
////            read = new Scanner(file);
////        } catch (FileNotFoundException e) {
////            throw new RuntimeException(e);
////        }
//
//        try (BufferedReader br = new BufferedReader(new FileReader("vendingmachine.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] split = line.split("\\|");
//                product = new Product(split[0], split[1], Double.parseDouble(split[2]), split[3]);
//                System.out.println(product.getName());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        //System.out.println(product.getName());
//
////        read.useDelimiter("[|\n]|(\r\n)");
////        while (read.hasNextLine()) {
////            //Product or item class that uses constructor to set values to read values.
////            //Product name = new Product(slotID, name, price, type); ??
////            String slotID = read.next();
////            String name = read.next();
////            Double price = read.nextDouble();
////            String type = read.next();
////            product = new Product(slotID, name, price, type);
////        }
////        read.close();
//    }
}
