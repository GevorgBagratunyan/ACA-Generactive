package com.gevorgbagratunyan.generactive.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemFileReader {

    private BufferedReader br;

    public ItemFileReader(String filePath) {
        File file = new File(filePath);
        try {
            FileReader reader = new FileReader(file);
            br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("file Not found, wrong path");
        }
    }

    public List<String> readItemFields() {
        String line =null;
        try {
           line = br.readLine();
        } catch (IOException e) {
            e.getMessage();
        }
        List<String> params = Arrays.asList(line.split(","));
        return params;
    }
}
