package com.adoptapet.adoptapet.Exceptions.ShelterExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class ShelterNotFoundException extends DefaultException {
    public ShelterNotFoundException(){
        super("Shelter not found", HttpStatus.NOT_FOUND);
    }
}
