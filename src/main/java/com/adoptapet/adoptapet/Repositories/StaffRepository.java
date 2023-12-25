package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    boolean existsByAccount(Account account);

    Staff getByAccount(Account account);

    List<Staff> findAllByShelterId(int shelterId);
}