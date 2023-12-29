package com.adoptapet.adoptapet.Exceptions.AccountExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends DefaultException {
    public AccountNotFoundException(){
        super("Account not found", HttpStatus.NOT_FOUND);
    }
}
