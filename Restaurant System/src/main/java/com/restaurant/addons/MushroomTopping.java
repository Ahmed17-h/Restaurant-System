package com.restaurant.addons;

import com.restaurant.items.IMenuItem;

public class MushroomTopping extends AddonDecorator {
    public MushroomTopping(IMenuItem item) {
        super(item);
    }

    @Override
    protected double getAddonPrice() {
        return 20.0;
    }

    @Override
    protected String getAddonName() {
        return "Mushroom Topping";
    }
}