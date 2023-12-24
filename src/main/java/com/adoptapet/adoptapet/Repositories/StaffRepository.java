package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}