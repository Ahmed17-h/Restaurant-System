// src/main/java/com/restaurant/menu/VegetarianMenu.java
package com.restaurant.menu;

import com.restaurant.items.*;
import java.util.Arrays;
import java.util.List;

public class VegetarianMenu implements IMenu {
    private final List<IMenuItem> items = Arrays.asList(
        new MargheritaPizza(),
        new VeggieBurger()
        
    );

    @Override
    public List<IMenuItem> getItems() {
        return items;
    }

    @Override
    public void display() {
        System.out.println("=== Vegetarian Menu ===");
        for (int i = 0; i < items.size(); i++) {
            IMenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getDescription() + " - EGP " + item.getPrice());
        }
        System.out.println();
    }
}