package com.Faktury;

public class Product {
    private int productId;
    private Double price;

    public Product(int productId, Double price) {
        this.productId = productId;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
