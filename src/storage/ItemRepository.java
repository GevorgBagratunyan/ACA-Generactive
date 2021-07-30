package storage;

import model.Item;

import java.util.List;
import java.util.Optional;

public class ItemRepository implements CRUD<Item>{

    @Override
    public Item create(Item item) {
        return Storage.addItem(item);
    }

    @Override
    public Optional<Item> read(int id) {
        return Storage.findItemById(id);
    }

    //This will be implemented soon
    @Override
    public Item update(int ID) {
        return null;
    }

    @Override
    public Item delete(int id) {
        return Storage.removeById(id);
    }

    public static void printAllItems() {
        Storage.printAllItems();
    }

    public static Optional<Item> getByName(String name) {
        return Storage.findItemByName(name);
    }

    public static List<Item> getHighestPricedItems() {
        return Storage.findHighestPricedItems();
    }


}
