package com.adoptapet.adoptapet.Exceptions.DocumentExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class DocumentNotFoundException extends DefaultException {
    public DocumentNotFoundException() {
        super("Document not found", HttpStatus.NOT_FOUND);
    }
}
