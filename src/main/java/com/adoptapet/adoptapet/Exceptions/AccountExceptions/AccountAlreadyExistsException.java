package com.adoptapet.adoptapet.Exceptions.AccountExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountAlreadyExistsException extends DefaultException {
    public AccountAlreadyExistsException(){
        super("Account already exists", HttpStatus.CONFLICT);
    }
}
