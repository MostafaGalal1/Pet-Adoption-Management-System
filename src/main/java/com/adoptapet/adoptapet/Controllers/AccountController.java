package com.adoptapet.adoptapet.Controllers;


import com.adoptapet.adoptapet.Dtos.AccountDto;
import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account/")
@CrossOrigin("http://localhost:8080")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("test")
    public void test() {
        System.out.println("try");
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpDto signUpDto) {
        System.out.println("test");
        return accountService.signup(signUpDto);
    }

    @GetMapping("login")
    public ResponseEntity<Object> login(@RequestParam String email ,@RequestParam String password) {
        return accountService.login(email, password);
    }
}
