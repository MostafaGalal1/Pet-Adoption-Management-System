package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>, JpaSpecificationExecutor<Pet> {
    List<Pet> getPetsByBreedIgnoreCaseAndAdopted(String breed, boolean adopted);
    List<Pet> getPetsByAgeAndAdopted(int age, boolean adopted);
    List<Pet> getPetsBySpeciesIgnoreCaseAndAdopted(String species, boolean adopted);
    List<Pet> getPetsByShelterAndAdopted(Shelter shelter, boolean adopted);
    Pet findPetById(int id);
    List<Pet> findAllByShelterId(int shelterId);
    List<Pet> getPetsByBreedIgnoreCaseAndAdoptedAndShelterId(String breed, boolean adopted, int shelterId);
    List<Pet> getPetsByAgeAndAdoptedAndShelterId(int age, boolean adopted, int shelterId);
    List<Pet> getPetsBySpeciesAndAdoptedAndShelterId(String species, boolean adopted, int shelterId);
}