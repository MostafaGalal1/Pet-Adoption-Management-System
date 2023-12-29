package com.adoptapet.adoptapet.Exceptions.StaffExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class StaffNotFoundException extends DefaultException {
    public StaffNotFoundException(){
        super("Staff not found", HttpStatus.NOT_FOUND);
    }
}
