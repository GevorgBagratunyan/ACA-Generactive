package storage;


import model.Group;
import model.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Storage {
    private static int groupID = 0;
    private static int itemID = 0;
    private static final Map<Integer, Group> GROUPS = new HashMap<>();
    private static final Map<Integer, Item> ITEMS = new HashMap<>();

    private Storage() {
    }

    public static Group getByID(int id) {
        return GROUPS.get(id);
    }

    public static void addGroup(Group group) {
        GROUPS.put(group.getId(), group);
    }

    public static void addItem(Item item) {
        ITEMS.put(item.getId(), item);
    }

    public static int getNextGroupID() {
        return ++groupID;
    }

    public static int getNextItemID() {
        return ++itemID;
    }


    //Methods below which using Stream API

    public static void printAllGroups() {
        GROUPS.entrySet().stream()
                .forEach(e -> e.getValue().printContent());

    }

    public static void printAllItems() {
        ITEMS.entrySet().stream()
                .forEach(e -> e.getValue().printContent());
    }


    public static Item findItemByName(String name) {
        Optional<Item> item = ITEMS.entrySet().stream()
                .filter(e -> e.getValue().getName().equals(name))
                .map(Map.Entry::getValue)
                .findFirst();

        return item.orElse(null);
    }

    public static Group findGroupByName(String name) {
        Optional<Group> group = GROUPS.entrySet().stream()
                .filter(e -> e.getValue().getName().equals(name))
                .map(Map.Entry::getValue)
                .findFirst();

        return group.orElse(null);
    }

    public static List<Group> findSubGroupsByParent(Group parent) {
        List<Group> subGroups = GROUPS.entrySet().stream()
                .filter(e -> e.getValue().equals(parent))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return subGroups;
    }

    public static List<Item> findHighestPricedItems() {
        double maxPrice = Double.MIN_VALUE;
        for(Map.Entry<Integer, Item> pair: ITEMS.entrySet()){
            if(pair.getValue().getBasePrice()>maxPrice){
                maxPrice=pair.getValue().getBasePrice();
            }
        }
        double finalMaxPrice = maxPrice;
        List<Item> items = ITEMS.entrySet().stream()
                .filter(e->e.getValue().getBasePrice()==finalMaxPrice)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return items;
    }
}
