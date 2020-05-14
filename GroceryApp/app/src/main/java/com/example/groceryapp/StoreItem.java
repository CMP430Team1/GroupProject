package com.example.groceryapp;

public class StoreItem {
    private String name;
    private double price;
    private String category;
    private String Description;

    public StoreItem(){

    }

    public StoreItem(String name, double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
