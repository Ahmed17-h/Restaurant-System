package com.restaurant.addons;

import com.restaurant.items.IMenuItem;

public class ExtraSauce extends AddonDecorator {
    public ExtraSauce(IMenuItem item) {
        super(item);
    }
    @Override protected double getAddonPrice() { return 10.0; }
    @Override protected String getAddonName() { return "Extra Sauce"; }
}