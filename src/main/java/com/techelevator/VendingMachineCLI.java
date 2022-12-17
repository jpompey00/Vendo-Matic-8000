package com.techelevator;

import com.techelevator.view.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, "4"};
    private static final String[] PURCHASE_MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_FEED_MONEY, MAIN_MENU_OPTION_SELECT_PRODUCT, MAIN_MENU_OPTION_FINISH_TRANSACTION};
    private Menu menu;
    private Product product = new Product();
    public static Money money = new Money();

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }


    public void run() {
        product.readInFile();


        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                purchase();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                break;
            } else if (choice.equals("4")) {
               Log.log.getSalesReport();
            }
        }
    }


    public void displayItems() { //change this to print out  list of all items in the vending machine and the stock
        //use the product class
        product.showItems(); //fixed so that it shows all the items and the price.




        //DONT TOUCH OLD CODE//
//        try (BufferedReader br = new BufferedReader(new FileReader("vendingmachine.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line + "5");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void selectProduct(){
        displayItems();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an ID: ");
        String userInput = input.nextLine();
        if(product.checkForID(userInput)) { // checks if the ID exists
            if(money.getBalance() > 0) { //added catch for if there's no money inserted.
                product.calculateNewBalance(money, userInput);
                //product.dispense(userInput); //added this to the calculateNewBalance method so it can work in the catch.
            } else {
                System.out.println("No money inserted.");

            }
        } else {
            System.out.println("Please enter valid code");
        }


    }

    public void purchase() {
        label:
        while (true) {
            System.out.println("Current Money Provided: $" + BigDecimal.valueOf(money.getBalance()).setScale(2, RoundingMode.HALF_UP));
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MAIN_MENU_OPTIONS);

            switch (choice) {
                case MAIN_MENU_OPTION_FEED_MONEY:
                    Scanner input = new Scanner(System.in);
                    System.out.println("Insert Bills: ");
                    try {
                        int userInput = input.nextInt();
                        if(userInput>0){
                            money.feedMoney(userInput);
                        }
                        else {
                            System.out.println("Please enter a valid dollar amount.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid dollar amount.");
                    }
                    break;
                case MAIN_MENU_OPTION_SELECT_PRODUCT:
                    selectProduct();
                    break;
                case MAIN_MENU_OPTION_FINISH_TRANSACTION:
                    money.calculateChange();
                    break label;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
