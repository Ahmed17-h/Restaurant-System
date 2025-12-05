package com.restaurant.menu;

import com.restaurant.items.IMenuItem;
import java.util.List;

public interface IMenu {
    List<IMenuItem> getItems();
    void display();
}