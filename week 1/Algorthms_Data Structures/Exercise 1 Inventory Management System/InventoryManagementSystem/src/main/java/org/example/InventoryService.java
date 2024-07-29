package org.example;

import java.util.Scanner;

public class InventoryService {

    // Inject the store object
    private Model store = new Model();
    public Product getProductFromUser(){
        Scanner sc= new Scanner(System.in);

        System.out.print("\nEnter the product name: ");
        String name = sc.nextLine();

        System.out.print("\nEnter the product quantity: ");
        int qty = sc.nextInt();

        System.out.print("\nEnter the product price: ");
        float price = sc.nextFloat();

        return new Product(store.productCount()+1,name,qty,price);
    }
}
