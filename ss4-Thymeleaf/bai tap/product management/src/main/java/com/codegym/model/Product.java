package com.codegym.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Product {
    private int id;
    private String productName;
    private double productPrice;
    private double productQuantity;

    public Product() {
    }

    public Product(int id, String productName, double productPrice, double productQuantity) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }
}
