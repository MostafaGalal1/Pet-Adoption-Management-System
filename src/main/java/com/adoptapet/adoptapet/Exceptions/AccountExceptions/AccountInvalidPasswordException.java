package com.adoptapet.adoptapet.Exceptions.AccountExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountInvalidPasswordException extends DefaultException {
    public AccountInvalidPasswordException() {
        super("Account password is invalid", HttpStatus.UNAUTHORIZED);
    }
}
