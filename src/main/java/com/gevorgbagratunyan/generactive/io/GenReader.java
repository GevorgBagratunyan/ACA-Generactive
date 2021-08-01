package com.gevorgbagratunyan.generactive.io;

import com.gevorgbagratunyan.generactive.exception.FileIsEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenReader {
    private BufferedReader br;
    private String filePath;
    private String itemFilePath = "src\\main\\resources\\item.csv";

    public GenReader() {
        this.filePath = this.itemFilePath;
        File file = new File(filePath);
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("file Not found, wrong path");
        }
    }

    public GenReader(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("file Not found, wrong path");
        }
    }

    public List<String> readObject() {
        try {
            String line;
            if((line=br.readLine()).isEmpty()){
                throw new FileIsEmptyException(filePath);
            }
            return Arrays.asList(line.split(","));
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

    public List<String> readAllObjects() {
        List<String> allLines = new ArrayList<>();
        try {
            String fields;
            while((fields= br.readLine())!=null){
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
