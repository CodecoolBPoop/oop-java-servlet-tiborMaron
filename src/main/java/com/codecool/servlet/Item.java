package com.codecool.servlet;

class Item {

    private static int ID_counter = 0;

    private int ID;
    private String name;
    private double price;

    Item(String name, double price) {
        this.ID = ID_counter++;
        this.name = name;
        this.price = price;
    }

    int getID() {
        return ID;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }
}
