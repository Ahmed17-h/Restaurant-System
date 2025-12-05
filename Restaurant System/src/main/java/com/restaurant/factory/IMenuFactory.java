package com.restaurant.factory;
import com.restaurant.items.IMenuItem;
import com.restaurant.menu.IMenu;

public interface IMenuFactory {
    IMenu createMenu();
    IMenuItem createItem(String type);
}
