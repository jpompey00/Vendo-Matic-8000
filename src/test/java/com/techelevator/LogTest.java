package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {
    protected Log log = new Log();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
    LocalDateTime now = LocalDateTime.now();
    String dateTimeString = now.format(formatter);
    @Test public void testWrite() {
        String testStr = "FEED MONEY:" + " $" + BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(5.00).setScale(2, RoundingMode.HALF_UP);
        assertEquals(dateTimeString + " FEED MONEY: $2.00 $5.00", dateTimeString + " " +  testStr);
    }
    @Test
    void getSalesReport() {
    }

    @Test
    void getLogList() {
    }

    //==tests to run

    //test for get sales report
    //test for log writing to a file that can't be reached

    /*public class Log {
        public static com.techelevator.Log log = new com.techelevator.Log();
        private String logList = ""; // do we need this variable and getLogList()?
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
                        "dd/MM/yyyy hh:mm:ss a");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                // output needed for every time money is fed, every purchase, and final change given
                dataOutput.write(dateTimeString + " " +  message + System.lineSeparator());
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
                    // output product name and remaining stock to file
                    dataOutput.println(product.productArrayList.get(i).getName() + "|" + (5 - product.productArrayList.get(i).getStock()));
                    // need some way to get max stock from Product object instead of hard coding 5
                    totalSales = totalSales.add(BigDecimal.valueOf(product.productArrayList.get(i).getPrice()).setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(5 - product.productArrayList.get(i).getStock())));
                    //System.out.println("TOTAL SALES: " + totalSales);
                }
                // output total sales to file
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
*/
}
