package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}