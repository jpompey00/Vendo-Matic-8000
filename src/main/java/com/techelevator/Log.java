package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Log {
    public static Log log = new Log();
    private String logList = "";
    private Product product = new Product();
    public Log(){

    }

    //record feed money
    //record when giving change
    //record item bought



    public void log(String message) {
        try (FileWriter dataOutput = new FileWriter("log.txt", true)) {
            DateTimeFormatter formatter
                    = DateTimeFormatter.ofPattern(
                    "dd/MM/yyyy HH:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            String dateTimeString = now.format(formatter);
            // output needed for every time money is fed, every purchase, and final change given
            dataOutput.write(dateTimeString + " " +  message + "\n");
            System.out.println(dateTimeString + " " +  message);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSalesReport(Product product) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                "ddMMyyyy HHmmss a");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        try (PrintWriter dataOutput = new PrintWriter(new File(dateTimeString + ".txt"))) {

            System.out.println(product.arrayList());

            for (int i = 0; i < product.arrayList().size(); i++) {
                dataOutput.println(">"+ product.productArrayList.get(i).getName() + "|" + (5 - product.productArrayList.get(i).getStock()) + "\n");
               // System.out.println(">" + product.productArrayList.get(i).getName() + "|" + (5 - product.productArrayList.get(i).getStock()) + "\n");
            }
            System.out.println(product.productArrayList);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");}
    }

    public String getLogList() {
        return logList;
    }
}
