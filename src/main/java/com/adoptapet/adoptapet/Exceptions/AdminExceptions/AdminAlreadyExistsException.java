package com.adoptapet.adoptapet.Exceptions.AdminExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AdminAlreadyExistsException extends DefaultException {
    public AdminAlreadyExistsException(){
        super("Admin already exists", HttpStatus.CONFLICT);
    }
}
