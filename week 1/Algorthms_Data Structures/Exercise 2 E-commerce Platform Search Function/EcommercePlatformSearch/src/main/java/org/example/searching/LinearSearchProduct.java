package org.example.searching;

import org.example.Model.Product;
import org.example.Model.Store;

public class LinearSearchProduct implements SearchProduct {

    public Product[] products = new Store().productStore;

    @Override
    public Product searchByProductId(int id) {

        for(int i=0;i<products.length;i++){
            if(products[i].getProductId()==id) return products[i];
        }
        return null;
    }

    @Override
    public Product searchByProductName(String name) {
        for(int i=0;i<products.length;i++){
            if(products[i].getProductName()==name) return products[i];
        }
        return null;
    }

    @Override
    public Product searchByProductCategory(String category) {
        for(int i=0;i<products.length;i++){
            if(products[i].getCategory()==category) return products[i];
        }
        return null;
    }
}
