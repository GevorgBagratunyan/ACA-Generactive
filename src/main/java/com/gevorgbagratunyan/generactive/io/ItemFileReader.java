package com.gevorgbagratunyan.generactive.io;

import com.gevorgbagratunyan.generactive.exception.FileIsEmptyException;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ItemFileReader {

    private BufferedReader br;
    private final String filePath = "src\\main\\resources\\item.csv";

    public ItemFileReader() {
        File file = new File(filePath);
        try {
            FileReader reader = new FileReader(file);
            br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("file Not found, wrong path");
        }
    }

    public List<String> readItemFields() {
        try {
            return Arrays.asList(br.readLine().split(","));
        } catch (IOException e) {
            throw new FileIsEmptyException(filePath);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
    }
}
