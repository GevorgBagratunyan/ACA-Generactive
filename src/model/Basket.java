package model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public double totalPrice() {
        double total = 0.0;
        for (Item item : items) {
            total += item.calculatePrice();
        }
        System.out.println(total);
        return total;
    }

    public void calculatePrice(Item item) {
        if (item instanceof StockItem) {
            System.out.println(item.calculatePrice());
        } else {
            System.out.println(item.calculatePrice());
        }
    }

    public void addToBasket(Item item) {
        items.add(item);
    }

}
