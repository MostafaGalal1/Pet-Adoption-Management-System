package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
}