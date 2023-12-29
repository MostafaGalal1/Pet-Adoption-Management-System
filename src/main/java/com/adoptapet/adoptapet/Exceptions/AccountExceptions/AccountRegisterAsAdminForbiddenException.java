package com.adoptapet.adoptapet.Exceptions.AccountExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountRegisterAsAdminForbiddenException extends DefaultException {
    public AccountRegisterAsAdminForbiddenException(){
        super("Account register as admin forbidden", HttpStatus.FORBIDDEN);
    }
}
