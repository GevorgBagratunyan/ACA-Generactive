package storage;

import model.Item;

import java.util.List;
import java.util.Optional;

public class ItemRepository implements CRUD<Item> {

    @Override
    public Item create(Item item) {
        return Storage.addItem(item);
    }

    @Override
    public Optional<Item> read(int id) {
        return Storage.findItemById(id);
    }

    //This will be implemented soon, after realizing REST requests
    @Override
    public Item update(int ID) {
        return null;
    }

    @Override
    public Item delete(int id) {
        return Storage.removeItemById(id);
    }

    public static void printAll() {
        Storage.printAllItems();
    }

    public static Optional<Item> getByName(String name) {
        return Storage.findItemByName(name);
    }

    public static List<Item> getHighestPricedItems() {
        return Storage.findHighestPricedItems();
    }
}
