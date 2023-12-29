package com.adoptapet.adoptapet.Exceptions.AdminExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AdminNotFoundException extends DefaultException {
    public AdminNotFoundException(){
        super("Admin not found", HttpStatus.NOT_FOUND);
    }
}
