package com.adoptapet.adoptapet.Exceptions.ShelterExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class ShelterAlreadyExistsException extends DefaultException {
    public ShelterAlreadyExistsException(){
        super("Shelter already exists", HttpStatus.CONFLICT);
    }
}
