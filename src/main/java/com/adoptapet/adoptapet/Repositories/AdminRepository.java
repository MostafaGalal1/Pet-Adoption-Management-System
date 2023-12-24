package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}