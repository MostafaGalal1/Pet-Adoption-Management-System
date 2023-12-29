package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Services.BackupAndRecoveryServices.BackupAndRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backupAndRecovery")
public class BackupAndRecoveryController {
    private final BackupAndRecovery backupAndRecovery;

    @Autowired
    public BackupAndRecoveryController(BackupAndRecovery backupAndRecovery) {
        this.backupAndRecovery = backupAndRecovery;
    }

    @GetMapping("/backup")
    public ResponseEntity<String> backup() {
        backupAndRecovery.backup();
        return ResponseEntity.ok("Backup successful");
    }

    @GetMapping("/recover")
    public ResponseEntity<String> recover() {
        backupAndRecovery.recover();
        return ResponseEntity.ok("Recovery successful");
    }
}
