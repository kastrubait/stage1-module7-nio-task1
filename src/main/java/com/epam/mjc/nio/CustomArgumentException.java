package com.epam.mjc.nio;

import java.io.FileNotFoundException;

public class CustomArgumentException extends Throwable {
    public CustomArgumentException(FileNotFoundException e) {
    }
}
