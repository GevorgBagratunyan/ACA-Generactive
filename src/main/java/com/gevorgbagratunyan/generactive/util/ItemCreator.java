package com.gevorgbagratunyan.generactive.util;


import com.gevorgbagratunyan.generactive.model.*;
import com.gevorgbagratunyan.generactive.model.enums.Complexity;
import com.gevorgbagratunyan.generactive.model.enums.Resolution;
import com.gevorgbagratunyan.generactive.storage.Storage;
import com.gevorgbagratunyan.generactive.model.*;

public class ItemCreator {

    public static void create() {
        while (true) {
            ConsoleManager.readGroup();
            String groupName = ConsoleManager.getGroupName();
            Group parentGroup = ConsoleManager.getParentGroup();

            Group group = new Group.GroupBuilder()
                    .groupName(groupName)
                    .parentGroup(parentGroup)
                    .id()
                    .build();

            if (parentGroup != null) {
                parentGroup.addGroup(group);
            }
            Storage.addGroup(group);

            if (ConsoleManager.getUserCommand().equals("CONTINUE")) {
                ConsoleManager.readItem();
                String itemName = ConsoleManager.getItemName();
                double itemPrice = ConsoleManager.getPrice();
                Resolution resolution = ConsoleManager.getResolution();
                Complexity complexity = ConsoleManager.getComplexity();
                Configuration cfg = new Configuration(resolution);
                Item item;

                if (complexity == null) {
                    item = new StockItem.StockItemBuilder()
                            .id()
                            .name(itemName)
                            .price(itemPrice)
                            .group(group)
                            .configuration(cfg)
                            .build();
                } else {
                    item = new GenerativeItem.GenerativeItemBuilder()
                            .id()
                            .name(itemName)
                            .price(itemPrice)
                            .group(group)
                            .configuration(cfg)
                            .complexity(complexity)
                            .build();
                }

                group.addItem(item);

                if (ConsoleManager.getUserCommand().equals("EXIT")) {
                    break;
                }
            }
        }
    }
}
