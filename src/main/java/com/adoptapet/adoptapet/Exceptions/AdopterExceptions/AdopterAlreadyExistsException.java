package com.adoptapet.adoptapet.Exceptions.AdopterExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AdopterAlreadyExistsException extends DefaultException {
    public AdopterAlreadyExistsException(){
        super("Adopter already exists", HttpStatus.CONFLICT);
    }
}
