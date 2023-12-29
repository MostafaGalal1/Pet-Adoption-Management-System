package com.adoptapet.adoptapet.Exceptions.AdopterExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AdopterNotFoundException extends DefaultException {
    public AdopterNotFoundException(){
        super("Adopter not found", HttpStatus.NOT_FOUND);
    }
}
