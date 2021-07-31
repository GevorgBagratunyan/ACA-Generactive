package com.gevorgbagratunyan.generactive.io;

import java.io.*;
import java.util.ArrayList;
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
        List<String> params = new ArrayList<>();
        String line = null;
        while(true){
            try {
                if ((line=br.readLine())==null)
                    break;
            } catch (IOException e) {
                e.getMessage();
            }
            params.add(line);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return params;
    }
}
