package org.example;

import org.example.sorting.BubbleSortOrders;
import org.example.sorting.QuickSortOrders;
import org.example.sorting.SortOrders;

public class Main {
    public static void main(String[] args) {
        Order[] orders = new Order[5];

        initializeOrders(orders);
        System.out.println("\n*************USING BUBBLE SORT****************\n");

        System.out.println("orders before sorting");
        for(Order order: orders)
            System.out.println(order);

        SortOrders sortOrders = new BubbleSortOrders();

        System.out.println("orders after sorting");
        sortOrders.sortOrdersByTotalPrice(orders);
        for(Order order: orders)
            System.out.println(order);


        initializeOrders(orders);
        System.out.println("\n*************USING QUICK SORT****************\n");

        System.out.println("orders before sorting");
        for(Order order: orders)
            System.out.println(order);

        sortOrders = new BubbleSortOrders();

        System.out.println("orders after sorting");
        sortOrders.sortOrdersByTotalPrice(orders);
        for(Order order: orders)
            System.out.println(order);
    }

    private static void initializeOrders(Order orders[]){
        orders[0] = new Order(1,"Rakesh Ghosh",10000);
        orders[1] = new Order(2,"S Pal",25000);
        orders[2] = new Order(3,"Anant seth",10500);
        orders[3] = new Order(4,"Akash Chopra",55000);
        orders[4] = new Order(5,"Nitin Sen",10500.50);
    }
}