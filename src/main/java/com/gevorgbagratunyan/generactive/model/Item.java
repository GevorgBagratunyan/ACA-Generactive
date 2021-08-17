package com.gevorgbagratunyan.generactive.model;

import java.util.Objects;

public abstract class Item {
    private final int id;
    private final String name;
    private final String url;
    private final double basePrice;
    private final Group group;


    public Item(int id, String name, String url, double basePrice, Group group) {
        this.name = name;
        this.url = url;
        this.basePrice = basePrice;
        this.group = group;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Group getGroup() {
        return group;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(name, item.name) &&
                Objects.equals(url, item.url) &&
                Objects.equals(group, item.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }

    public void printContent() {
        System.out.println("    Item group : " + this.group.getName());
        System.out.println("    Item name : " + this.name);
        System.out.println("    Item price : " + this.basePrice);
        System.out.println("    Item ID : " + this.id);
    }

    public abstract double calculatePrice(Configuration configuration);
}
