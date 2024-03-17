package com.onlineshoppingservice.model;

import com.onlineshoppingservice.enums.ProductCategory;

public class Product {
    private String name;
    private ProductCategory category;
    private Double price;
    private Double discountRate;
    private Integer stock;
    private String description;
    private String imageUrl;

    public Product(String name, ProductCategory category, Double price, Double discountRate, Integer stock, String description, String imageUrl) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
