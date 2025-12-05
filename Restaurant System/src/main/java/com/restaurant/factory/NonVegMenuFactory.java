package com.restaurant.factory;
import com.restaurant.items.*;
import com.restaurant.menu.*;

public class NonVegMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new NonVegetarianMenu();
    }
    @Override public IMenuItem createItem(String type) {
        return switch (type.toLowerCase()) {
            case "pepperoni" -> new PepperoniPizza();
            case "chicken" -> new ChickenBurger();
            default -> throw new IllegalArgumentException("Item not found");
        };
    }
}