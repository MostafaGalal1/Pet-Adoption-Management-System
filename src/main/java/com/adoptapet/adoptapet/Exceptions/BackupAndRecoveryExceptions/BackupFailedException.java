package com.adoptapet.adoptapet.Exceptions.BackupAndRecoveryExceptions;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class BackupFailedException extends DefaultException {
    public BackupFailedException() {
        super("Backup failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
