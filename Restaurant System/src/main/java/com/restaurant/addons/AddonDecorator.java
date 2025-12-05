package com.restaurant.addons;

import com.restaurant.items.IMenuItem;

public abstract class AddonDecorator implements IMenuItem {
    protected IMenuItem wrappedItem;

    public AddonDecorator(IMenuItem item) {
        this.wrappedItem = item;
    }

    @Override public String getName() { return wrappedItem.getName(); }
    @Override public double getPrice() { return wrappedItem.getPrice() + getAddonPrice(); }
    @Override public String getCategory() { return wrappedItem.getCategory(); }
    @Override public String getDescription() { return wrappedItem.getDescription() + " + " + getAddonName(); }

    protected abstract double getAddonPrice();
    protected abstract String getAddonName();
}