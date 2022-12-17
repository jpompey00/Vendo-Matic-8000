package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

public class ProductTest {
    private Product product0;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product;





    @Before
   public void initalize() {
        product = new Product();
         product0 = new Beverages("A0","test0",0d);
         product1 = new Chips("A1", "test1", 10d);
         product2 = new Gum("A2", "test2", 20d);
         product3 = new Beverages("A3", "test3", 30d);
        product.productArrayList.add(product0);
        product.productArrayList.add(product1);
        product.productArrayList.add(product2);
        product.productArrayList.add(product3);
    }
    //=====what to test for======

    //test if ID is null
    //test if ID is not in the arraylist
    //test if ID is in the arraylist

    //test if object is sold out (stock <=0)
    //test if object is in stock (>=1)
    //test if stock is null
    //test if balance is calculating correctly

    //test if items are showing correctly





    @Test
    public void id_is_not_in_the_arraylist(){
        product.checkForID("A4");

        assertEquals("ID not located in arraylist.", true, false);
    }
    @Test
    public void id_is_null(){
        product.checkForID(null);

        assertEquals("Test failed, id is Null", true || false, null);
    }

    @Test
    public void id_is_in_arraylist(){
        product.checkForID("A1");


    }



}
