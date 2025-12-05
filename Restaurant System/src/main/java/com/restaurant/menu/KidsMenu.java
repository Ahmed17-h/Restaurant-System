package com.restaurant.menu;

import com.restaurant.items.*;
import java.util.List;
import java.util.Arrays;

public class KidsMenu implements IMenu {

    private final List<IMenuItem> items = Arrays.asList(
        new KidsMeal("Chicken Nuggets", 60.0),
        new KidsMeal("Kids Mini Burger", 55.0),
        new KidsMeal("Kids Cheese Pizza", 65.0),
        new KidsMeal("Kids Spaghetti", 50.0)
    );

    @Override
    public List<IMenuItem> getItems() {
        return items;
    }

    @Override
    public void display() {
        System.out.println("=== Kids Menu ===");
        for (int i = 0; i < items.size(); i++) {
            IMenuItem item = items.get(i);
            System.out.printf("%d. %s - EGP %.1f%n", (i + 1), item.getName(), item.getPrice());
        }
        System.out.println();
    }
}