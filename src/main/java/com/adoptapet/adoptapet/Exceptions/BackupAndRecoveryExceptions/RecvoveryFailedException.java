package com.adoptapet.adoptapet.Exceptions.BackupAndRecoveryExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class RecvoveryFailedException extends DefaultException {
    public RecvoveryFailedException() {
        super("Recovery failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
