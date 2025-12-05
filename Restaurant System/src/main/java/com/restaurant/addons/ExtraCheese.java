package com.restaurant.addons;

import com.restaurant.items.IMenuItem;

public class ExtraCheese extends AddonDecorator {
    public ExtraCheese(IMenuItem item) {
        super(item);
    }
    @Override protected double getAddonPrice() { return 15.0; }
    @Override protected String getAddonName() { return "Extra Cheese"; }
}