package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionApplicationRepository extends JpaRepository<AdoptionApplication, AdoptionApplicationId> {
}