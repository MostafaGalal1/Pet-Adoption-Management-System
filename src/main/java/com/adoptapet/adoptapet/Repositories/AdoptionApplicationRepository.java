package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionApplicationRepository extends JpaRepository<AdoptionApplication, AdoptionApplicationId> {
}