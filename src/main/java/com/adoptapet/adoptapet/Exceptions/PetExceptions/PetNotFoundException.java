package com.adoptapet.adoptapet.Exceptions.PetExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class PetNotFoundException extends DefaultException {
    public PetNotFoundException(){
        super("Pet not found", HttpStatus.NOT_FOUND);
    }
}
