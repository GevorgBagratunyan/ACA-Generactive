package com.gevorgbagratunyan.generactive.io;

import com.gevorgbagratunyan.generactive.exception.FileIsEmptyException;

import java.io.*;
import java.util.ArrayList;
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
            throw new FileIsEmptyException(filePath, e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
    }

    public List<String> readAllItemFields() {
        List<String> allLines = new ArrayList<>();
        try {
            String fields;
            while((fields=br.readLine())!=null){
                allLines.add(fields);
            }
        } catch (IOException e) {
            throw new FileIsEmptyException(filePath, e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
        return allLines;
    }
}
