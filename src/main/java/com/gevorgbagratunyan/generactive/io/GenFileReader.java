package com.gevorgbagratunyan.generactive.io;

import com.gevorgbagratunyan.generactive.exception.FileIsEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenFileReader {

    private BufferedReader reader;
    private final String filePath;

    public GenFileReader(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        try {
            FileReader fr = new FileReader(file);
            reader = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("file Not found, wrong path");
        }
    }

    public List<String> readObject() {
        try {
            return Arrays.asList(reader.readLine().split(","));
        } catch (IOException e) {
            throw new FileIsEmptyException(filePath, e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
    }

    public List<String> readAllObjects() {
        List<String> allLines = new ArrayList<>();
        try {
            String fields;
            while((fields=reader.readLine())!=null){
                allLines.add(fields);
            }
        } catch (IOException e) {
            throw new FileIsEmptyException(filePath, e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
        return allLines;
    }
}
