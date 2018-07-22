package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    private static List<Item> items = new ArrayList<>();

    static List<Item> getItems() {
        return items;
    }

    public static void add(Item item) {
        items.add(item);
    }

    public static void remove(Item item) {

    }

}
