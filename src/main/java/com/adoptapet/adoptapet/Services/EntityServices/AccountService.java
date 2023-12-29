package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.AccountDto;
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
    private final PasswordEncoder encoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    public AccountDto getAccount(int accountId) {
        if (accountRepository.findById(accountId).isEmpty())
            throw new AccountNotFoundException();
        Account account = accountRepository.findById(accountId).get();
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

    public void register(AccountDto accountDto) {
        if (accountDto.getRole() == Role.ADMIN)
            throw new AccountRegisterAsAdminForbiddenException();
        if (accountRepository.findById(accountDto.getId()).isPresent())
            throw new AccountAlreadyExistsException();
        Account account = accountMapper.toEntity(accountDto);
        account.setPassword(encoder.encode(account.getPassword()));
        accountRepository.save(account);
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
