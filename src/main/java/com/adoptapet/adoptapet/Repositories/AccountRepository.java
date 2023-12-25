package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Checks if email exists
     * parameters: Email
     *
     * @return Boolean
     * */
    boolean existsByEmail(String email);
    Account findByEmail(String email);
}