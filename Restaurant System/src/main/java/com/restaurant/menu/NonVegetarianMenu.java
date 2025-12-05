package com.restaurant.menu;

import com.restaurant.items.*;
import java.util.Arrays;
import java.util.List;

public class NonVegetarianMenu implements IMenu {
    private final List<IMenuItem> items = Arrays.asList(
        new PepperoniPizza(),
        new ChickenBurger()
    );

    @Override
    public List<IMenuItem> getItems() {
        return items;
    }

    @Override
    public void display() {
        System.out.println("=== Non-Vegetarian Menu ===");
        for (int i = 0; i < items.size(); i++) {
            IMenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getDescription() + " - EGP " + item.getPrice());
        }
        System.out.println();
    }
}