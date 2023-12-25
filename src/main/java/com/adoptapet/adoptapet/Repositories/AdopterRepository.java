package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Integer> {

    boolean existsByAccount(Account account);

    Adopter getByAccount(Account account);
}