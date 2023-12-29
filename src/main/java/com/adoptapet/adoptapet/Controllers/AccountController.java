package com.adoptapet.adoptapet.Controllers;


import com.adoptapet.adoptapet.Dtos.AccountDto;
import com.adoptapet.adoptapet.Services.EntityServices.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// use this link to trace endpoints: http://localhost:8080/swagger-ui.html

@RestController
@RequestMapping("/accounts")
// why cross-origin 3000?
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int accountId) {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }

    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody AccountDto accountDto) {
        accountService.addAccount(accountDto);
        return ResponseEntity.ok("Account added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody AccountDto accountDto) {
        accountService.updateAccount(accountDto);
        return ResponseEntity.ok("Account updated successfully");
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account deleted successfully");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AccountDto accountDto) {
        accountService.register(accountDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountDto accountDto) {
        accountService.login(accountDto);
        return ResponseEntity.ok("User logged in successfully");
    }
}