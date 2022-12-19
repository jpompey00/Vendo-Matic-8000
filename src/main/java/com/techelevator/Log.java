package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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
        try (FileWriter dataOutput = new FileWriter("Log.txt", true)) {
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
                = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        try (PrintWriter dataOutput = new PrintWriter(new File(dateTimeString + "-Sales-Report.txt"))) {

            //LocalDateTime datetime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            System.out.println(System.lineSeparator() + "Sales Report file created.");

            //System.out.println(product.arrayList());

            BigDecimal totalSales = new BigDecimal("0.00");

            for (int i = 0; i < product.arrayList().size(); i++) {
                dataOutput.println(product.productArrayList.get(i).getName() + "|" + (5 - product.productArrayList.get(i).getStock()));
                //System.out.println(">" + product.productArrayList.get(i).getName() + "|" + (5 - product.productArrayList.get(i).getStock()) + "\n");
                totalSales = totalSales.add(BigDecimal.valueOf(product.productArrayList.get(i).getPrice()).setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(5 - product.productArrayList.get(i).getStock())));
                //System.out.println("TOTAL SALES: " + totalSales);
            }
            dataOutput.println(System.lineSeparator() + "TOTAL SALES: " + totalSales);
            //System.out.println(product.productArrayList);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }

    public String getLogList() {
        return logList;
    }
}
