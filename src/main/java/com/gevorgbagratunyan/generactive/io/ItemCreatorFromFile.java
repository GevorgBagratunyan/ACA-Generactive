package com.gevorgbagratunyan.generactive.io;

import com.gevorgbagratunyan.generactive.model.Item;
import com.gevorgbagratunyan.generactive.model.StockItem;
import com.gevorgbagratunyan.generactive.storage.Storage;

import java.util.List;

public class ItemCreatorFromFile {

    private ItemFileReader reader;

    public ItemCreatorFromFile(String filePath) {
        this.reader = new ItemFileReader(filePath);
    }

    public Item create() {
        List<String> params = reader.readItemFields();
        return new StockItem.StockItemBuilder()
                .id()
                .price(Double.parseDouble(params.get(1)))
                .name(params.get(2))
                .url(params.get(3))
                .group(Storage.findGroupByID(Integer.parseInt(params.get(4))).get())
                .build();
    }
}
