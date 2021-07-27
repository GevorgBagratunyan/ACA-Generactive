import generactive.model.Basket;
import generactive.model.Configuration;
import generactive.model.GenerativeItem;
import generactive.model.Group;
import generactive.model.enums.Complexity;
import generactive.model.enums.Resolution;
import generactive.storage.Storage;


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
        basket.addToBasket(gi1);
        basket.addToBasket(gi1);

        System.out.print("Final price of gi1 Item is : ");
        basket.calculatePrice(gi1);

        System.out.print("Total price of Items in basket : ");
        basket.totalPrice();

        //This is for console input flow
        //You can uncomment this part of code below to use console input instead of static initialization
//        ItemCreator.create();

        Storage.printAllGroups();
        Storage.printAllItems();
    }
}
