package org.example;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Inventorymanager {

    // Inject the InventoryService object
    InventoryService service = new InventoryService();
    Model store = new Model();
    public void manage(){
        System.out.println("Press 1 to add a product\n Press 2 to update a product\n Press 3 to delete a product\n Press 4 to retrieve a product\n");

        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 1:
            {
                Product product = service.getProductFromUser();
                store.addProduct(product);
                break;
            }
            case 2:
            {
                Product product = service.getProductFromUser();
                store.updateProduct(product);
                break;
            }
            case 3:
            {
                System.out.println("Enter the product id you want to delete: ");
                store.deleteProduct(sc.nextInt());
                break;
            }
            case 4:
            {
                System.out.println("Enter the product id you want to check: ");
                Product product = store.getProductById(sc.nextInt());
                System.out.println(product);
                break;
            }
            default:
                System.out.println("Invalid Option!!!");
                break;

        }
    }
}
