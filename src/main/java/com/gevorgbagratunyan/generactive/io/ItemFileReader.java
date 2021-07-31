package com.gevorgbagratunyan.generactive.io;

import java.io.*;
import java.util.Arrays;
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

    public List<String> readItemFields() throws NullPointerException{
        String line =null;
        try {
           line = br.readLine();
        } catch (IOException e) {
            e.getMessage();
        }
        return Arrays.asList(line.split(","));
    }
}
