package com.org.supplier.model;

public class Product {
    private int productId;
    private String productName;
    private int stockQuantity;

    public Product(int productId, String productName, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getStockQuantity() { return stockQuantity; }
}

