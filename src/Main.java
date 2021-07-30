import model.*;
import model.enums.Complexity;
import model.enums.Resolution;
import storage.Storage;

import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        Group g1 = new Group.GroupBuilder()
                .id()
                .groupName("Nature")
                .build();

        Group g2 = new Group.GroupBuilder()
                .id()
                .groupName("Forest")
                .parentGroup(g1)
                .build();

        Configuration cfg = new Configuration(Resolution.UHD);

        GenerativeItem gi1 = new GenerativeItem.GenerativeItemBuilder()
                .name("Visual1 in Forest")
                .group(g2)
                .id()
                .price(25.0)
                .complexity(Complexity.TWO)
                .configuration(cfg)
                .build();

        g1.addGroup(g2);
        Storage.addGroup(g1);
        Storage.addGroup(g2);
        Storage.addItem(gi1);
        g2.addItem(gi1);

        Basket basket = new Basket();
        BasketItem basketItem = new BasketItem(gi1, cfg);
        basket.add(basketItem);
        basket.add(basketItem);


        System.out.println("Price of added item : " + basketItem.getPrice());
        System.out.print("Total price of Items in basket : ");
        basket.totalPrice();
        System.out.println();

        //This is for console input flow
        //You can uncomment this part of code below to use console input instead of static initialization
//        ItemCreator.create();


        //Testing Stream API methods in Storage
        Optional<Item> item = Storage.findItemByName("Visual1 in Forest");
        item.ifPresent(e -> System.out.println("Item in Storage found : " + e.getName()));
        Storage.printAllGroups();
        Storage.printAllItems();
        List<Group> subs = Storage.findSubGroupsByParent(g1);
        System.out.println("subgroups in g1 : ");
        subs.stream().forEach(e -> System.out.println(e.getName()));
        List<Item> maxPriceItems = Storage.findHighestPricedItems();
        System.out.println(maxPriceItems);
        System.out.println("Printing highest price items : ");
//        maxPriceItems.stream().forEach(e -> System.out.println(e.getName()));

    }
}
