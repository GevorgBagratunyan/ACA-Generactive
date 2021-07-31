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
        try {
            return Arrays.asList(br.readLine().split(","));
        } catch (IOException e) {
            throw new RuntimeException("File reading problem");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
    }
}
