package com.adoptapet.adoptapet.Exceptions.StaffExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class StaffAlreadyExistsException extends DefaultException {
    public StaffAlreadyExistsException(){
        super("Staff already exists", HttpStatus.CONFLICT);
    }
}
