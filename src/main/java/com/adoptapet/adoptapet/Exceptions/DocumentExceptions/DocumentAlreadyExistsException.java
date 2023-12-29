package com.adoptapet.adoptapet.Exceptions.DocumentExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class DocumentAlreadyExistsException extends DefaultException {
    public DocumentAlreadyExistsException() {
        super("Document already exists", HttpStatus.CONFLICT);
    }
}
