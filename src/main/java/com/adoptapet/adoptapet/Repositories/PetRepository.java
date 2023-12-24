package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}