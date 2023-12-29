package com.adoptapet.adoptapet.Exceptions.ImageExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class ImageAlreadyExistsException extends DefaultException {
    public ImageAlreadyExistsException() {
        super("Image already exists", HttpStatus.CONFLICT);
    }
}
