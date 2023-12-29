package com.adoptapet.adoptapet.Exceptions.ImageExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class ImageNotFoundException extends DefaultException {
    public ImageNotFoundException() {
        super("Image not found", HttpStatus.NOT_FOUND);
    }
}
