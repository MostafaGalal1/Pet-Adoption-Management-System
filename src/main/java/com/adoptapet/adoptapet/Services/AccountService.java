package com.adoptapet.adoptapet.Services;


import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Account.Role;
import com.adoptapet.adoptapet.Repositories.AccountRepository;
import com.adoptapet.adoptapet.Repositories.AdminRepository;
import com.adoptapet.adoptapet.Repositories.AdopterRepository;
import com.adoptapet.adoptapet.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final StaffRepository staffRepository;
    private final AdminRepository adminRepository;
    private final AdopterRepository adopterRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, StaffRepository staffRepository, AdopterRepository adopterRepository, AdminRepository adminRepository) {
        this.accountRepository = accountRepository;
        this.encoder = new BCryptPasswordEncoder();
        this.staffRepository = staffRepository;
        this.adopterRepository = adopterRepository;
        this.adminRepository = adminRepository;
    }

    public ResponseEntity<String> signup (SignUpDto signUpDto) {
        System.out.println("signup");
        if (signUpDto.getRole()== Role.ADMIN) {
            System.out.println("No");
            return new ResponseEntity<>("can not register as an admin", HttpStatus.FORBIDDEN);
        }
        if (accountRepository.existsByEmail(signUpDto.getEmail())) {

            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
        Account account = Account.convert(signUpDto);
        account.setPassword(encoder.encode(account.getPassword()));
        return new ResponseEntity<>("Account saved", HttpStatus.OK);
    }


    public ResponseEntity<Object> login(String email, String password) {
        Account account;
        if ((account=accountRepository.findByEmail(email))!=null) {
            if (encoder.matches(password, account.getPassword())) {
                switch (account.getRole()) {
                    case ADOPTER -> {
                        if (adopterRepository.existsByAccount( account)) {
                            return new ResponseEntity<>(adopterRepository.getByAccount(account), HttpStatus.OK);
                        } else {
                            return new ResponseEntity<>("Account Not Found" , HttpStatus.NOT_FOUND);
                        }
                    } case STAFF -> {
                        if (staffRepository.existsByAccount(account)) {
                            return new ResponseEntity<>(staffRepository.getByAccount(account), HttpStatus.OK);
                        } else {
                            return new ResponseEntity<>("Account Not Found" , HttpStatus.NOT_FOUND);
                        }
                    } case ADMIN -> {
                        if (adminRepository.existsByAccount(account)) {
                            return new ResponseEntity<>(adminRepository.findByAccount(account), HttpStatus.OK);
                        } else {
                            return new ResponseEntity<>("Account Not Found" , HttpStatus.NOT_FOUND);
                        }
                    }
                }
            }
            else{
                return new ResponseEntity<>("Wrong Password" , HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>("Account Not Found" , HttpStatus.NOT_FOUND);
        }
        return null;
    }

}
