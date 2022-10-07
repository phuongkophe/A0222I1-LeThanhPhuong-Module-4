package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("productService")
public class ProductService implements IProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Laptop", 20000000, 10));
        productMap.put(2, new Product(2, "Mouse pad", 300000, 12));
        productMap.put(3, new Product(3, "Phone", 25000000, 19));
        productMap.put(4, new Product(4, "Headphone", 1000000, 11));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        Map<Integer, Product> productMap1 = new HashMap<>();
        for (Product product : productMap.values()) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                productMap1.put(product.getId(), product);
            }
        }
        return new ArrayList<>(productMap1.values());
    }
}
