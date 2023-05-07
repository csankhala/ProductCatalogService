package com.github.csankhala.ecommerce.service;

import com.github.csankhala.ecommerce.entity.Product;
import jakarta.inject.Singleton;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ProductService {

    private final Map<Long, Product> productMap = new HashMap<>();

    public Product add(Product product) {
        this.productMap.put(product.getId(), product);
        return product;
    }

    public Product get(long id) {
        return this.productMap.get(id);
    }

    public void delete(long id) {
        this.productMap.remove(id);
    }

    public Collection<Product> getAll() {
        return this.productMap.values();
    }

    public void clear() {
        this.productMap.clear();
    }
}
