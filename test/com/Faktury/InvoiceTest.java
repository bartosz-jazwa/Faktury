package com.Faktury;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InvoiceTest {
    @Test
    public void invoiceXshouldReturnDataPlus14daysFromNow(){
        //given
        InvoiceX invoiceX = new InvoiceX();
        //when
        LocalDate payDate = invoiceX.getPayDate();
        //then
        assertEquals(LocalDate.now().plusDays(14),payDate);
    }

    @Test
    public void invoiceYshouldReturnMay31(){
        //given
        InvoiceY invoiceY = new InvoiceY();
        //when
        LocalDate payDate = invoiceY.getPayDate();
        //then
        assertEquals(LocalDate.of(2021,5,31),payDate);
    }

    @Test
    public void invoiceShouldReturnValueOf9point5(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> products = new HashMap<>();
        products.put(item1,3);
        products.put(item2,1);

        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(products);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceX);
        //when
        Double invoiceValue = Main.calculateIncome(invoices,LocalDate.of(2021,6,30));
        //then
        assertEquals(9.5,invoiceValue);
    }

    @Test
    public void invoiceShouldReturnValueOf9(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> productsOnInvoiceX = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY = new HashMap<>();
        productsOnInvoiceX.put(item1,3);
        productsOnInvoiceX.put(item2,1);

        productsOnInvoiceY.put(item1,1);
        productsOnInvoiceY.put(item2,2);

        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(productsOnInvoiceX);

        InvoiceY invoiceY = new InvoiceY();
        invoiceY.setProducts(productsOnInvoiceY);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceX);
        invoices.add(invoiceY);
        //when
        Double invoiceValue = Main.calculateIncome(invoices,LocalDate.of(2021,6,1));
        //then
        assertEquals(9,invoiceValue);
    }

    @Test
    public void invoiceShouldReturnInvoiceX2(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> productsOnInvoiceX = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceX2 = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY2 = new HashMap<>();
        productsOnInvoiceX.put(item1,1);
        productsOnInvoiceX.put(item2,1);

        productsOnInvoiceX2.put(item1,2);
        productsOnInvoiceX2.put(item2,2);

        productsOnInvoiceY.put(item1,3);
        productsOnInvoiceY.put(item2,3);

        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(productsOnInvoiceX);

        InvoiceX invoiceX2 = new InvoiceX();
        invoiceX2.setProducts(productsOnInvoiceX2);

        InvoiceY invoiceY = new InvoiceY();
        invoiceY.setProducts(productsOnInvoiceY);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceX);
        invoices.add(invoiceX2);
        invoices.add(invoiceY);
        //when
        Invoice newInvoiceTypeX = Main.highestValueInvoice(invoices,InvoiceType.X);
        //then
        assertEquals(invoiceX2,newInvoiceTypeX);
        assertNotEquals(invoiceX,newInvoiceTypeX);
        assertNotEquals(invoiceY,newInvoiceTypeX);
    }

    @Test
    public void invoiceShouldReturnInvoiceY2(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> productsOnInvoiceX = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceX2 = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY2 = new HashMap<>();
        productsOnInvoiceX.put(item1,1);
        productsOnInvoiceX.put(item2,1);

        productsOnInvoiceX2.put(item1,4);
        productsOnInvoiceX2.put(item2,4);

        productsOnInvoiceY2.put(item1,3);
        productsOnInvoiceY2.put(item2,3);

        productsOnInvoiceY.put(item1,2);
        productsOnInvoiceY.put(item2,2);

        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(productsOnInvoiceX);

        InvoiceX invoiceX2 = new InvoiceX();
        invoiceX2.setProducts(productsOnInvoiceX2);

        InvoiceY invoiceY = new InvoiceY();
        invoiceY.setProducts(productsOnInvoiceY);

        InvoiceY invoiceY2 = new InvoiceY();
        invoiceY2.setProducts(productsOnInvoiceY2);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceX);
        invoices.add(invoiceX2);
        invoices.add(invoiceY);
        invoices.add(invoiceY2);
        //when
        Invoice newInvoiceTypeY = Main.highestValueInvoice(invoices,InvoiceType.Y);
        //then
        assertEquals(invoiceY2,newInvoiceTypeY);
        assertNotEquals(invoiceX2,newInvoiceTypeY);
        assertNotEquals(invoiceX,newInvoiceTypeY);
        assertNotEquals(invoiceY,newInvoiceTypeY);
    }

    @Test
    public void invoiceShouldReturnInvoiceX(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> productsOnInvoiceX = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceX2 = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY2 = new HashMap<>();
        productsOnInvoiceX.put(item1,1);
        productsOnInvoiceX.put(item2,1);

        productsOnInvoiceX2.put(item1,4);
        productsOnInvoiceX2.put(item2,4);

        productsOnInvoiceY2.put(item1,3);
        productsOnInvoiceY2.put(item2,3);

        productsOnInvoiceY.put(item1,2);
        productsOnInvoiceY.put(item2,2);

        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(productsOnInvoiceX);

        InvoiceX invoiceX2 = new InvoiceX();
        invoiceX2.setProducts(productsOnInvoiceX2);

        InvoiceY invoiceY = new InvoiceY();
        invoiceY.setProducts(productsOnInvoiceY);

        InvoiceY invoiceY2 = new InvoiceY();
        invoiceY2.setProducts(productsOnInvoiceY2);

        List<Invoice> invoices = new ArrayList<>();
        //invoices.add(invoiceX);
        //invoices.add(invoiceX2);
        //invoices.add(invoiceY);
        //invoices.add(invoiceY2);

        //when
        Invoice newInvoiceTypeX = Main.highestValueInvoice(invoices,InvoiceType.X);
        //then
        assertEquals(invoiceX.getType(),newInvoiceTypeX.getType());

    }

    @Test
    public void invoiceShouldReturnInvoiceY(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> productsOnInvoiceX = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceX2 = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY2 = new HashMap<>();
        productsOnInvoiceX.put(item1,1);
        productsOnInvoiceX.put(item2,1);

        productsOnInvoiceX2.put(item1,4);
        productsOnInvoiceX2.put(item2,4);

        productsOnInvoiceY2.put(item1,3);
        productsOnInvoiceY2.put(item2,3);

        productsOnInvoiceY.put(item1,2);
        productsOnInvoiceY.put(item2,2);

        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(productsOnInvoiceX);

        InvoiceX invoiceX2 = new InvoiceX();
        invoiceX2.setProducts(productsOnInvoiceX2);

        InvoiceY invoiceY = new InvoiceY();
        invoiceY.setProducts(productsOnInvoiceY);

        InvoiceY invoiceY2 = new InvoiceY();
        invoiceY2.setProducts(productsOnInvoiceY2);

        List<Invoice> invoices = new ArrayList<>();
        //invoices.add(invoiceX);
        //invoices.add(invoiceX2);
        //invoices.add(invoiceY);
        //invoices.add(invoiceY2);

        //when
        Invoice newInvoiceTypeY = Main.highestValueInvoice(invoices,InvoiceType.Y);
        //then
        assertEquals(invoiceY.getType(),newInvoiceTypeY.getType());

    }

    @Test
    public void invoiceShouldReturnValueOf61875(){
        //given
        Product item1 = new Product(1,2.0);
        Product item2 = new Product(2,3.5);
        Map<Product,Integer> productsOnInvoiceX = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceX2 = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY = new HashMap<>();
        Map<Product,Integer> productsOnInvoiceY2 = new HashMap<>();
        productsOnInvoiceX.put(item1,1);
        productsOnInvoiceX.put(item2,1);
//5.5 * 1.07 = 5.885
        productsOnInvoiceX2.put(item1,4);
        productsOnInvoiceX2.put(item2,4);
//22.0 * 1.07 = 23.54
        productsOnInvoiceY2.put(item1,3);
        productsOnInvoiceY2.put(item2,3);
//16.5 * 1.18 = 19.47
        productsOnInvoiceY.put(item1,2);
        productsOnInvoiceY.put(item2,2);
//11.0 * 1.18 = 12,98
        InvoiceX invoiceX = new InvoiceX();
        invoiceX.setProducts(productsOnInvoiceX);

        InvoiceX invoiceX2 = new InvoiceX();
        invoiceX2.setProducts(productsOnInvoiceX2);

        InvoiceY invoiceY = new InvoiceY();
        invoiceY.setProducts(productsOnInvoiceY);

        InvoiceY invoiceY2 = new InvoiceY();
        invoiceY2.setProducts(productsOnInvoiceY2);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceX);
        invoices.add(invoiceX2);
        invoices.add(invoiceY);
        invoices.add(invoiceY2);

        //when
        Double valueOfAll = Main.calculateValueOfAll(invoices);
        //then
        assertEquals(61.875d,valueOfAll);

    }
}
