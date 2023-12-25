package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>, JpaSpecificationExecutor<Pet> {

    List<Pet> getPetsByBreedAndAdopted(String breed, boolean adopted);

    List<Pet> getPetsByAgeAndAdopted(int age, boolean adopted);

    List<Pet> getPetsBySpeciesAndAdopted(String species, boolean adopted);

    List<Pet> getPetsByShelterAndAdopted(Shelter shelter, boolean adopted);

    List<Pet> getPetsBy();

    Pet findPetById(int id);
}