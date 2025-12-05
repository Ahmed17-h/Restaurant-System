package com.restaurant.factory;

import com.restaurant.items.*;
import com.restaurant.menu.IMenu;
import com.restaurant.menu.KidsMenu;

public class KidsMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new KidsMenu();
    }

    @Override
    public IMenuItem createItem(String type) {
        return switch (type.toLowerCase()) {
            case "nuggets" -> new KidsNuggets();
            case "burger"  -> new KidsBurger();
            case "pizza"   -> new KidsPizza();
            case "pasta"   -> new KidsPasta();
            default -> throw new IllegalArgumentException("Unknown kids item: " + type);
        };
    }
}