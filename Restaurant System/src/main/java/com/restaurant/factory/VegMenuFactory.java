package com.restaurant.factory;

import com.restaurant.items.*;
import com.restaurant.menu.IMenu;
import com.restaurant.menu.VegetarianMenu;

public class VegMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new VegetarianMenu();
    }

    @Override
    public IMenuItem createItem(String type) {
        return switch (type.toLowerCase()) {
            case "margherita" -> new MargheritaPizza();
            case "veggie"     -> new VeggieBurger();
            default -> throw new IllegalArgumentException("Unknown veg item: " + type);
        };
    }
}