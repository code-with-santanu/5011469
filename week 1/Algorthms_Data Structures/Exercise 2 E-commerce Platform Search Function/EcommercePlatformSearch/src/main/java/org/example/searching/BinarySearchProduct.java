package org.example.searching;

import org.example.Model.Product;
import org.example.Model.Store;

public class BinarySearchProduct{

    public Product[] products = new Store().productStore;

    public Product searchByProductId(int id) {
        return binarySearch(products,0,products.length-1,id);
    }

    private Product binarySearch(Product[] p,int s,int e,int target){
        int mid = (s+e)/2;

        if(p[mid].getProductId()==target)
            return p[mid];
        else if(p[mid].getProductId()>target){
            return binarySearch(p,s,mid-1,target);
        }
        else {
            return binarySearch(p,mid+1,e,target);
        }
    }
}
