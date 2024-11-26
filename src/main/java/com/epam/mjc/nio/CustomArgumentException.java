package com.epam.mjc.nio;

import java.io.FileNotFoundException;

public class CustomArgumentException extends FileNotFoundException {
    public CustomArgumentException(FileNotFoundException e) {
        super(e.getMessage());
    }
}
