package com.gevorgbagratunyan.generactive.io;

import com.gevorgbagratunyan.generactive.model.Item;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ItemFileWriter {

    private BufferedWriter bw;

    public ItemFileWriter(String filePath) {
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file);
            bw = new BufferedWriter(writer);
        } catch (IOException e) {
            System.out.println("file Not found, wrong path");
        }

    }

    public void writeItemFields(Item item) {
        String id = String.valueOf(item.getId());
        String base_price = String.valueOf(item.getBasePrice());
        String name = item.getName();
        String image_url = item.getUrl();
        String group_id = String.valueOf(item.getGroup().getId());

        try {
            bw.write(id);
            bw.write(",");
            bw.write(base_price);
            bw.write(",");
            bw.write(name);
            bw.write(",");
            bw.write(image_url);
            bw.write(",");
            bw.write(group_id);
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
