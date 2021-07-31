package com.gevorgbagratunyan.generactive.model;

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

    public void printContent() {
        System.out.println("    Item group : " + this.group.getName());
        System.out.println("    Item name : " + this.name);
        System.out.println("    Item price : " + this.basePrice);
        System.out.println("    Item ID : " + this.id);
    }

    public abstract double calculatePrice(Configuration configuration);
}
