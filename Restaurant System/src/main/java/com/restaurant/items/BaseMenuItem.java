package com.restaurant.items;

public abstract class BaseMenuItem implements IMenuItem {
    protected String name;
    protected double price;
    protected String category;

    public BaseMenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
    @Override public String getCategory() { return category; }
    @Override public String getDescription() { return name; }
}