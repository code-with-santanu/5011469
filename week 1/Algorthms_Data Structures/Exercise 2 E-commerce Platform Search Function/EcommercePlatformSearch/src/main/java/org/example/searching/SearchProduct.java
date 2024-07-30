package org.example.searching;

import org.example.Model.Product;

public interface SearchProduct {

    public Product searchByProductId(int id);

    public Product searchByProductName(String name);

    public Product searchByProductCategory(String category);
}
