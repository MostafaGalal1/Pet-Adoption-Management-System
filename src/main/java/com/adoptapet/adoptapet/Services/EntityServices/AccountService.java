package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.AccountDto;
import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Account.Role;
import com.adoptapet.adoptapet.Exceptions.AccountExceptions.AccountAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.AccountExceptions.AccountInvalidPasswordException;
import com.adoptapet.adoptapet.Exceptions.AccountExceptions.AccountNotFoundException;
import com.adoptapet.adoptapet.Exceptions.AccountExceptions.AccountRegisterAsAdminForbiddenException;
import com.adoptapet.adoptapet.Mappers.AccountMapper;
import com.adoptapet.adoptapet.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final StaffService staffService;
    private final AdopterService adopterService;
    private final PasswordEncoder encoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper, StaffService staffService, AdopterService adopterService) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.staffService = staffService;
        this.adopterService = adopterService;
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    public AccountDto getAccount(String accountEmail) {
        if (accountRepository.findByEmail(accountEmail).isEmpty())
            throw new AccountNotFoundException();
        Account account = accountRepository.findByEmail(accountEmail).get();
        return accountMapper.toDto(account);
    }

    public void addAccount(AccountDto accountDto) {
        if (accountRepository.findById(accountDto.getId()).isPresent())
            throw new AccountAlreadyExistsException();
        Account account = accountMapper.toEntity(accountDto);
        accountRepository.save(account);
    }

    public void updateAccount(AccountDto accountDto) {
        if (accountRepository.findById(accountDto.getId()).isEmpty())
            throw new AccountNotFoundException();
        Account account = accountRepository.findById(accountDto.getId()).get();
        accountMapper.partialUpdate(accountDto, account);
        accountRepository.save(account);
    }

    public void deleteAccount(int accountId) {
        if (accountRepository.findById(accountId).isEmpty())
            throw new AccountNotFoundException();
        accountRepository.deleteById(accountId);
    }

    public void register(SignUpDto signUpDto) {
        if (signUpDto.getRole() == Role.ADMIN)
            throw new AccountRegisterAsAdminForbiddenException();
        if (accountRepository.findByEmail(signUpDto.getEmail()).isPresent())
            throw new AccountAlreadyExistsException();
        Account account = accountMapper.toEntity(signUpDto);
        account.setPassword(encoder.encode(account.getPassword()));
        accountRepository.save(account);
        signUpDto.setAccount(account);
        System.out.println(signUpDto);
        if (signUpDto.getRole() == Role.STAFF) staffService.addStaff(signUpDto);
        else if (signUpDto.getRole() == Role.ADOPTER) adopterService.add(signUpDto);
    }

    public int login(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        if (accountRepository.findByEmail(account.getEmail()).isEmpty())
            throw new AccountNotFoundException();
        Account existingAccount = accountRepository.findByEmail(account.getEmail()).get();
        if (!encoder.matches(account.getPassword(),existingAccount.getPassword()))
            throw new AccountInvalidPasswordException();
        return existingAccount.getId();
    }
}
