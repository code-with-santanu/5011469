package org.example;

import java.util.HashMap;

public class Model {

    private HashMap<Integer,Product> inventoryStore = new HashMap<>();

    // Method to add a product
    public void addProduct(Product product){
        inventoryStore.put(product.getProductId(),product);
        System.out.println("New product is added");
    }

    // Method to update a product
    public void updateProduct(Product product){
        inventoryStore.put(product.getProductId(),product);
        System.out.println("Product" + product.getProductId()+ "is updated");
    }

    // Method to delete a product
    public void deleteProduct(int id){
        Product temp = inventoryStore.get(id);
        inventoryStore.remove(temp);
        System.out.println("Product" + temp.getProductId()+ "is deleted");
    }

    public Product getProductById(int id){
        return inventoryStore.get(id);
    }

    public int productCount(){
        return inventoryStore.size();
    }
}
