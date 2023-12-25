package com.adoptapet.adoptapet.Controllers;


import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account/")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("test")
    public ResponseEntity<String> test() {
        System.out.println("test");
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

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
