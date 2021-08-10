package com.gevorgbagratunyan.generactive.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.stream.Stream;

public class GenWriter {

    private BufferedWriter bw;

    public GenWriter(String filePath) {
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file);
            bw = new BufferedWriter(writer);
        } catch (IOException e) {
            System.out.println("file Not found, wrong path");
        }
    }

    public <T> void writeObjectFields(T t) {
        Field[] fields = t.getClass().getDeclaredFields();


        Stream.of(fields)
                .forEach(f -> {
                    f.setAccessible(true);

                    Type type = f.getType();
                    if(type.equals(String.class)) {

                    }

                    try {
                        bw.write(f.getName() + ",");
                        bw.write("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
