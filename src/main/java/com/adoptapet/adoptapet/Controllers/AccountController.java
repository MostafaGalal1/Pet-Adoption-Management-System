package com.adoptapet.adoptapet.Controllers;


import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> getAllAccounts() {
        System.out.println("getAllAccounts");
        return new ResponseEntity<>("getAllAccounts", HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<String> getAccount(@PathVariable int accountId) {
        System.out.println("getAccount");
        return new ResponseEntity<>("getAccount", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody SignUpDto signUpDto) {
        System.out.println("addAccount");
        return new ResponseEntity<>("addAccount", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody SignUpDto signUpDto) {
        System.out.println("updateAccount");
        return new ResponseEntity<>("updateAccount", HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountId) {
        System.out.println("deleteAccount");
        return new ResponseEntity<>("deleteAccount", HttpStatus.OK);
    }

//    @GetMapping("test")
//    public ResponseEntity<String> test() {
//        System.out.println("test");
//        return new ResponseEntity<>("test", HttpStatus.OK);
//    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpDto signUpDto) {
        System.out.println("signup");
        return accountService.signup(signUpDto);
    }

    @GetMapping("login")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password) {
        System.out.println("login");
        return accountService.login(email, password);
    }
}
