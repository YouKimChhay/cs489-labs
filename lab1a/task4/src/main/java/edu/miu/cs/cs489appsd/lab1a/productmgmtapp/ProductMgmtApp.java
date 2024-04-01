package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProductMgmtApp {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        ));

        printProducts(products);
    }

    public static void printProducts(List<Product> products) {
        //sort the list
        products.sort(Comparator.comparingLong(Product::getProductId));

        System.out.println("Printed in JSON Format");
        System.out.println('[');
        products.forEach(product -> System.out.println("  " + product.toJson()));
        System.out.println(']');

        System.out.println("---------------------------------");

        System.out.println("Printed in XML Format");
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        products.forEach(product -> System.out.println("  " + product.toXml()));
        System.out.println("</products>");

        System.out.println("---------------------------------");

        System.out.println("Printed in Comma-Separated Value (CSV) Format");
        products.forEach(product -> System.out.println(product.toCsv()));
    }

}
