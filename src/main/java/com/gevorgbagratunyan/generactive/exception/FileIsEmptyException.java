package com.gevorgbagratunyan.generactive.exception;

public class FileIsEmptyException extends RuntimeException {

    private String path;

    public FileIsEmptyException() {
        super("File is empty");
    }

    public FileIsEmptyException(String filePath) {
        super(String.format("File in path :  {%s}  - Is Empty", filePath));
        this.path = filePath;
    }
}
