package com.adoptapet.adoptapet.Exceptions.PetExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class PetAlreadyExistsException extends DefaultException {
    public PetAlreadyExistsException(){
        super("Pet already exists", HttpStatus.CONFLICT);
    }
}
